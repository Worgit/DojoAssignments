from django.shortcuts import render, redirect

# Create your views here.
def index(request):
	return render(request, 'surveyForm/index.html')
	
def back(request):
	return redirect('/')

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
	return redirect('/result')