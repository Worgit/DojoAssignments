package com.ebergstein.ProjectMaster;

public class Samurai extends Human{
	
	private static int number = 0;
	
	public Samurai(){
		super();
		this.setHealth(200);
		number++;
	}
	
	public void deathBlow(Human human){
		human.setHealth(0);
		this.setHealth(this.getHealth() / 2);
	}
	
	public void meditate(){
		this.setHealth(this.getHealth() + ( this.getHealth()/ 2));
	}
	
	public int howMany(){
		return (number);
	}

}
