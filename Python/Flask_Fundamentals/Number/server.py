import random
from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'ThisIsSecret' 

@app.route('/')
##default
def index():
  return render_template("index.html")
@app.route('/', methods=['POST'])
##playing
def guess():
	##print "Got Post Info"
	if not 'number' in session:
		session['number'] = random.randrange(1, 101)
	session['guess'] = request.form['guess']
	session['guess'] = int(session['guess'])
		
	return render_template("index.html")
@app.route('/reset', methods=['POST'])
#resetting everything
def reset():
	session.clear()
	print "Got Get Info"
	##print session
	return redirect("/")


app.run(debug=True)
