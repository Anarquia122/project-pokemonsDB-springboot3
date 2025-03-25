package com.praticando.pokemonsDb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.praticando.pokemonsDb.entities.Pokemon;
import com.praticando.pokemonsDb.entities.Trainer;
import com.praticando.pokemonsDb.repositories.PokemonRepository;
import com.praticando.pokemonsDb.repositories.TrainerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Trainer t1 = new Trainer(null, "Ash Ketchum", 10);
		Trainer t2 = new Trainer(null, "Misty", 10);
		Trainer t3 = new Trainer(null, "Brock", 15);
		
		Pokemon p1 = new Pokemon(null, "Pikachu", Arrays.asList("Elétrico"));
		Pokemon p2 = new Pokemon(null, "Psyduck", Arrays.asList("Água"));
		Pokemon p3 = new Pokemon(null, "Onix", Arrays.asList("Pedra"));
		
		trainerRepository.saveAll(Arrays.asList(t1, t2, t3));
		pokemonRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
