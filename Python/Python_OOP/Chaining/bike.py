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
		return self
	
	def reverse(self):
		print "Reversing..."
		self.miles -= 5
		if self.miles < 0:
			self.miles = 0
		return self
one = Bike(10, 20)
two = Bike(17, 23)
three = Bike(6, 17)
one.riding().riding().riding().reverse().displayInfo()
two.riding().riding().reverse().reverse().displayInfo()
three.reverse().reverse().reverse().displayInfo()