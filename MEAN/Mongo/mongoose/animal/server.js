// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/otters');
mongoose.Promise = global.Promise;
var UserSchema = new mongoose.Schema({
 name: String,
})
mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'
app.use(bodyParser.urlencoded({ extended: true }));
// Require path
var path = require('path');
var otters = [];
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
    otters = [];
	var promise = new Promise(function(resolve, reject){
		var length = 0;
		User.find({}, function(err, users){
			length = users.length
			for(user in users){
				//console.log(users[user]);
				//quotes += '<p>"' + users[user].quote + '"</p><p>		-' + users[user].name + ' at ' + users[user].date.toUTCString() + '</p>';
				otters.push({
					name: users[user].name,
					id: users[user]._id
				});
				console.log(otters);
			}
			if(otters.length > 0 || length == 0){
			resolve(otters);
			}
			else{
				reject(Error("Nothing found."));
			}
		})
	});
	promise.then(function(result){
		otters = result;
		console.log(otters)
		res.render('index', {otters: otters});
	}, function(err){
		console.log(err);
		res.render('index', {otters: otters});
	});
})
app.get('/otters/edit/:id', function(req, res) {
	var promise = new Promise(function(resolve, reject){
		User.findOne({_id: req.params.id}, function(err, user){
			if(user != undefined){
				resolve(user);
			}
			else{
				reject(Error("Nothing found."));
			}
		})
	});
	promise.then(function(result){
		res.render('edit', {otter: result});
	}, function(err){
		console.log(err);
		res.render('new');
	});
})
// Add User Request 
app.post('/otters', function(req, res) {
  console.log("POST DATA", req.body);
  // create a new User with the name and age corresponding to those from req.body
  var user = new User({name: req.body.name});
  // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
  user.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong');
      res.render('index', {otters: []});
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a user!');
      res.redirect('/');
    }
  })
})
app.get('/otters/new', function(req, res) {
	res.render('new');
})

app.post('/otters/:id', function(req, res) {
	var promise = new Promise(function(resolve, reject){
		User.findOne({_id: req.params.id}, function(err, user){
			user.name = req.body.name;
			user.save(function(err) {
				if(err) {
					reject(Error("Nothing found."));
				}
			})
			resolve(user);
		})
	});
	promise.then(function(result){
		res.redirect('/');
	}, function(err){
		console.log(err);
		res.redirect('/otters/new');
	});
})

app.post('/otters/destroy/:id', function(req, res) {
	var promise = new Promise(function(resolve, reject){
		User.remove({_id: req.params.id}, function(err, user){
			if(err) {
				reject(Error("Nothing found."));
			}
			resolve(user);
		})
	});
	promise.then(function(result){
		res.redirect('/');
	}, function(err){
		console.log(err);
		res.redirect('/');
	});
})
// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})