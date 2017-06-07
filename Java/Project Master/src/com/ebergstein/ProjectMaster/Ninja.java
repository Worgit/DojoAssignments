package com.ebergstein.ProjectMaster;

public class Ninja extends Human{
	
	public Ninja(){
		super();
		this.setStealth(10);
	}
	
	public void steal(Human human){
		int temp = human.getHealth();
		human.setHealth(temp - this.getStealth());
		this.setHealth(this.getHealth() + (temp - human.getHealth()));
	}
	
	public void runAway(){
		this.setHealth(this.getHealth() - 10);
	}

}
