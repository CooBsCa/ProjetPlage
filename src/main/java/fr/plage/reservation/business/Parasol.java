package fr.plage.reservation.business;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Parasol {

	private Long id;

	private byte numEmplacement;

}
