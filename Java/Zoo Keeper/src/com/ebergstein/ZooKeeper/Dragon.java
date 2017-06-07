package com.ebergstein.ZooKeeper;

public class Dragon extends Mammal{
	
	public Dragon(){
		super();
		this.setEnergy(300);
	}
	
	public void fly(){
		System.out.println("The Dragon flew!");
		this.setEnergy(this.getEnergy() - 50);
	}
	
	public void eatHumans(){
		System.out.println("The Dragon ate some humans!");
		this.setEnergy(this.getEnergy() +25);
	}
	
	public void attackTown(){
		System.out.println("The Dragon attacked a town!");
		this.setEnergy(this.getEnergy() - 100);
	}

}
