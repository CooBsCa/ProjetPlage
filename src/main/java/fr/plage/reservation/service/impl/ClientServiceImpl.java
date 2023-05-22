package fr.plage.reservation.service.impl;

import fr.plage.reservation.business.Client;
import fr.plage.reservation.dao.ClientDao;
import fr.plage.reservation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;

    @Override
    public List<Client> recupererClients() {
        return clientDao.findAll();
    }

    @Override
    public Client recupererClient(Long id) {
        return clientDao.findById(id).orElse(null);
    }
}
