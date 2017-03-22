from django.shortcuts import render, redirect
from django.core.urlresolvers import reverse
import random, string

# Create your views here.
def index(request):
	return render(request, 'randomword/index.html')

def generate(request):
	if request.method == "POST":
		word = "".join([random.choice(string.ascii_letters + string.digits) for i in range(14)])
		if not 'attempt' in request.session:
			request.session['number'] = 0
		request.session['number'] += 1
		request.session['attempt'] = "(attempt #{})".format(request.session['number'])
		request.session['word'] = word
	return redirect(reverse('random:index'))