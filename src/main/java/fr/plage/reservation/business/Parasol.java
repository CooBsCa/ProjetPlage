package fr.plage.reservation.business;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Parasol {
	@Id
	private Long id;
	private byte numEmplacement;

}
