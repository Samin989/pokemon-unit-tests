package com.example.springpokemon.models;

public class Pokemon {
    private int pokedexNumber;
    private String name;

    private int speed;
    private int specialDefence;
    private int specialAttack;
    private int defence;
    private int attack;
    private int hp;

    private final String primaryType;
    private String secondaryType;

    public Pokemon(int pokedexNumber, String name, int speed, int specialDefence, int specialAttack, int defence, int attack, int hp, String primaryType, String secondaryType) {
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.speed = speed;
        this.specialDefence = specialDefence;
        this.specialAttack = specialAttack;
        this.defence = defence;
        this.attack = attack;
        this.hp = hp;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
    }

    public Pokemon(int pokedexNumber, String name, String primaryType){
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.primaryType = primaryType;
    }


    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpecialDefence() {
        return specialDefence;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public int getTotalStats() {
        return hp + attack + defence + specialAttack + specialDefence + speed;
    }

}