package com.praticando.pokemonsDb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticando.pokemonsDb.entities.Pokemon;
import com.praticando.pokemonsDb.services.PokemonService;

@RestController
@RequestMapping(value = "/pokemons")
public class PokemonResource {
	
	@Autowired
	private PokemonService service;
	
	@GetMapping
	public ResponseEntity<List<Pokemon>> findAll() {
		List<Pokemon> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pokemon> findById(@PathVariable Long id) {
		Pokemon obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
