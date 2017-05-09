"use strict"
class Person{
	constructor(name){
		this.name = name;
		this.distance_traveled = 0
	}
	say_name(){
		alert(this.name);
	}
	say_something(input){
		console.log(input)
	}
	walk(){
		alert(this.name + " is walking");
		this.distance_traveled += 3;
	}
	run(){
		alert(this.name + " is running");
		this.distance_traveled += 10;
	}
	crawl(){
		alert(this.name + " is crawling");
		this.distance_traveled += 1;
	}
}

class Ninja{
	constructor(name, cohort){
		this.name = name
		this.cohort = cohort
		this.belt_level = "yellow"
	}
	say_name(){alert(this.name)}
	say_something(input) {console.log(input)}
	levelUp(){
		if(this.belt_level == "yellow"){
			this.belt_level == "red";
		}
		else if (this.belt_level == "red"){
			this.belt_level == "black";
		}
		console.log(this.belt_level);
	}
}
let person = new Person("Ezra");
person.walk();
person.run();
person.say_name();
person.say_something("I am cool");
let ninja = new Ninja("Ninjoe", "Marchuary");
ninja.levelUp();
ninja.say_name();
console.log(ninja.cohort);