let mongoose = require('mongoose');
let Friend = mongoose.model('Friend');

module.exports = {
	getAll: (req, res) => {
		Friend.find({}, (err, friends)=> {
			if(err){
				console.log(err);
				return res.sendStatus(500);
			}
			else{
				return res.json(friends);
			}
		})
	},
	addFriend: (req, res) => {
		var newFriend = new Friend(req.body);
		newFriend.save( (err, friend) => {
			if(err){
				console.log(err);
				return res.sendStatus(500);
			}
			else{
				return res.json(friend);
			}
		})
	},
	getFriend: (req, res) => {
		Friend.findOne({_id: req.params.id}, (err, friend)=>{
			if(err){
				return res.json(err);
			}
			else{
				return res.json(friend);
			}
		})
	},
	editFriend: (req, res) => {
		Friend.update({_id: req.body._id}, req.body, (err, data) => {
						if(err){
				console.log(err);
				return res.sendStatus(500);
			}
			else{
				return res.json(data);
			}
		})
	},
}