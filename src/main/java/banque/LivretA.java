package banque;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="livret_a")
public class LivretA extends Compte {
    private Double taux;

    public LivretA() {}

    public Double getTaux() { return taux; }
    public void setTaux(Double taux) { this.taux = taux; }
}
