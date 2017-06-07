package com.ebergstein.ProjectMaster;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ninja biggs = new Ninja();
		Wizard wedge = new Wizard();
		Samurai tetsu = new Samurai();
		biggs.steal(wedge);
		System.out.println(wedge.getHealth());
		System.out.println(biggs.getHealth());
		biggs.runAway();
		System.out.println(biggs.getHealth());
		wedge.heal(biggs);
		System.out.println(biggs.getHealth());
		wedge.fireball(biggs);
		System.out.println(biggs.getHealth());
		tetsu.deathBlow(wedge);
		System.out.println(wedge.getHealth());
		System.out.println(tetsu.getHealth());
		tetsu.meditate();
		System.out.println(tetsu.getHealth());
		Samurai copycat = new Samurai();
		System.out.println(copycat.howMany());
		System.out.println(tetsu.howMany());
	}

}
