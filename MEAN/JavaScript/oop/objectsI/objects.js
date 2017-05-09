function vehicleConstructor(name, wheels, passengers){
	var vehicle = {
		name: name,
		wheels: wheels,
		passengers: passengers,
		makeNoise: function(){console.log("Quack.")}
	}
	return vehicle;
}
var bike = vehicleConstructor("bike", 2, 1);
bike.makeNoise = function(){
	console.log("ring ring!");
}
var sedan = vehicleConstructor("sedan", 4, 4);
sedan.makeNoise = function(){
	console.log("Honk Honk!");
}
var bus = vehicleConstructor("bus", 4, 30);
bus.addPassengers = function(people){
	bus.passengers += people;
}

bike.makeNoise();
sedan.makeNoise();
bus.addPassengers(5);
console.log(bus.passengers);