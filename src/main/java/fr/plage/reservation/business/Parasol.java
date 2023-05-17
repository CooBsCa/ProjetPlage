package fr.plage.reservation.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Parasol {
	@Id
	private Long id;
	private byte numEmplacement;
	@ManyToOne
	private File file;

}
