package com.ebergstein.ZooKeeper;

public class Mammal {
	private int energyLevel = 100;
	
	public void displayEnergy(){
		System.out.println(this.energyLevel);
	}
	
	public int getEnergy(){
		return (this.energyLevel);
	}
	public void setEnergy(int energyLevel){
		this.energyLevel = energyLevel;
	}
}
