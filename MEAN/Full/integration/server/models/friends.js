let mongoose = require('mongoose');
let FriendSchema = new mongoose.Schema({
	first_name: {type: String, required: true},
	last_name: {type: String, required: true},
	birthday: {type: Date, required: true}
}, {timestamps:true});
mongoose.model('Friend', FriendSchema)