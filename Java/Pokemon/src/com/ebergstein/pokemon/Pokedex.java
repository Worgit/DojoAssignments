package com.ebergstein.pokemon;

public class Pokedex extends PokemonInfo {
	
	public String pokemonInfo(Pokemon pokemon){
		return (pokemon.getName() + ": Health: " + pokemon.getHealth() + ", Type: " + pokemon.getType());
	}


}
