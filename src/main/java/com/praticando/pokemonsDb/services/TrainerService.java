package com.praticando.pokemonsDb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.praticando.pokemonsDb.entities.Trainer;
import com.praticando.pokemonsDb.repositories.TrainerRepository;
import com.praticando.pokemonsDb.services.exceptions.DatabaseException;
import com.praticando.pokemonsDb.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository repository;
	
	public List<Trainer> findAll() {
		return repository.findAll();
	}
	
	public Trainer findById(Long id) {
		Optional<Trainer> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Trainer insert(Trainer obj) {
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
	
	public Trainer update(Long id, Trainer obj) {
		try {
			Trainer entity = repository.getReferenceById(id);
			updateDate(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDate(Trainer entity, Trainer obj) {
		entity.setName(obj.getName());
		entity.setAge(obj.getAge());
	}
}
