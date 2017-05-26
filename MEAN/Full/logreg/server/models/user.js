let mongoose = require('mongoose');
let Schema = mongoose.Schema;
let UserSchema = new Schema({
	first_name: {type: String, required: [true, "You need to input your first name"]},
	last_name: {type: String, required: [true, "You need to input your last name"]},
	email: {type: String, required: [true, "You need to input your email"], unique: true},
	password: {type: String, required: [true, "You need to input your password"]},
	birthday: {type: Date, required: [true, "You need to input your birthday"]},
}, {timestamps:true});
mongoose.model('UserLogin', UserSchema)