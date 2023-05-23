package fr.plage.reservation.service.impl;

import fr.plage.reservation.business.Concessionnaire;
import fr.plage.reservation.business.Parasol;
import fr.plage.reservation.business.Reservation;
import fr.plage.reservation.dao.*;
import fr.plage.reservation.exception.ClientDejaPresentException;
import fr.plage.reservation.exception.ClientInexistantException;
import fr.plage.reservation.exception.ParasolDejaReserve;
import fr.plage.reservation.exception.ParasolInexistant;
import fr.plage.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @NonNull
    private ReservationDao reservationDao;
    @NonNull
    private ParasolDao parasolDao;
    @NonNull
    private final FileDao fileDao;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
    private final LienDeParenteDao lienDeParenteDao;
    private final ClientDao clientDao;

    @Override
    public List<Reservation> recupererReservations() {return reservationDao.findAll();}

    @Override
    public Reservation recupererReservation(Long id) {return reservationDao.findById(id).orElse(null);}

    @Override
    public Reservation enregistrerReservation(String dateDebut, String dateFin,
        String numeroCarte, byte moisExpiration, int anneeExpiration, String cryptogramme, byte parasolNumber,
        long numeroFileEmplacement, Long idClient) {
        LocalDate dateD = LocalDate.parse(dateDebut, formatter);
        LocalDate dateF = LocalDate.parse(dateFin, formatter);
        List<Parasol> parasols = new ArrayList<Parasol>();
        Parasol parasol = parasolDao.findByFileAndNumEmplacement(fileDao.getReferenceById(numeroFileEmplacement), parasolNumber);
        if (parasol == null){
            throw new ParasolInexistant("Ce parasol n'existe pas ou est introuvable");
        }
        parasol.getReservation().forEach(reservation -> {
            if (reservation.getDateDebut().equals(dateF) || reservation.getDateFin().equals(dateD)
            || (dateD.isAfter(reservation.getDateDebut())
                    || dateF.isBefore(reservation.getDateFin()))){
                throw new ParasolDejaReserve("Ce parasol est deja reserve à ses dates");
            }
        });

        if (clientDao.findById(idClient) == null){
            throw new ClientInexistantException("Ce client n'existe pas ou est introuvable");
        }

        Reservation reservation1 = new Reservation();
        reservation1.setClient(clientDao.getReferenceById(idClient));
        reservation1.setDateDebut(dateD);
        reservation1.setDateFin(dateF);
        reservation1.setNumeroCarte(numeroCarte);
        reservation1.setMoisExpiration(moisExpiration);
        reservation1.setAnneeExpiration(anneeExpiration);
        reservation1.setCryptogramme(cryptogramme);
        parasols.add(parasol);
        reservation1.setParasols(parasols);
        reservation1.setMontantAReglerEnEuros();
        return reservationDao.save(reservation1);
    }
}
