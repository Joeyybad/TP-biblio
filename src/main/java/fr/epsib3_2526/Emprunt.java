package fr.epsib3_2526;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "DATE_DEBUT", nullable = false)
    private LocalDateTime dateDebut;
    
    @Column(name = "DATE_FIN")
    private LocalDateTime dateFin;
    
    @Column(name = "DELAI")
    private Integer delai;
    
    @Column(name = "ID_CLIENT", nullable = false)
    private Integer idClient;

    @ManyToMany(mappedBy = "emprunts")
    private List<Livre> livres;

    public Emprunt() {
    }
    public Emprunt(Integer id, LocalDateTime dateDebut, LocalDateTime dateFin, Integer delai, Integer idClient) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.idClient = idClient;
    }
    public Integer getId() {
        return id;
    }
    public Date getDateEmprunt() {
        return java.sql.Timestamp.valueOf(dateDebut);
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

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}
