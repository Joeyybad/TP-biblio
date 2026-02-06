package fr.epsib3_2526;
import jakarta.persistence.*;



public class TestBibliotheque {
    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtils.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        // Requête 1 : Extraire un emprunt et tous ses livres associés
        int empruntId = 1; // Remplacez par l'ID de l'emprunt que vous souhaitez extraire
        Emprunt emprunt = em.find(Emprunt.class, empruntId);
        if (emprunt != null) {
            System.out.println("Emprunt ID: " + emprunt.getId());
            System.out.println("Date d'emprunt: " + emprunt.getDateDebut());
            System.out.println("Livres associés:");
            for (Livre livre : emprunt.getLivres()) {
                System.out.println("- " + livre.getTitre() + " par " + livre.getAuteur());
            }
        } else {
            System.out.println("Emprunt avec ID " + empruntId + " non trouvé.");
        }

        // Requête 2 : Extraire tous les emprunts d'un client donné
        int clientId = 1; // Remplacez par l'ID du client dont vous souhaitez extraire les emprunts
        Client client = em.find(Client.class, clientId);
        if (client != null) {
            System.out.println("Client: " + client.getNom() + " " + client.getPrenom());
            System.out.println("Emprunts du client:");
            TypedQuery<Emprunt> query = em.createQuery(
                "SELECT e FROM Emprunt e WHERE e.idClient = :clientId", Emprunt.class);
            query.setParameter("clientId", clientId);
            for (Emprunt e : query.getResultList()) {
                System.out.println("- Emprunt ID: " + e.getId() + ", Date: " + e.getDateDebut());
            }
        } else {
            System.out.println("Client avec ID " + clientId + " non trouvé.");
        }

        em.close();
        emf.close();


    }

}
