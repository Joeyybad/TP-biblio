package fr.epsib3_2526;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "LIVRE")
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

    @ManyToMany
    @JoinTable(
        name = "COMPO",
        joinColumns = @JoinColumn(name = "ID_LIV"),
        inverseJoinColumns = @JoinColumn(name = "ID_EMP")
    )
    private List<Emprunt> emprunts;

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

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}