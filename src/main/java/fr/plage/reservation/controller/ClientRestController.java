package fr.plage.reservation.controller;

import fr.plage.reservation.business.Client;
import fr.plage.reservation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
@Validated
public class ClientRestController {

    private ClientService clientService;
    @GetMapping("clients")
    public List<Client> getClients() {
        return clientService.recupererClients();
    }

    @GetMapping("clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.recupererClient(id);
    }
}
