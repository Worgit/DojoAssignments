from django.shortcuts import render, HttpResponse
from datetime import datetime

# Create your views here.
def index(request):
	raw = datetime.now()
	time = {
	##"time":raw.strftime("%c")
	"month":raw.strftime("%b"),
	"day":raw.strftime("%d"),
	"year":raw.strftime("%Y"),
	"hour":raw.strftime("%I"),
	"minute":raw.strftime("%M"),
	"tod":raw.strftime("%p")
	}
	return render(request,'timedisplay/index.html', time)