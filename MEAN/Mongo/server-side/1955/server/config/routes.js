var people = require('../controllers/people.js')
var otters = [];
module.exports = function(app){
	app.get('/', function(req, res) {
		// This is where we will retrieve the users from the database and include them in the view page we will be rendering.
		people.index(req, res);
	})
	app.get('/new/:name', function(req, res) {
		people.addNew(req, res);
	})
	app.get('/:name', function(req, res) {
		people.findOne(req, res);
	})

	app.get('/remove/:name', function(req, res) {
		people.deluser(req, res);
	})
}