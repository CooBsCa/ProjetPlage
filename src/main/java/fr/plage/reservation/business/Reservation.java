package fr.plage.reservation.business;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    private long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double montantAReglerEnEuros;
    private String remarques;
    private String numeroCarte;
    private byte moisExpiration;
    private byte anneeExpiration;
    private String cryptogramme;
    @ManyToOne
    private Client client;

    @ManyToOne
    private Statut statut;

    @ManyToOne
    private Concessionnaire concessionnaire;
}
