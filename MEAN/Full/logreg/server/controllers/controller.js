var mongoose = require('mongoose');
var User = mongoose.model('UserLogin')

module.exports = {
	register: (req, res) => {
		User.findOne({email: req.body.email}, (err, user) =>{
			console.log(req.body.email);
			console.log(user);
			if(user == null){
				let newUser = new User(req.body);
				newUser.save( (err, savedUser) => {
					if(err){
						return res.json(err);
					}
					else{
						return res.json(savedUser);
					}
				})
			}
			else{
				return res.sendStatus(500);
			}
		})
	},
	login: (req, res) => {
		User.findOne({email: req.params.email}, (err, user) =>{
			console.log(user);
			console.log(req.body);
			if(user == null){
				return res.sendStatus(500);
			}
			else{
				return res.json(user);
			}
		})
	},
}