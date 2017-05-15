var animals = require('../controllers/animals.js')
var otters = [];
module.exports = function(app){
	app.get('/', function(req, res) {
		// This is where we will retrieve the users from the database and include them in the view page we will be rendering.
		animals.main(req, res);
	})
	app.get('/otters/edit/:id', function(req, res) {
		animals.edit(req, res);
	})
	// Add User Request 
	app.post('/otters', function(req, res) {
	  animals.make(req, res);
	})
	app.get('/otters/new', function(req, res) {
		animals.new(req, res);
	})

	app.post('/otters/:id', function(req, res) {
		animals.editpost(req, res);
	})

	app.post('/otters/destroy/:id', function(req, res) {
		animals.delete(req, res);
	})
}