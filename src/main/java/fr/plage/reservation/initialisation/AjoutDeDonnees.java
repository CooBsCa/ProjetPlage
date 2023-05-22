package fr.plage.reservation.initialisation;

import fr.plage.reservation.business.*;
import fr.plage.reservation.dao.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class AjoutDeDonnees implements CommandLineRunner {

    private final FileDao fileDao;
    private final ParasolDao parasolDao;
    private final LienDeParenteDao lienDeParenteDao;
    private final StatutDao statutDao;
    private final PaysDao paysDao;
    private final ClientDao clientDao;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 7; i++) {
            File file = new File();
            file.setNumero((byte) (i +1));
            fileDao.save(file);
            for (int j = 0; j < 8; j++){
                Parasol parasol = new Parasol();
                parasol.setFile(file);
                parasol.setNumEmplacement((byte) (j+1));
                parasolDao.save(parasol);
            }
        }
        lienDeParenteDao.save(new LienDeParente("Frere/Soeur",(float)0.5));
        lienDeParenteDao.save(new LienDeParente("Cousin/Cousine",(float)0.25));
        lienDeParenteDao.save(new LienDeParente("Aucun Lien",(float)1));

        paysDao.save(new Pays("France"));
        paysDao.save(new Pays("Espagne"));
        paysDao.save(new Pays("Italie"));
        paysDao.save(new Pays("Allemagne"));
        paysDao.save(new Pays("Angleterre"));
        
        statutDao.save(new Statut("À traiter"));
        statutDao.save(new Statut("Refusée"));
        statutDao.save(new Statut("Confirmée"));

        LocalDateTime date = LocalDateTime.now();

        Client client1 = new Client();
        client1.setNom("DUPONT");
        client1.setPrenom("Jean");
        client1.setEmail("dupontjean@gmail.com");
        client1.setDateHeureInscription(date);
        clientDao.save(client1);
        Client client2 = new Client();
        client2.setNom("DURAND");
        client2.setPrenom("Pierre");
        client2.setEmail("durandpierre@gmail.com");
        client2.setDateHeureInscription(date);
        clientDao.save(client2);
    }
}
