package fr.plage.reservation.service.impl;

import fr.plage.reservation.business.Client;
import fr.plage.reservation.dao.ClientDao;
import fr.plage.reservation.dao.LienDeParenteDao;
import fr.plage.reservation.dao.PaysDao;
import fr.plage.reservation.dao.ReservationDao;
import fr.plage.reservation.dto.ClientDto;
import fr.plage.reservation.exception.ClientDejaPresentException;
import fr.plage.reservation.exception.ClientInexistantException;
import fr.plage.reservation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    private ReservationDao reservationDao;

    @Override
    public List<Client> recupererClients() {
        return clientDao.findAll();
    }
    @Override
    public Client recupererClient(Long id) {
        return clientDao.findById(id).orElse(null);
    }

    @Override
    public Client enregistrerClient(String nom, String prenom, String email, String motDePasse) {
        Client client = new Client(nom, prenom, email, motDePasse);
        Client search = clientDao.findByNom(client.getNom());
        if ((search==null)|| search.getPrenom()!=client.getPrenom() || search.getEmail() != client.getEmail()){
            return clientDao.save(client);
        }
        else {
            throw new ClientDejaPresentException("Ce client est déja présent");
        }
    }

    @Override
    public Client mettreAJourClient(ClientDto clientDto) {
        Client client = new Client(clientDto.getNom(), clientDto.getPrenom(), clientDto.getEmail(), clientDto.getMotDePasse());
        client.setId(clientDto.getId());
        return mettreAJourClient(client);
    }

    @Override
    public Client mettreAJourClient(Client client) {
        if (client.getId() == null) {
            throw new ClientInexistantException("Il manque l'id de l'éditeur");
        }
        Client editeurAModifier = clientDao.findById(client.getId()).orElseThrow(() -> new ClientInexistantException("Cet éditeur n'existe pas"));

        if (client.getId().equals(editeurAModifier.getId())) {
            return clientDao.save(client);
        }
        else {
            return enregistrerClient(client.getNom(), client.getPrenom(), client.getEmail(), client.getMotDePasse());
        }
    }

    @Override
    public boolean supprimerClient(Long id) {
        Client client = recupererClient(id);
        if (client.getReservations() != null) {
            client.getReservations().forEach(reservation -> reservationDao.delete(reservation));
        }
        if (client!=null) {
            clientDao.delete(client);
            return true;
        }
        return false;
    }
}
