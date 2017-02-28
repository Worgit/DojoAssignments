var birthday = 60;
while(birthday >= 1){
	if(birthday == 1){
		console.log("My birthday is tomorrow! I'm almost there!");
	}
	else if (birthday <= 5){
		console.log("My birthday is in only "+ birthday + " days!  I can't wait!");
	}
	else if (birthday <= 30){
		console.log("My birthday is in " + birthday + " days!  It's coming up soon!");
	}
	else{
		console.log("My birthday is in " + birthday + " days.  It's too far away.");
	}
	birthday--;
}
console.log("My birthday is today!")