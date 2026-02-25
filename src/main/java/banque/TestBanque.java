package banque;
import fr.epsib3_2526.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;

public class TestBanque {
    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtils.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Création de l'adresse (Embeddable)
            Adresse adresse = new Adresse("17 rue Gambetta", "72000", "Le Mans");

            // Création du Client 1
            Client client1 = new Client("Nkunga", "Jordan", LocalDate.of(1993, 6, 9));
            client1.setAdresse(adresse);

            // Création du Client 2
            Client client2 = new Client("Henne", "Manon", LocalDate.of(1995, 3, 31));
            client2.setAdresse(adresse);

            // Création de la Banque
            BanqueClass maBanque = new BanqueClass("BNP Paribas");

            // Livret A (Héritage JOINED)
            LivretA compteJoint = new LivretA();
            compteJoint.setSolde(10000.0);
            compteJoint.setTaux(3.0);

            // liaison des 2 clients au meme livreta
            client1.getComptes().add(compteJoint);
            client2.getComptes().add(compteJoint);

            //bi-directionnel
            compteJoint.getClients().add(client1);
            compteJoint.getClients().add(client2);

            // Création d'un compte type assurance vie
            AssuranceVie av = new AssuranceVie();
            av.setSolde(1000.0);
            av.setTaux(2.0);
            av.setDateFin(LocalDate.of(2028,12,31));

            // Faire la relation on ajoute l'assurancevie au compte client1 bi-directionnel
            client1.getComptes().add(av);
            // relation bi directionnel
            av.getClients().add(client1);

            // Virement (Héritage SINGLE_TABLE)
            Virement virement = new Virement();
            virement.setDate(LocalDate.now());
            virement.setMontant(150.0);
            virement.setMotif("Cadeau");
            virement.setBeneficiaire("Jordan Nkunga");

            // Liaison Virement -> Compte
            virement.setCompte(compteJoint);

            // Operation (Héritage SINGLE_TABLE)
            OperationStandard retrait = new OperationStandard();
            retrait.setDate(LocalDate.now());
            virement.setMontant(-10.0);
            virement.setMotif("Cotisation");
            virement.setBeneficiaire("Jordan Nkunga");

            // Liaison OperationStandard -> AssuranceVie
            retrait.setCompte(av);



            // persistance des objets
            em.persist(maBanque);
            em.persist(compteJoint);
            em.persist(av);
            em.persist(client1);
            em.persist(client2);
            em.persist(virement);

            em.getTransaction().commit();

            // Affichage
            System.out.println("Enregistrement réussi !");
            System.out.println("Le client " + client1.getNom() + " possède un Livret A (joint) et une Assurance Vie.");
            System.out.println("Le client " + client2.getNom() + " possède un Livret A (joint).");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}