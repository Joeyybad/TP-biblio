// Pour éviter de versionner les credentials

package fr.epsib3_2526;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JPAUtils {
    public static EntityManagerFactory createEntityManagerFactory() {
        Map<String, String> envProps = new HashMap<>();

        // On récupère les variables d'environnement
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASS");

        // Si elles existent, on les injecte
        if (user != null) envProps.put("jakarta.persistence.jdbc.user", user);
        if (pass != null) envProps.put("jakarta.persistence.jdbc.password", pass);

        System.out.println("Chemin du fichier : " +
                Thread.currentThread().getContextClassLoader().getResource("META-INF/persistence.xml"));

        return Persistence.createEntityManagerFactory("maPU", envProps);
    }
}