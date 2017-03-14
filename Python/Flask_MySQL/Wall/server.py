from flask import Flask, render_template, redirect, request, session, flash
from mysqlconnection import MySQLConnector
from datetime import datetime
app = Flask(__name__)
mysql = MySQLConnector(app,'wall') #BAD NAME, DON'T DO THIS
# the "re" module will let us perform some regular expression operations
##import re
##EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
@app.route('/')
def index():
	session.clear()
	return render_template('index.html')
@app.route('/login', methods = ["POST"])
def login():
	email = request.form['email']
	print "*"*80
	print email
	password = request.form['password']
	query = "SELECT * FROM users WHERE users.email = :email LIMIT 1"
	data = {'email': email }
	user = mysql.query_db(query, data)
	##print "*"*80
	##print user
	if user != []:
		if user[0]['password'] == password:
			session['name'] = user[0]['first_name']
			session['id'] = user[0]['id']
			return redirect ('/wall')
		else:
			return redirect ('/')
	else:
		return redirect ('/')
@app.route('/register', methods = ["POST"])
def register():
	data = {'first_name': request.form['first_name'], 
	'last_name':  request.form['last_name'], 
	'email': request.form['email'], 
	'password': request.form['password']
	}
	query = "INSERT INTO users (first_name, last_name, email, password, created_at, updated_at) VALUES (:first_name, :last_name, :email, :password, NOW(), NOW())"
	mysql.query_db(query, data)
	session['name'] = request.form['first_name']
	newquery = "SELECT * FROM users WHERE users.email = :email LIMIT 1"
	newdata = {'email': request.form['email'] }
	user = mysql.query_db(newquery, newdata)
	session['id'] = user[0]['id']
	return redirect ('/wall')
@app.route('/wall')
def wall():
	message_query = mysql.query_db("SELECT messages.id, users.first_name, users.last_name, messages.created_at, messages.message FROM users JOIN messages ON users.id = messages.user_id ORDER BY messages.created_at DESC")
	for data in message_query:
		temp = data['created_at'].strftime('%c')
		flash("<div class = 'message'><h3>" + data['first_name'] + " " + data['last_name'] + " - " + temp + "</h3><p>" + data['message'] + "</p></div>")
		query = "SELECT users.first_name, users.last_name, comments.created_at, comments.comment FROM users JOIN comments ON users.id = comments.user_id JOIN messages ON messages.id = comments.message_id WHERE messages.id = :id ORDER BY comments.created_at ASC;"
		message_id = {'id': data['id']}
		comment_query = mysql.query_db(query, message_id)
		for comment in comment_query:
			temp = comment['created_at'].strftime('%c')
			flash("<div class = 'comment'><h4>" + comment['first_name'] + " " + comment['last_name'] + " - " + temp + "</h4><p>" + comment['comment'] + "</p></div>")
		flash("<p>Post a comment</p><form action = '/comment' method = 'post'><textarea name = 'comment'></textarea><input type = 'hidden' name = 'id' value = {}><input type = 'submit' value = 'Post a comment'></form>".format(data['id']))
	return render_template('wall.html')
@app.route('/post', methods = ["POST"])
def post():
	query = "INSERT INTO messages (user_id, message, created_at, updated_at) VALUES (:id, :message, NOW(), NOW())"
	data = {'id': session['id'], 
	'message': request.form['message']
	}
	mysql.query_db(query, data)
	return redirect('/wall')
@app.route('/comment', methods = ["POST"])
def comment():
	query = "INSERT INTO comments (message_id, user_id, comment, created_at, updated_at) VALUES (:message_id, :user_id, :comment, NOW(), NOW())"
	data = {'message_id': int(request.form['id']), 
	'user_id': session['id'], 
	'comment': request.form['comment']
	}
	print "*"*80
	print data['message_id']
	mysql.query_db(query, data)
	return redirect('/wall')
@app.route('/logout', methods = ["POST"])
def logout():
	return redirect('/')
app.run(debug=True)