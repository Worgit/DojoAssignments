from django.shortcuts import render, redirect
from django.contrib import messages
from .models import Email

# Create your views here.
def index(request):
	return render(request, "emailVerifier/index.html")
	
def checker(request):
	check = Email.objects.validation(request.POST['email'])
	if not check == "Success":
		messages.add_message(request, messages.INFO, check)
		return redirect('/')
	Email.objects.create(email=request.POST['email'])
	request.session['email'] = request.POST['email']
	return redirect('/success')

def success(request):
	context = {
		"emails" : Email.objects.all()
	}
	return render(request, "emailVerifier/success.html", context)