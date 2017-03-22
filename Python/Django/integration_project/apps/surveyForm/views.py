from django.shortcuts import render, redirect
from django.core.urlresolvers import reverse

# Create your views here.
def index(request):
	return render(request, 'surveyForm/index.html')
	
def back(request):
	return redirect(reverse('survey:index'))

def result(request):
	return render(request, 'surveyForm/success.html')

def submit(request):
	if request.method == "POST":
		request.session['name'] = request.POST['name']
		request.session['dojo'] = request.POST['dojo']
		request.session['language'] = request.POST['language']
		request.session['comment'] = request.POST['comment']
		if not 'number' in request.session:
			request.session['number'] = 0
		request.session['number'] += 1
	return redirect(reverse('survey:result'))