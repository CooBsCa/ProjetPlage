package fr.plage.reservation.business;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
public class LienDeParente {
    @Id
    private Long id;
    private String nom;
    private float coefficient;
}
