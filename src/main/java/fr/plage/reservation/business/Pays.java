package fr.plage.reservation.business;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pays {
    @Id
    private String code;
    private String nom;
    @OneToMany(mappedBy = "pays")
    private List<Client> clients;
}
