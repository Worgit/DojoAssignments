def push_front(arr, val):
	temp = arr[len(arr)-1]
	for i in range(len(arr)-1, 0, -1):
		arr[i], arr[i-1] =arr[i-1], arr[i]
	arr[0] = val
	arr.append(temp)
	return arr
	
print push_front(["Apple", "A", "Day"], "An")
	