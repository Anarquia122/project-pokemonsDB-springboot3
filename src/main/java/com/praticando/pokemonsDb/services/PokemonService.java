package com.praticando.pokemonsDb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.praticando.pokemonsDb.entities.Pokemon;
import com.praticando.pokemonsDb.repositories.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository repository;
	
	public List<Pokemon> findAll() {
		return repository.findAll();
	}
	
	public Pokemon findById(Long id) {
		Optional<Pokemon> obj = repository.findById(id);
		return obj.get();
	}
}
