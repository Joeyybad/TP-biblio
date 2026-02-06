package fr.epsib3_2526;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args){
        EntityManagerFactory emf = JPAUtils.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        int idRecherche = 2 ;

        //try {
            //Emprunt emp = em.find(Emprunt.class, idRecherche);
            //if(emp != null){
               // System.out.println(" Debut de l'emprunt:" + emp.getDateDebut());
                //System.out.println(" Livre associés :");
                //for (Livre l : emp.getLivres()){
                    //System.out.println( "Titre : "+l.getTitre()+" Auteur : "+ l.getAuteur());
                //}
            //}
            try {
                TypedQuery<Emprunt> queryAll = em.createQuery("SELECT e FROM Emprunt e", Emprunt.class);

                List<Emprunt> tousLesEmprunts = queryAll.getResultList();

                System.out.println(" Tous les emprunts présents en base : ");
                if (((List<?>) tousLesEmprunts).isEmpty()) {
                    System.out.println("Aucun emprunt trouvé.");
                } else {
                    for (Emprunt e : tousLesEmprunts) {
                        // Affichage de la date de l'emprunt
                        System.out.println("Emprunt du : " + e.getDateDebut());

                        // Pour afficher les titres, on doit boucler sur la liste des livres de l'emprunt
                        System.out.print("  Livres empruntés : ");
                        for (Livre l : e.getLivres()) {
                            System.out.print("[" + l.getTitre() + "] ");
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Important pour libérer la base de données
                if (em != null) em.close();
                if (emf != null) emf.close();
            }
    }
}
