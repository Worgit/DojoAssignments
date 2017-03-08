from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'ThisIsSecret'

@app.route('/')
def index():
	if not "number" in session:
		session["number"] = 1
	else:
		session["number"] = session["number"] + 1
	return render_template("index.html")
@app.route('/ninja', methods = ["POST"])
def ninja():
	if not "number" in session:
		session["number"] = 1
	else:
		session["number"] = session["number"] + 1
	return redirect("/")
@app.route('/reset', methods = ["POST"])
def reset():
	session.clear()
	return redirect("/")
app.run(debug=True)
