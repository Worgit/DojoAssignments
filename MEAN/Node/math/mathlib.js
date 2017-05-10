module.exports = function (){
  return {
    add: function(num1, num2) { 
    	return num1 + num2;
         // add code here 
    },
    multiply: function(num1, num2) {
    	return num1 * num2;
         // add code here 
    },
    square: function(num) {
    	return num * num;
         // add code here 
    },
    random: function(num1, num2) {
    	return Math.floor(Math.random() * (num2 - num1)) + num1;
         // add code here
    }
  }
};