package fr.epsib3_2526;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name="ClientBiblio")
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Emprunt> emprunts = new HashSet<>();
    {emprunts = new HashSet<>();}

    public Client(){
    }

    public Client (String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

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

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
    public void addEmprunt(Emprunt emprunt) {
        if (emprunt != null){
            emprunt.setClient(this);
        }
    }

    public void removeEmprunt(Emprunt emprunt) {
        if (emprunt != null){
            emprunt.setClient(null);
        }
    }
}
