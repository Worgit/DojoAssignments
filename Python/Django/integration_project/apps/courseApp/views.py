from django.shortcuts import render, redirect
from .models import Course
from ..loginApp.models import User
from django.core.urlresolvers import reverse
from django.db.models import Count
# Create your views here.

def index(request):
	context = {
	"courses": Course.objects.all(),
	}
	return render(request, "courseApp/index.html", context)
	
def back(request):
	return redirect(reverse('courses:index'))

def remove(request, id):
	context = {
	"course": Course.objects.get(id=id)
	}
	return render(request, "courseApp/destroy.html", context)

def delete(request, id):
	Course.objects.get(id=id).delete()
	return redirect (reverse('courses:index'))

def add(request):
	name = request.POST["name"]
	desc = request.POST["description"]
	Course.objects.create(title=name,description=desc)
	return redirect(reverse('courses:index'))

def courses(request):
	context = {
	"courses": Course.objects.annotate(num_users = Count('users')),
	"users": User.objects.all(),
	}
	"""print "*"*80
	print context"""
	return render(request, "courseApp/users_courses.html", context)

def adduser(request):
	courseid = request.POST['courses']
	userid = request.POST['users']
	course = Course.objects.get(id = courseid)
	user = User.objects.get(id = userid)
	course.users.add(user)
	return redirect(reverse('courses:courses'))