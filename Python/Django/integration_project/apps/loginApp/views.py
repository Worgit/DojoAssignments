from django.shortcuts import render, redirect
from django.contrib import messages
from django.core.urlresolvers import reverse
from .models import User
import bcrypt
# Create your views here.
def index(request):
	return render(request, "loginApp/index.html")
	
def register(request):
	if not "hashes" in request.session:
		request.session["hashes"] = {}
	first = request.POST['first']
	last = request.POST['last']
	email = request.POST['email']
	password = request.POST['password']
	confirm = request.POST['confirm']
	check = User.objects.validation(first, last, email, password, confirm)
	if not check == "Success":
		for i in range(len(check)):
			messages.add_message(request, messages.INFO, check[i])
		return redirect(reverse('login:index'))
	password = password.encode(encoding = "utf-8")
	hashed = bcrypt.hashpw(password, bcrypt.gensalt())
	request.session["hashes"][password] = hashed
	request.session["name"] = first
	User.objects.create(first_name = first, last_name = last, email = email, password = hashed)
	return redirect(reverse('login:success'))
	
def login(request):
	email = request.POST['email']
	password = request.POST['password']
	password = password.encode(encoding = "utf-8")
	"""print "*"*80
	print password"""
	if not "hashes" in request.session:
		request.session["hashes"] = {}
	"""print "*"*80
	print request.session["hashes"]"""
	if not password in request.session["hashes"]:
		messages.add_message(request, messages.INFO, "Invalid Password")
		return redirect(reverse('login:index'))
	##print "*"*80
	hashed = bcrypt.hashpw(password, request.session["hashes"][password].encode(encoding = "utf-8"))
	query = User.objects.filter(email=email).filter(password=hashed)
	if len(query) < 1:
		messages.add_message(request, messages.INFO, "Invalid Credentials")
		return redirect(reverse('login:index'))
	request.session["name"] = query[0].first_name
	return redirect(reverse('login:success'))
	

def success(request):
	return render(request, "loginApp/success.html")