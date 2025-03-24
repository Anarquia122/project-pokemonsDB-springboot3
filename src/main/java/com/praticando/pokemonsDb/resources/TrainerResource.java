package com.praticando.pokemonsDb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticando.pokemonsDb.entities.Trainer;
import com.praticando.pokemonsDb.services.TrainerService;

@RestController
@RequestMapping(value = "/trainers")
public class TrainerResource {

	@Autowired
	private TrainerService service;
	
	@GetMapping
	public ResponseEntity<List<Trainer>> findAll() {
		List<Trainer> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trainer> findById(@PathVariable Long id) {
		Trainer obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
