package fr.plage.reservation.business;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Utilisateur {
    @Id
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

}
