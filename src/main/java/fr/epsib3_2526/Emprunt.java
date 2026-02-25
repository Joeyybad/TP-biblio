package fr.epsib3_2526;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "emprunt")
public class Emprunt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    @Column(name = "DATE_DEBUT", nullable = false)
    private LocalDateTime dateDebut;
    @Column(name = "DATE_FIN", nullable = true)
    private LocalDateTime dateFin;
    @Column(name = "DELAI", nullable = false)
    private Integer delai;

    @Column(name = "delai_max", nullable = false)
    private Integer delaiMax;


    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "compo",
            joinColumns = @JoinColumn(name ="ID_EMP"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV")
    )
    private Set<Livre> livres;

    public Emprunt(){
    }

    public Emprunt(LocalDateTime dateDebut, LocalDateTime dateFin,Integer delai, Integer delaiMax, Client client, Set<Livre> livres){
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.delaiMax = delaiMax;
        this.client = client;
        this.livres = livres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Integer getDelaiMax() {
        return delaiMax;
    }

    public void setDelaiMax(Integer delaiMax) {
        this.delaiMax = delaiMax;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}
