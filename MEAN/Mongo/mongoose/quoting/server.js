// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/quotes');
mongoose.Promise = global.Promise;
var UserSchema = new mongoose.Schema({
 name: String,
 quote: String,
 date: Date
})
mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'
var quotes = []
app.use(bodyParser.urlencoded({ extended: true }));
// Require path
var path = require('path');
var quotes = [];
// Setting our Static Folder Directory
app.use(express.static(path.join(__dirname, './static')));
// Setting our Views Folder Directory
app.set('views', path.join(__dirname, './views'));
// Setting our View Engine set to EJS
app.set('view engine', 'ejs');
// Routes
// Root Request
app.get('/', function(req, res) {
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    res.render('index');
})
app.get('/quotes', function(req, res) {
	quotes = [];
	var promise = new Promise(function(resolve, reject){
		var length = 0;
		User.find({}, function(err, users){
			length = users.length
			users = users.reverse();
			for(user in users){
				//console.log(users[user]);
				//quotes += '<p>"' + users[user].quote + '"</p><p>		-' + users[user].name + ' at ' + users[user].date.toUTCString() + '</p>';
				quotes.push({
					name: users[user].name,
					quote: users[user].quote,
					date: users[user].date.toUTCString()
				});
				console.log(quotes);
			}
			if(quotes.length > 0 || length == 0){
			resolve(quotes);
			}
			else{
				reject(Error("Nothing found."));
			}
		})
	});
	promise.then(function(result){
		quotes = result;
		console.log(quotes)
		res.render('quotes', {quotes: quotes});
	}, function(err){
		console.log(err);
		res.render('quotes', {quotes: quotes});
	});
	/*User.remove({}, function(err){
	 // This code will run when the DB has attempted to remove all matching records to {}
	})*/
	//console.log(users);
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
})
// Add User Request 
app.post('/quotes', function(req, res) {
  console.log("POST DATA", req.body);
  // create a new User with the name and age corresponding to those from req.body
  var user = new User({name: req.body.name, quote: req.body.quote, date: new Date()});
  // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
  user.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong');
      res.render('quotes', {quotes: quotes});
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a user!');
      res.redirect('/quotes');
    }
  })
})
// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})