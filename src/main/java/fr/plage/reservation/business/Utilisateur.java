package fr.plage.reservation.business;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
}
