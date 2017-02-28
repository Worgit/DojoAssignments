function onlyNum(array){
	var result = [];
	for(var i = 0; i < array.length; i++){
		if(typeof array[i] === "number"){
			result.push(array[i]);
		}
	}
	return result;
}
console.log(onlyNum([1,"this","should",2,"not","be",3,"here"]));
