package fr.plage.reservation.business;


import fr.plage.reservation.dao.PaysDao;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Client extends Utilisateur{
    private LocalDateTime dateHeureInscription;
    @ManyToOne
    private Pays pays;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
    @ManyToOne
    private LienDeParente lienDeParente;

    public Client(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        LocalDateTime date = LocalDateTime.now();
        this.dateHeureInscription = date;
    }
}
