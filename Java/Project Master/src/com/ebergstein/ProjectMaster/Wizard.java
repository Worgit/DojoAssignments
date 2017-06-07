package com.ebergstein.ProjectMaster;

public class Wizard extends Human{
	
	public Wizard(){
		super();
		this.setHealth(50);
		this.setIntelligence(8);
	}
	
	public void heal(Human human){
		human.setHealth(human.getHealth() + this.getIntelligence());
	}
	
	public void fireball(Human human){
		human.setHealth(human.getHealth() - this.getIntelligence() * 3);
	}
	
}
