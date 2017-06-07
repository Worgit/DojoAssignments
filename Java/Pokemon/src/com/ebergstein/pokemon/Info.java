package com.ebergstein.pokemon;

public interface Info {
	public Pokemon createPokemon(String name, int health, String type);
	
	public void attackPokemon(Pokemon pokemon);
	
	public String pokemonInfo(Pokemon pokemon);
}