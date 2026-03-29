package fr.epsib3_2526;
import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {
    public Client() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
