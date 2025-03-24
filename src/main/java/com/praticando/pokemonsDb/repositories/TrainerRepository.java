package com.praticando.pokemonsDb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticando.pokemonsDb.entities.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
