for i in range(1, 1001):
	if(i % 2 == 1):
		print i
for j in range(5, 1000000):
	if(j % 5 == 0):
		print j
a = [1, 2, 5, 10, 255, 3]
sum = 0
for k in a:
	sum = sum + k
print sum
print sum / len(a)