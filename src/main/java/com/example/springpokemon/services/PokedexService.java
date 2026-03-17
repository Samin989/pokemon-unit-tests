package com.example.springpokemon.services;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.IPokedexRepository;
import com.example.springpokemon.repositories.PokedexRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class PokedexService {
    private IPokedexRepository repo;

    public PokedexService(IPokedexRepository pokedexRepo){
        this.repo = pokedexRepo;
    }

    public List<Pokemon> getAllFire() throws SQLException {
        return repo.getALlFirePokemon();
    }

    public Pokemon getSingleById(int id) throws SQLException {
        Pokemon returnPokemon  = repo.getSingleById(id);
        if(returnPokemon == null){
            throw new NoSuchElementException();
        }
        return returnPokemon;
    }

    public String getArchetype(int id) throws SQLException {
        Pokemon pokemon = getSingleById(id);
        int offence = pokemon.getAttack() + pokemon.getSpeed() + pokemon.getSpecialAttack();
        int defence = pokemon.getHp() + pokemon.getDefence() + pokemon.getSpecialDefence();

        if(offence > defence){
            return "Aggressive";
        } else if (offence < defence) {
            return "Defensive";
        }
        return "Balanced";
    }
}
