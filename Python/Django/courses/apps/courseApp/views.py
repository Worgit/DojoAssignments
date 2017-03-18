from django.shortcuts import render, redirect
from .models import Course
# Create your views here.

def index(request):
	context = {
	"courses": Course.objects.all(),
	}
	return render(request, "courseApp/index.html", context)
	
def back(request):
	return redirect('/')

def remove(request, id):
	context = {
	"course": Course.objects.get(id=id)
	}
	return render(request, "courseApp/destroy.html", context)

def delete(request, id):
	Course.objects.get(id=id).delete()
	return redirect ('/')

def add(request):
	name = request.POST["name"]
	desc = request.POST["description"]
	Course.objects.create(title=name,description=desc)
	return redirect('/')