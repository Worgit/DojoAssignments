from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'ThisIsSecret'

@app.route('/')
def index():
  return render_template("index.html")

@app.route('/ninja/')
def none():
   session['image'] = "all"
   return redirect('/result')
@app.route('/result')
def show():
  return render_template('show.html')
@app.route('/ninja/<vararg>')
def one(vararg):
	if vararg == "blue":
		session['image'] = "blue"
	elif vararg == "orange":
		session['image'] = "orange"
	elif vararg == "red":
		session['image'] = "red"
	elif vararg == "purple":
		session['image'] = "purple"
	else:
		session['image'] = "none"
	print vararg
  	return redirect('/result')



app.run(debug=True)