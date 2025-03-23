package com.praticando.pokemonsDb.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticando.pokemonsDb.entities.Trainer;

@RestController
@RequestMapping(value = "/trainers")
public class TrainerResource {

	@GetMapping
	public ResponseEntity<Trainer> findAll() {
		Trainer t = new Trainer(1, "Ash", 11);
		return ResponseEntity.ok().body(t);
	}
}
