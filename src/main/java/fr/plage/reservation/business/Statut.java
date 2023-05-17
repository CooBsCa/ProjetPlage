package fr.plage.reservation.business;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Statut {
	@Id
	private Long id;
	private String nom;
}
