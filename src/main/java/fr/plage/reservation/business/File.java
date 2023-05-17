package fr.plage.reservation.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class File {
	@Id
	private Long id;
	private byte numero;
	private double prixJournalier;
	@OneToMany(mappedBy = "file")
	private List<Parasol> parasols;

}

