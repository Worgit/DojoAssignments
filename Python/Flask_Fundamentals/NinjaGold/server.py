import random
from datetime import datetime
from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'ThisIsSecret' 

@app.route('/')
##default
def index():
	if not 'gold' in session:
		session['gold'] = 0
	if not 'activities' in session:
		session['activities'] = ""
	return render_template("index.html")
@app.route('/process_money', methods=['POST'])
##playing
def process():
	##print "Got Post Info"
	number = 0
	##gets the current time
	time = datetime.today()
	##converts it to string format
	time = time.strftime("%c")
	session['submit'] = request.form['submit']
	if session['submit'] == "farm":
		number = random.randrange(10,21)
		session['activities'] = session['activities'] + "<span class = 'green'>You gained {} gold!(".format(number) + time + ")</span><br>"
	elif session['submit'] == "cave":
		number = random.randrange(5,11)
		session['activities'] = session['activities'] + "<span class = 'green'>You gained {} gold!(".format(number) + time + ")</span><br>"
	elif session['submit'] == "house":
		number = random.randrange(2,6)
		session['activities'] = session['activities'] + "<span class = 'green'>You gained {} gold!(".format(number) + time + ")</span><br>"
	else:
		number = random.randrange(-50,51)
		if number >= 0:
			session['activities'] = session['activities'] + "<span class = 'green'>You gained {} gold!(".format(number * -1) + time + ")</span><br>"
		else:
			session['activities'] = session['activities'] + "<span class = 'red'>You lost {} gold!(".format(number * -1) + time + ")</span><br>"
	if session['gold'] + number < 0:
		session['gold'] = 0
	else:
		session['gold'] = session['gold'] + number
	return redirect("/")
@app.route('/reset', methods=['POST'])
#resetting everything
def reset():
	session.clear()
	print "Got Get Info"
	##print session
	return redirect("/")

app.run(debug=True)