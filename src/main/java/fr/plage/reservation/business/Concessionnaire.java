package fr.plage.reservation.business;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Concessionnaire extends Utilisateur {
	private String numeroDeTelephone;

}
