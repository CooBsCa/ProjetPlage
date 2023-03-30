package fr.plage.reservation.business;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Statut {
	private Long id;
	private String nom;

}
