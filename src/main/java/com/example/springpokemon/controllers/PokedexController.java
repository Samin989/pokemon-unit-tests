package com.example.springpokemon.controllers;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;
import com.example.springpokemon.services.PokedexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class PokedexController {
    private PokedexService pokeService = new PokedexService(new PokedexRepository());

    @GetMapping("index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/fire") 
    public ModelAndView getAllFire() throws SQLException {
        ModelAndView mav = new ModelAndView("fire");
        mav.addObject("firePokemons", pokeService.getAllFire());
        return mav;
    }

    @GetMapping("/type-select")
    public ModelAndView typeSelect(){
        ModelAndView mav = new ModelAndView("type-select");
        return mav;
    }

    @GetMapping("/single")
    public ModelAndView getSingleById(@RequestParam int id) throws SQLException {
        ModelAndView mav = new ModelAndView("single");
        Pokemon pokemon = null;
        pokemon = pokeService.getSingleById(id);
        mav.addObject("pokemon",pokemon);
        return mav;
    }
}