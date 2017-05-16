var mongoose = require('mongoose');
var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'
module.exports = {
	index: function(req, res) {
          // Find all tasks and then return that data in res.json()
        User.find({}).exec(function(err,result){
        	res.json(result);
        })

    },
	addNew: function(req, res){
        var newUser = new User(req.params)
        newUser.save(function(err){
        	res.redirect("/");
        })
    },
	deluser: function(req, res){
		//console.log("made2");
		User.remove({name: req.params.name}).exec(function(err){
			res.redirect("/");
		})
	},
	findOne: function(req, res) {
          // Find all tasks and then return that data in res.json()
        User.findOne({name: req.params.name}).exec(function(err,result){
          	res.json(result);
        })

    }
}