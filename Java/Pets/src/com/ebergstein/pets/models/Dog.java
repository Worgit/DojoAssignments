package com.ebergstein.pets.models;

public class Dog extends Animal{

	public Dog(){
		
	}
	
	public Dog(String name, String breed, int weight){
		super(name, breed, weight);
	}
	
	@Override
	public String showAffection() {
		// TODO Auto-generated method stub
		if(this.getWeight() < 30){
			return("You Created a " + this.getBreed() + "!\n" + this.getName() + " jumped onto your lap.");
		}
		else{
			return("You Created a " + this.getBreed() + "!\n" + this.getName() + " curled up next to you.");
		}
	}

}
