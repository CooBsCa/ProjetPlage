package fr.plage.reservation.controller;

import fr.plage.reservation.business.Client;
import fr.plage.reservation.business.Reservation;
import fr.plage.reservation.dto.ClientDto;
import fr.plage.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
@Validated
public class ReservationRestController {
    private ReservationService reservationService;
    @GetMapping("reservations")
    public List<Reservation> getReservations() {
        return reservationService.recupererReservations();
    }

    @GetMapping("reservations/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.recupererReservation(id);
    }

    @PostMapping("reservations/{dateD}/{dateF}/{numeroCarte}/{moisExpiration}/{anneeExpiration}/{cryptogramme}/{parasolNumber}/{numeroFileEmplacement}/{idClient}")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Reservation postReservation(@PathVariable String dateD, @PathVariable String dateF,
                                       @PathVariable String numeroCarte, @PathVariable byte moisExpiration, @PathVariable int anneeExpiration,
                                       @PathVariable String cryptogramme, @PathVariable byte parasolNumber, @PathVariable long numeroFileEmplacement,
                                       @PathVariable Long idClient) {
        return reservationService.enregistrerReservation(dateD, dateF, numeroCarte, moisExpiration,
                anneeExpiration, cryptogramme, parasolNumber, numeroFileEmplacement,idClient);
    }
}
