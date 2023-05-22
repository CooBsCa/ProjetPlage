package fr.plage.reservation.business;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    protected long id;
    @NonNull
    protected String nom;
    @NonNull
    protected String prenom;
    @NonNull
    protected String email;
    protected String motDePasse;
}
