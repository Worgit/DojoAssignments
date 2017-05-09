function Vehicle(name, wheels, passengers, speed){
	var distance_travelled = 0;
	var updateDistanceTravelled = function(distance){
		distance_travelled += distance;
	}
	this.name = name;
	this.wheels = wheels;
	this.passengers = passengers;
	this.speed = speed;
	this.move = function(){
		updateDistanceTravelled(this.speed);
		this.makeNoise();
	}
	this.checkMiles = function(){
		console.log(distance_travelled);
	}
}

Vehicle.prototype.makeNoise = function(){
	console.log("Quack.")
}
Vehicle.prototype.vin = Math.floor(Math.random() * (100000000000000000 - 10000000000)) + 10000000000

var bike = new Vehicle("bike", 2, 1, 20);
bike.makeNoise = function(){
	console.log("ring ring!");
}
var sedan = new Vehicle("sedan", 4, 4, 80);
sedan.makeNoise = function(){
	console.log("Honk Honk!");
}
var bus = new Vehicle("bus", 4, 30, 60);
bus.addPassengers = function(people){
	bus.passengers += people;
}

bike.makeNoise();
sedan.makeNoise();
bus.addPassengers(5);
console.log(bus.passengers);
bus.move();
bus.checkMiles();
console.log(bus.vin)