package fr.plage.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservationApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

	//TODO : 1er juin 15 septembre
	//TODO : un client peut louer un ou plusieurs parasols pour une ou plusieurs journées
	//TODO : un parasol ne peut être loué que par un seul client par jour et la durée minimale de location est d'une journée
	//TODO : montant de location en fonction de la proxi avec la mer et du lien de parente


}
