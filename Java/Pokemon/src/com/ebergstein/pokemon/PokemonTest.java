package com.ebergstein.pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokedex pokedex = new Pokedex();
		Pokemon golurk = pokedex.createPokemon("Golurk", 230, "Ghost");
		pokedex.attackPokemon(golurk);
		System.out.println(pokedex.pokemonInfo(golurk));
	}

}
