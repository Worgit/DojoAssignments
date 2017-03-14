class Bike(object):
	
	def __init__(self, price, max_speed):
		self.price = price
		self.max_speed = max_speed
		self.miles = 0
	
	def displayInfo(self):
		print "${}, {}mph, {} miles".format(self.price, self.max_speed, self.miles)
	
	def riding(self):
		print "Riding..."
		self.miles += 10
	
	def reverse(self):
		print "Reversing..."
		self.miles -= 5
		if self.miles < 0:
			self.miles = 0
one = Bike(10, 20)
two = Bike(17, 23)
three = Bike(6, 17)
one.riding()
one.riding()
one.riding()
one.reverse()
one.displayInfo()
two.riding()
two.riding()
two.reverse()
two.reverse()
two.displayInfo()
three.reverse()
three.reverse()
three.reverse()
three.displayInfo()