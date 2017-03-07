str = "If monkeys like bananas, then I must be a monkey!"
print str.find("monkey")
crocodile = str.replace("monkey", "alligator")
print crocodile
x = [2,54,-2,7,12,98]
print max(x)
print min(x)
x = ["hello",2,54,-2,7,12,98,"world"]
print x[0]
print x[len(x)-1]
next = [x[0], x[len(x)-1]]
print next
x = [19,2,54,-2,7,12,98,32,10,-3,6]
x.sort()
first = x[0: (len(x)-1)/2]
last = x[(len(x)-1)/2: len(x)]
last.insert(0, first)
print last