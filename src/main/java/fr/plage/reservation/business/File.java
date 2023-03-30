package fr.plage.reservation.business;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class File {

	private Long id;
	private byte numero;
	private double prixJournalier;

}

