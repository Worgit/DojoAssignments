from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'ThisIsSecret'

@app.route('/')
def index():
  return render_template("index.html")

@app.route('/result', methods=['POST'])
def submit():
   print "Got Post Info"
   session['name'] = request.form['name']
   print "Got name Info"
   session['dojo'] = request.form['dojo']
   print "Got dojo Info"
   session['language'] = request.form['language']
   print "Got language Info"
   session['comment'] = request.form['comment']
   print "Got comment Info"
   return redirect('/result')
@app.route('/result')
def subIndex():
  return render_template('submit.html')
@app.route('/back', methods=['POST'])
def back():
	session.clear()
  	return redirect('/')



app.run(debug=True)