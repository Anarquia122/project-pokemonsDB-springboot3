package com.praticando.pokemonsDb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.praticando.pokemonsDb.entities.Trainer;
import com.praticando.pokemonsDb.repositories.TrainerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private TrainerRepository trainerRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Trainer t1 = new Trainer(null, "Ash Ketchum", 10);
		Trainer t2 = new Trainer(null, "Misty", 10);
		Trainer t3 = new Trainer(null, "Brock", 15);
		
		trainerRepository.saveAll(Arrays.asList(t1, t2, t3));
	}

}
