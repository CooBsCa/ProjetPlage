package fr.plage.reservation.business;


import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Client extends Utilisateur{
    private LocalDateTime dateHeureInscription;
}
