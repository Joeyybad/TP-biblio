package banque;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "numero")
    private String numero;

    @Column(name = "solde")
    private Double solde;
    @ManyToMany(mappedBy = "comptes") //Pour faire la relation bi directionnelle sans faire comme dans client
    private final Set<Client> clients = new HashSet<>();

    public Compte() {
    }

    public Compte(Double solde) {
        this.solde = solde;
    }

    // Getters et Setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }
}


