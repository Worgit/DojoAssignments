import random
def grades():
	print "Score and Grades"
	for i in range(0, 10):
		grade = random.randint(60, 100)
		letter = ""
		if grade >= 90:
			letter = "A"
		elif grade >= 80:
			letter = "B"
		elif grade >= 70:
			letter = "C"
		else:
			letter = "D"
		print "Score: ", grade, "; Your grade is ", letter
	print "These are your grades."
grades()