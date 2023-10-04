package org.java.app;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//		String nome, String descrizione, String foto, float prezzo
		Pizza margherita = new Pizza("margherita", "pomodoro, mozzarella, basilico", "url-foto-margherita", 6.50f);
		Pizza diavola = new Pizza("diavola", "pomodoro, mozzarella, salame piccante", "url-foto-diavola", 8.50f);
		Pizza ortolana = new Pizza("ortolana", "mozzarella, peperoni, melanzane, zucchine", "url-foto-ortolana", 7.50f);
		
		pizzaService.save(margherita);
		pizzaService.save(diavola);
		pizzaService.save(ortolana);
		
		System.out.println("Insert OK!");
	}
	

}
