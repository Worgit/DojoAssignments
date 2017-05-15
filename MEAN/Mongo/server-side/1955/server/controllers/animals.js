var mongoose = require('mongoose');
var UserSchema = new mongoose.Schema({
 name: String,
})
mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'
module.exports = {
	main: function(req, res)  {
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
	},
	edit: function(req, res) {
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
	},
	make: function(req, res) {
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
	},
	new: function(req, res) {
		res.render('new');
	},
	editpost: function(req, res) {
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
	},
	delete: function(req, res) {
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
	}
}