class Animal(object):
	
	def __init__(self, name):
		self.name = name
		self.health = 100
		
	def walk(self):
		print "Walking..."
		self.health -= 1
		if self.health < 0:
			self.health = 0
		return self
	
	def run(self):
		print "Running..."
		self.health -= 5
		if self.health < 0:
			self.health = 0
		return self
	
	def displayHealth(self):
		print "{}: {} health".format(self.name, self.health)

class Dog(Animal):

	def __init__(self, name):
		super(Dog, self).__init__(name)
		self.health += 50
	
	def pet(self):
		print "Petting..."
		self.health += 5
		return self

class Dragon(Animal):

	def __init__(self, name):
		super(Dragon, self).__init__(name)
		self.health += 70
		
	def fly(self):
		print "Flying..."
		self.health -= 10
		return self
	
	def displayHealth(self):
		print "This is a dragon!"
		super(Dragon, self).displayHealth()

animal = Animal("Blob")
animal.walk().walk().walk().run().run().displayHealth()
dog =  Dog("Digger")
dog.walk().walk().walk().run().run().pet().displayHealth()
dragon =  Dragon("Spike")
dragon.walk().walk().walk().run().run().fly().fly().displayHealth()
##animal.pet()
##animal.fly()