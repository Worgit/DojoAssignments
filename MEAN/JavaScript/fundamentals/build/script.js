function runningLogger(){
	console.log("I am running!");
}

function multiplyByTen(num){
	return (num * 10);
}

function stringReturnOne(){
	return "One";
}

function stringReturnTwo(){
	return "Two";
}

function caller(input){
	if(typeof input  == "function"){
		input();
	}
	//console.log(typeof input)
}

function myDoubleConsoleLog(funcone, functwo){
	if(typeof funcone  == "function" && typeof functwo  == "function"){
		console.log(funcone());
		console.log(functwo());
	}
	else{
		console.log("not");
	}
}

function caller2(input){
	console.log("starting");
	//console.log(input);
	//console.log(typeof input);
	if(typeof input  == "function"){
		setTimeout(input, 2000);
	}
	console.log("ending?");
	return "interesting"
}

runningLogger();
console.log(multiplyByTen(5));
console.log(stringReturnOne());
console.log(stringReturnTwo());
caller(runningLogger);
myDoubleConsoleLog(stringReturnOne, stringReturnTwo);
console.log(caller2(myDoubleConsoleLog));