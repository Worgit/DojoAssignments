from django.shortcuts import render

# Create your views here.
def index(request):
	return render(request, "turtleApp/index.html")
def showAll(request):
	return render(request, "turtleApp/showAll.html")
def show(request, color):
	context = {}
	if color == "blue":
		context = {
			"image":'red'
		}
	elif color == "orange":
		context = {
			"image": 'orange'
		}
	elif color == "red":
		context = {
			"image": 'blue'
		}
	elif color == "purple":
		context = {
			"image": 'purple'
		}
	else:
		context = {
			"image": 'other'
		}
	return render(request, "turtleApp/show.html", context)