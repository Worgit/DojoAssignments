var _ = {
   map: function(list, iteratee) {
   	for (index in list){
   		list[index] = iteratee(list[index]);
   	}
   	return list;
     //code here;
   },
   reduce: function(list, iteratee, memo = "none") {
   	var memodup = false;
   	if(memo == "none"){
   		memo = list[0]
   		memodup = true;
   	}
   	var temp = -1;
   	if(memodup){
   		temp = 1;
   	}
   	else{
   		temp = 0;
   	}
   	for(var i = temp; i < list.length; i++){
   		memo = iteratee(memo, list[i]);
   	}
   	return memo;
     // code here;
   },
   find: function(list, predicate) {
   	for (index in list){
   		if (predicate(list[index])){
   			return list[index];
   		}
   	}
   	return undefined;   
     // code here;
   },
   filter: function(list, predicate) {
   	var result = []
   	for (index in list){
   		if (predicate(list[index])){
   			result.push(list[index]);
   		}
   	}
   	return result;   
     // code here;
   },
   reject: function(list, predicate) { 
   	var result = []
   	for (index in list){
   		if (!predicate(list[index])){
   			result.push(list[index]);
   		}
   	}
   	return result;   
     // code here;
   }
 }
// you just created a library with 5 methods!
var evens = _.filter([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; });
console.log(evens); // if things are working right, this will return [2,4,6].
var sum = _.reduce([1,2,3], function(memo, num){ return memo + num; }, 0);
console.log(sum);
var test = _.map([1,2,3], function(num){ return num * 5; });
console.log(test);
