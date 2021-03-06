from flask import Flask, render_template, request, redirect, session, flash
app = Flask(__name__)
app.secret_key = 'ThisIsSecret'

@app.route('/')
def index():
  return render_template("index.html")

@app.route('/result', methods=['POST'])
def submit():
   print "Got Post Info"
   session['name'] = request.form['name']
   temp = session['name']
   ret = 0
   if len(temp) > 0:
   	for i in range (0, len(temp)):
   		if temp[i].isnumeric():
   			flash("Names cannot have numbers in them.")
   			ret += 1
   			break
   else:
   	flash("No value inputted.")
   	ret += 1
   print "Got name Info"  
   session['dojo'] = request.form['dojo']
   print "Got dojo Info"
   session['language'] = request.form['language']
   print "Got language Info"
   session['comment'] = request.form['comment']
   print "Got comment Info"
   temp = session['comment']
   if len(temp) < 120:
   	flash(temp)
   else:
   	flash("Your comment was too long.")
   	ret += 1
   if ret >= 1:
   	return redirect ('/')
   return redirect('/result')
@app.route('/result')
def subIndex():
  return render_template('submit.html')
@app.route('/back', methods=['POST'])
def back():
	session.clear()
  	return redirect('/')



app.run(debug=True)