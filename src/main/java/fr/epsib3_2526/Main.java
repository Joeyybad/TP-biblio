package fr.epsib3_2526;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = JPAUtils.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        int recherche = 1;
        try {

            // Lecture d'un livre

            //Livre livre1 = em.find(Livre.class, recherche);
            //System.out.println("Livre trouvé : " + livre1.getTitre()+ "auteur" + livre1.getAuteur());

            //Ajouter un livre

            //em.getTransaction().begin();
            //Livre l2= new Livre();
            //l2.setTitre("Game Of Thrones");
            //l2.setAuteur("G RR Martins");
            //em.persist(l2);
            //em.getTransaction().commit();

            //Modifier le titre du livre avec l'ID5

            //em.getTransaction().begin();
            //Livre l3 = em.find(Livre.class, 5);
            //if (l3!= null){
                //l3.setTitre("Du plaisir dans la cuisine");
            //}
            //em.getTransaction().commit();

            // Requêtes JPQL

            //TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre='Apprendre à parler aux animaux'", Livre.class);

            //List<Livre> livresTrouves = query.getResultList();

            //for (Livre l : livresTrouves) {
                //System.out.println("Livre trouvé : " + l.getTitre());
            //}

            //TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.auteur='G RR Martins'", Livre.class);

            //List<Livre> livresAuteurTrouves = query2.getResultList();

            //for (Livre l : livresAuteurTrouves) {
                //System.out.println("Auteur trouvé : " + l.getAuteur());
            //}

            // Requêtes suppression Livre
            //em.getTransaction().begin();
            //Livre l4= em.find(Livre.class, 2);
            //if(l4!= null){
                //em.remove(l4);
            //}
            //em.getTransaction().commit();

            TypedQuery<Livre> queryAll = em.createQuery("SELECT l FROM Livre l", Livre.class);

            List<Livre> tousLesLivres = queryAll.getResultList();

            System.out.println(" les livres présents en base : ");
            if (tousLesLivres.isEmpty()) {
                System.out.println("Aucun");
            } else {
                for (Livre l : tousLesLivres) {
                    System.out.println( " Titre: " + l.getTitre() + " de  Auteur: " + l.getAuteur());
                }
            }


        } catch (Exception e){
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