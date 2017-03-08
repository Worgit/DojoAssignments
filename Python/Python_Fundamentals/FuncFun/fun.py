def odd_even():
	for i in range(1, 2001):
		type = ""
		if i % 2 == 0:
			type = "even"
		else:
			type = "odd"
		print "Number is {}. This is an {} number.".format(i, type)
def multiply(list, multiplier):
	result = []
	for value in list:
		result.append(value * multiplier)
	return result
def layered_multiples(multiplied):
	result = []
	for i in range(0, len(multiplied)):
		layer = []
		for j in range(0, multiplied[i]):
			layer.append(1)
		result.append(layer)
	return result
odd_even()
a = [2,4,10,16]
b = layered_multiples(multiply(a, 5))
print b