package fr.epsib3_2526;

import jakarta.persistence.*;

@Entity
@Table(name = "livre")
public class Livre {
    public Livre(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "auteur")
    private String auteur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}