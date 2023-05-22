package fr.plage.reservation.business;


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
    @NonNull
    private LocalDateTime dateHeureInscription;
    @ManyToOne
    private Pays pays;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
    @ManyToOne
    private LienDeParente lienDeParente;
}
