package fr.plage.reservation.controller;

import fr.plage.reservation.business.Client;
import fr.plage.reservation.business.LienDeParente;
import fr.plage.reservation.dto.ClientDto;
import fr.plage.reservation.exception.ClientDejaPresentException;
import fr.plage.reservation.exception.ClientInexistantException;
import fr.plage.reservation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @PostMapping("clients/{nom}/{prenom}/{email}/{motDePasse}")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Client postClient(@PathVariable String nom, @PathVariable String prenom, @PathVariable String email, @PathVariable String motDePasse) {
        return clientService.enregistrerClient(nom, prenom, email, motDePasse);
    }
    @PutMapping("clients")
    public Client putClient(@RequestBody ClientDto clientDto) {
        return clientService.mettreAJourClient(clientDto);
    }

    @DeleteMapping("clients/{id}")
    public boolean deleteClient(@PathVariable Long id) {
        return clientService.supprimerClient(id);
    }

    @ExceptionHandler(ClientDejaPresentException.class)
    @ResponseStatus(code=HttpStatus.CONFLICT)
    public String traiterClientDejaPresent(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(ClientInexistantException.class)
    @ResponseStatus(code=HttpStatus.CONFLICT)
    public String traiterClientInexistant(Exception e) {
        return e.getMessage();
    }
}
