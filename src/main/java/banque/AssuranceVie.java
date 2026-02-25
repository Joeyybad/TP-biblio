package banque;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="assurance_vie")
public class AssuranceVie extends Compte {

    private LocalDate dateFin;
    private Double taux;

    public AssuranceVie() {
        super();
    }

    // Getters et Setters
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public Double getTaux() { return taux; }
    public void setTaux(Double taux) { this.taux = taux; }
}