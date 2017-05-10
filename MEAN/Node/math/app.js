var mathlib = require('./mathlib')();     //notice the extra invocation parentheses!
console.log(mathlib.add(2,3));
console.log(mathlib.multiply(3,5));
console.log(mathlib.square(5));
console.log(mathlib.random(1,35));