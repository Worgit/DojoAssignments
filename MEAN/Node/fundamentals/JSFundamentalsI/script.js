var x = [3,5,"Dojo","rocks","Micheal","Sensei"];
var y = [1, 5, 90, 25, -3, 0]
for (index in x){
	console.log(x[index]);
}
x.push(100);
x = x + ["hello", "world", "JavaScript is Fun"]
console.log(x);
var sum = 0;
for (var i = 1; i <= 500; i++){
	sum = sum + i;
}
console.log(sum);
var min = y[0]
for (index in y){
	if (y[index] < min){
		min = y[index];
	}
}
console.log(min);
var avg = 0;
for(index in y){
	avg += y[index];
}
avg /= y.length
console.log(avg)
var newNinja = {
 name: 'Jessica',
 profession: 'coder',
 favorite_language: 'JavaScript', //like that's even a question!
 dojo: 'Dallas'
};
for (value in newNinja){
	console.log(newNinja[value])
}