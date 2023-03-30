package fr.plage.reservation.business;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class File {
	@Id
	private Long id;
	private byte numero;
	private double prixJournalier;

}

