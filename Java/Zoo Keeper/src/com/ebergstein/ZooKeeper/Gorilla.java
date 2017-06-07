package com.ebergstein.ZooKeeper;

public class Gorilla extends Mammal{
	
	
	public void throwSomething(){
		System.out.println("The Gorilla threw something!");
		this.setEnergy(this.getEnergy() - 5); 
	}
	
	public void eatBananas(){
		System.out.println("The Gorilla ate some bananas!");
		this.setEnergy(this.getEnergy() + 10); 
	}
	
	public void climb(){
		System.out.println("The Gorilla climbed a tree!");
		this.setEnergy(this.getEnergy() - 10); 
	}
}
