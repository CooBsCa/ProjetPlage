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
    protected long id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
}
