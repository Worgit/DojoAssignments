function fib() {
  // Some variables here
  var left = 0;
  var right = 1;
  function nacci() {
    // do something to those variables here
    console.log(right);
    var temp = left;
    left = right;
    right += temp;
  }
  return nacci
}
var fibCounter = fib();
fibCounter() // should console.log "1"
fibCounter() // should console.log "1"
fibCounter() // should console.log "2"
fibCounter() // should console.log "3"
fibCounter() // should console.log "5"
fibCounter() // should console.log "8"
