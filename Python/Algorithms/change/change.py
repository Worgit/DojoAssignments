def change(cents):
	coins = {}
	temp = cents
	dollars = 0
	while temp > 100:
		dollars += 1
		temp -= 100
	coins["dollars"] = dollars
	halfdollars = 0
	if temp > 50:
		halfdollars += 1
		temp -= 50
	coins["half-dollars"] = halfdollars
	quarters = 0;
	if temp > 25:
		quarters += 1
		temp -= 25
	coins["quarters"] = quarters
	dimes = 0;
	while temp > 10:
		dimes += 1
		temp -= 10
	coins["dimes"] = quarters
	nickels = 0;
	if temp > 5:
		nickels += 1
		temp -= 5
	coins["nickels"] = nickels
	coins["pennies"] = temp
	return coins
print change(387)