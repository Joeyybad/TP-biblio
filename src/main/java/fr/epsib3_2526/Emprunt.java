package fr.epsib3_2526;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "emprunt")
public class Emprunt {
    public Emprunt(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_debut", nullable = false)
    private java.time.LocalDateTime dateDebut;

    @Column(name = "delai_max", nullable = false)
    private Integer delaiMax;

    @Column(name = "date_fin", nullable = false)
    private java.time.LocalDateTime dateFin;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV")
    )
    private List<Livre> livres = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

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

    public Integer getDelaiMax() {
        return delaiMax;
    }

    public void setDelaiMax(Integer delaiMax) {
        this.delaiMax = delaiMax;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}
