package com.example.springpokemon.services;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PokedexServiceTest {

    private PokedexRepository mockRepo;
    private PokedexService service;

    @BeforeEach
    void setUp() {
        mockRepo = mock(PokedexRepository.class);
        service = new PokedexService(mockRepo);
    }

    @Test
    void getArchetype_returnsAggressive() throws SQLException {
        //Arrange
        // offence: attack(84) + speed(100) + specialAttack(109) = 293
        // defence: hp(78) + defence(78) + specialDefence(85) = 241
        Pokemon pokemon = new Pokemon(6, "Charizard", 100, 85, 109, 78, 84, 78, "Fire", "Flying");
        when(mockRepo.getSingleById(6)).thenReturn(pokemon);
        //Act
        String result = service.getArchetype(6);
        //Assert
        assertEquals("Aggressive", result);
    }

    @Test
    void getArchetype_returnsDefensive() throws SQLException {
        //Arrange
        // offence: attack(95) + speed(70) + specialAttack(85) = 250
        // defence: hp(50) + defence(180) + specialDefence(45) = 275
        Pokemon pokemon = new Pokemon(91, "Cloyster", 70, 45, 85, 180, 95, 50, "Water", "Ice");
        when(mockRepo.getSingleById(91)).thenReturn(pokemon);
        //Act
        String result = service.getArchetype(91);
        //assert
        assertEquals("Defensive", result);
    }

    @Test
    void getArchetype_returnsBalanced() throws SQLException {
        //Arrange
        // offence: attack(100) + speed(100) + specialAttack(100) = 300
        // defence: hp(100) + defence(100) + specialDefence(100) = 300
        Pokemon pokemon = new Pokemon(151, "Mew", 100, 100, 100, 100, 100, 100, "Psychic", "");
        when(mockRepo.getSingleById(151)).thenReturn(pokemon);
        //Act
        String result = service.getArchetype(151);
        //Assert
        assertEquals("Balanced", result);
    }
}