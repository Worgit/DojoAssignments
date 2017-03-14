class Car(object):
	
	def __init__(self, price, speed, fuel, mileage):
		self.price = price
		self.speed = speed
		self.fuel = fuel
		self.mileage = mileage
		self.tax = 0.12
		if self.price > 10000:
			self.tax = 0.15
	
	def display_all(self):
		print "${}, {}mph, {}, {}mpg, %{}".format(self.price, self.speed, self.fuel, self.mileage, self.tax * 100)
one = Car(100000, 200, "Full", 1)
one.display_all()
two = Car(1000, 100, "Empty", 3)
two.display_all()
three = Car(5000, 110, "Kind of Full", 2)
three.display_all()
four = Car(20000, 150, "Full", 4)
four.display_all()
five = Car(8000, 120, "Not Full", 2)
five.display_all()
six = Car(10000, 130, "Full", 2)
six.display_all()