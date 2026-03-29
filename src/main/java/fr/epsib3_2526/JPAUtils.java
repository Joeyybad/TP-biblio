package fr.epsib3_2526;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JPAUtils {
    private static EntityManagerFactory emf = null;
    
    public static EntityManagerFactory createEntityManagerFactory() {
        Map<String, String> envProps = new HashMap<>();

        // On récupère les variables d'environnement
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASS");

        // Si elles existent, on les injecte
        if (user != null) envProps.put("jakarta.persistence.jdbc.user", user);
        if (pass != null) envProps.put("jakarta.persistence.jdbc.password", pass);

        return Persistence.createEntityManagerFactory("maPU", envProps);
    }
    
    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = createEntityManagerFactory();
        }
        return emf.createEntityManager();
    }
    
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}