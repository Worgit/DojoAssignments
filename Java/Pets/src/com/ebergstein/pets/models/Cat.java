package com.ebergstein.pets.models;

public class Cat extends Animal{
	
	public Cat(){
		
	}
	
	public Cat(String name, String breed, int weight){
		super(name, breed, weight);
	}

	@Override
	public String showAffection() {
		// TODO Auto-generated method stub
		return("You Created a " + this.getBreed() + "!\n" + this.getName() + " looked at you.");
	}

}
