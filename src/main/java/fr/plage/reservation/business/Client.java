package fr.plage.reservation.business;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Client extends Utilisateur{
    private LocalDateTime dateHeureInscription;
}
