package fr.plage.reservation.service;

import fr.plage.reservation.business.Client;

import java.util.List;

public interface ClientService {
    List<Client> recupererClients();

    Client recupererClient(Long id);
}
