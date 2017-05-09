var y = [1, 5, 90, 25, -3, 0]
/*function sumUp(start, end){
	var sum = start;
	for (var i = start+1; i <= end; i++){
		sum = sum + i;
	}
	console.log(sum);
}
function findMin(arr){
	var min = arr[0]
	for (index in arr){
		if (arr[index] < min){
			min = arr[index];
		}
	}
	console.log(min);
}
function findAvg(arr){
	var avg = 0;
	for(index in arr){
		avg += arr[index];
	}
	avg /= arr.length
	console.log(avg)
}
sumUp(1,500);
findMin(y);
findAvg(y);*//*
var sumUp = function(start, end){
	var sum = start;
	for (var i = start+1; i <= end; i++){
		sum = sum + i;
	}
	console.log(sum);
}
var findMin = function(arr){
	var min = arr[0]
	for (index in arr){
		if (arr[index] < min){
			min = arr[index];
		}
	}
	console.log(min);
}
var findAvg = function(arr){
	var avg = 0;
	for(index in arr){
		avg += arr[index];
	}
	avg /= arr.length
	console.log(avg)
}

sumUp(1,500);
findMin(y);
findAvg(y);*/

var methods = {
	sumUp: function(start, end){
		var sum = start;
		for (var i = start+1; i <= end; i++){
			sum = sum + i;
		}
		console.log(sum);
	},
	findMin: function(arr){
		var min = arr[0]
		for (index in arr){
			if (arr[index] < min){
				min = arr[index];
			}
		}
		console.log(min);
	},
	findAvg: function(arr){
		var avg = 0;
		for(index in arr){
			avg += arr[index];
		}
		avg /= arr.length
		console.log(avg)
	}
}

var person = {
	name: "Ezra",
	distance_traveled: 0,
	say_name: function(){alert(this.name)},
	say_something: function(input){console.log(input)},
	walk: function(){
		alert(this.name + " is walking");
		this.distance_traveled += 3;
	},
	run: function(){
		alert(this.name + " is running");
		this.distance_traveled += 10;
	},
	crawl: function(){
		alert(this.name + " is crawling");
		this.distance_traveled += 1;
	}
}

methods.sumUp(1,500);
methods.findMin(y);
methods.findAvg(y);

person.walk();
person.run();
person.say_name();
person.say_something("I am cool");
