var hour = 8;
var minute = 50;
var period = "am";
var intro;
var time;
var next = hour + 1;
if(hour === 12){
	next = 1;
}
if(minute == 30){
	intro = "half past " + hour;
}
else if (minute < 30){
	intro = "just after " + hour;
}
else{
	intro = "almost " + next;
}
if(period.toLowerCase() === "am"){
	time = "morning.";
}
else{
	time = "evening.";
}
console.log("It's " + intro + " in the " + time);