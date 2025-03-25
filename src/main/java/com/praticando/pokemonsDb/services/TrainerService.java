package com.praticando.pokemonsDb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praticando.pokemonsDb.entities.Trainer;
import com.praticando.pokemonsDb.repositories.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository repository;
	
	public List<Trainer> findAll() {
		return repository.findAll();
	}
	
	public Trainer findById(Long id) {
		Optional<Trainer> obj = repository.findById(id);
		return obj.get();
	}
	
	public Trainer insert(Trainer obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Trainer update(Long id, Trainer obj) {
		Trainer entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Trainer entity, Trainer obj) {
		entity.setName(obj.getName());
		entity.setAge(obj.getAge());
	}
}
