package fr.plage.reservation.service;

import fr.plage.reservation.business.Reservation;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    List<Reservation> recupererReservations();

    Reservation recupererReservation(Long id);

    Reservation enregistrerReservation( String dateD,  String dateF,
                                         String numeroCarte,  byte moisExpiration,  int anneeExpiration,
                                         String cryptogramme,  byte parasolNumber, long numeroFileEmplacement, Long idClient);
}
