package com.example.springpokemon.repositories;

import com.example.springpokemon.models.Pokemon;

import java.sql.SQLException;
import java.util.List;

public interface IPokedexRepository {
    public List<Pokemon> getALlFirePokemon() throws SQLException;
    public Pokemon getSingleById(int id) throws SQLException;
}
