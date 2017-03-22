from django.shortcuts import render, redirect
from datetime import datetime
from django.core.urlresolvers import reverse
import random

# Create your views here.
def index(request):
	if not 'gold' in request.session:
		request.session['gold'] = 50
	if not 'activities' in request.session:
		request.session['activities'] = ""
	return render(request, "ninjagold/index.html")
	
def farm(request):
	current = datetime.today()
	number = random.randrange(10,21)
	request.session['gold'] += number
	time = "(" + current.strftime("%x") + " " + current.strftime("%-I") + ":" + current.strftime("%M") + " " + current.strftime("%p") + ")"
	request.session['activities'] = request.session['activities'] + "<span class = 'green'>Earned {} gold! {}</span><br>".format(number, time)
	return redirect(reverse('gold:index'))
	
def cave(request):
	current = datetime.today()
	number = random.randrange(5,11)
	request.session['gold'] += number
	time = "(" + current.strftime("%x") + " " + current.strftime("%-I") + ":" + current.strftime("%M") + " " + current.strftime("%p") + ")"
	request.session['activities'] = request.session['activities'] + "<span class = 'green'>Earned {} gold! {}</span><br>".format(number, time)
	return redirect(reverse('gold:index'))
	
def house(request):
	current = datetime.today()
	number = random.randrange(2,6)
	request.session['gold'] += number
	time = "(" + current.strftime("%x") + " " + current.strftime("%-I") + ":" + current.strftime("%M") + " " + current.strftime("%p") + ")"
	request.session['activities'] = request.session['activities'] + "<span class = 'green'>Earned {} gold! {}</span><br>".format(number, time)
	return redirect(reverse('gold:index'))
	
def casino(request):
	current = datetime.today()
	number = random.randrange(-50,50)
	if request.session['gold'] + number < 0:
		request.session['gold'] = 0
	else:
		request.session['gold'] += number
	time = "(" + current.strftime("%x") + " " + current.strftime("%-I") + ":" + current.strftime("%M") + " " + current.strftime("%p") + ")"
	if number >= 0:
		request.session['activities'] += "<span class = 'green'>Earned {} gold! {}</span><br>".format(number,time)
	else:
		request.session['activities'] += "<span class = 'red'>Lost {} gold! {}</span><br>".format(number * -1, time)
	return redirect(reverse('gold:index'))
	