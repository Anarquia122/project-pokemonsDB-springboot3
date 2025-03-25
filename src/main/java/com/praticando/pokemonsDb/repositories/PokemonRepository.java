package com.praticando.pokemonsDb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticando.pokemonsDb.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
