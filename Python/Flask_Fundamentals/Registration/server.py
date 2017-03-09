from flask import Flask, render_template, redirect, request, session, flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
@app.route('/', methods=['GET'])
def index():
  return render_template("index.html")
@app.route('/process', methods=['POST'])
def submit():
    if len(request.form['email']) < 1:
        flash("Email cannot be blank!")
    elif not EMAIL_REGEX.match(request.form['email']):
        flash("Invalid Email Address!")
    else:
        flash("Email: " + request.form['email'])
    if len(request.form['first']) < 1:
        flash("Names cannot be blank!")
    else:
    	for i in range(0, len(request.form['first'])):
    		if request.form['first'][i].isnumeric():
    			flash("Names cannot have numbers!")
    			break;
    		elif i == len(request.form['first']) - 1:
    			flash("First: " + request.form['first'])
    if len(request.form['last']) < 1:
        flash("Names cannot be blank!")
    else:
    	for i in range(0, len(request.form['last'])):
    		if request.form['last'][i].isnumeric():
    			flash("Names cannot have numbers!")
    			break;
    		elif i == len(request.form['last']) - 1:
    			flash("Last" + request.form['last'])
    if len(request.form['password']) < 1:
        flash("You must input a password.")
    elif len(request.form['password']) < 9:
        flash("Your password is not long enough.")
    if len(request.form['confirm']) < 1:
        flash("You must input a confirmation password.")
    elif len(request.form['confirm']) < 9:
        flash("Your confirmation is not long enough.")
    if len(request.form['password']) >= 9 and len(request.form['confirm']) >= 9 and request.form['password'] == request.form['confirm']:
    	flash("Password:" + request.form['password'])
    	flash("Confirm: " + request.form['confirm'])
    elif len(request.form['password']) >= 9 and len(request.form['confirm']) >= 9:
    	flash("Password & confirmation not the same.")
    return redirect('/')

app.run(debug=True)