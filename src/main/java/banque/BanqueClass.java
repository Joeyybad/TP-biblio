package banque;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="banque")
public class BanqueClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nom")
    private String nom;

    public BanqueClass() {
    }

    public BanqueClass(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}