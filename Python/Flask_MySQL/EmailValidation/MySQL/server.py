from flask import Flask, render_template, redirect, request, session, flash
from mysqlconnection import MySQLConnector
from datetime import datetime
app = Flask(__name__)
mysql = MySQLConnector(app,'email') #BAD NAME, DON'T DO THIS
# the "re" module will let us perform some regular expression operations
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
@app.route('/')
def index():
	return render_template('index.html')
@app.route('/process', methods=['POST'])
def submit():
    if len(request.form['email']) < 1:
        flash("Email cannot be blank!")
        return redirect('/')
    elif not EMAIL_REGEX.match(request.form['email']):
        flash("Invalid Email Address!")
        return redirect('/')
    else:
        info ={'mail':request.form['email'],
        'created': datetime.today()
        }
        mail_id=mysql.query_db("INSERT INTO emails (mail, created_at) VALUES(:mail,:created);",info)
        return redirect('/list')
@app.route('/list')
def list():
	session['yyy']=""
	session['xxx']=mysql.query_db("SELECT mail, created_at FROM emails")
	for data in session['xxx']:
		temp = data['created_at'].strftime('%c')
		session['yyy']+='<p>'+data['mail']+' '+ temp +'</p>'
	return render_template('success.html')
app.run(debug=True)
