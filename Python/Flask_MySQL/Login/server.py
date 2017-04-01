from flask import Flask, render_template, redirect, request, session, flash
from mysqlconnection import MySQLConnector
from datetime import datetime
app = Flask(__name__)
mysql = MySQLConnector(app,'Users') #BAD NAME, DON'T DO THIS
# the "re" module will let us perform some regular expression operations
import re
import md5
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
@app.route('/')
def index():
	session.clear()
	return render_template('index.html')
@app.route('/login', methods = ["POST"])
def login():
	email = request.form['email']
	##print "*"*80
	##print email
	password = md5.new(request.form['password']).hexdigest()
	query = "SELECT * FROM User WHERE User.email = :email LIMIT 1"
	data = {'email': email }
	user = mysql.query_db(query, data)
	##print "*"*80
	##print user
	if user != []:
		if user[0]['password'] == password:
			session['name'] = user[0]['first_name']
			session['id'] = user[0]['id']
			return redirect ('/success')
		else:
			return redirect ('/')
	else:
		return redirect ('/')
@app.route('/register', methods = ["POST"])
def register():
	if len(request.form['email']) < 1 or len(request.form['first_name']) < 2 or len(request.form['last_name']) < 2 or len(request.form['password']) < 8:
		flash("You forgot something.")
		return redirect ('/')
	elif not EMAIL_REGEX.match(request.form['email']):
		flash("Email not valid.")
		return redirect ('/')
	data = {'first_name': request.form['first_name'], 
	'last_name':  request.form['last_name'], 
	'email': request.form['email'], 
	'password': md5.new(request.form['password']).hexdigest()
	}
	print data
	query = "INSERT INTO User (first_name, last_name, email, password, created_at, updated_at) VALUES (:first_name, :last_name, :email, :password, NOW(), NOW())"
	print query
	mysql.query_db(query, data)
	session['name'] = request.form['first_name']
	newquery = "SELECT * FROM User WHERE users.email = :email LIMIT 1"
	newdata = {'email': request.form['email'] }
	user = mysql.query_db(newquery, newdata)
	session['id'] = user[0]['id']
	return redirect ('/success')
@app.route('/success')
def success():
	return render_template('success.html')
app.run(debug=True)