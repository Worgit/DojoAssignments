package com.ebergstein.pokemon;

public abstract class PokemonInfo implements Info {

	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		// TODO Auto-generated method stub
		return new Pokemon(name, health, type);
	}

	@Override
	public void attackPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		pokemon.setHealth(pokemon.getHealth() - 10);

	}
	/*
	@Override
	public String pokemonInfo(Pokemon pokemon){
		return (pokemon.getName() + ": Health: " + pokemon.getHealth() + ", Type: " + pokemon.getType());
	}*/

}
