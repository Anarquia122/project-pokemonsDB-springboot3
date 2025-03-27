package com.praticando.pokemonsDb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.praticando.pokemonsDb.entities.Pokemon;
import com.praticando.pokemonsDb.repositories.PokemonRepository;
import com.praticando.pokemonsDb.services.exceptions.DatabaseException;
import com.praticando.pokemonsDb.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository repository;
	
	public List<Pokemon> findAll() {
		return repository.findAll();
	}
	
	public Pokemon findById(Long id) {
		Optional<Pokemon> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Pokemon insert(Pokemon obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Pokemon update(Long id, Pokemon obj) {
		try {
			Pokemon entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Pokemon entity, Pokemon obj) {
		entity.setName(obj.getName());
		entity.setTypes(obj.getTypes());
	}
}
