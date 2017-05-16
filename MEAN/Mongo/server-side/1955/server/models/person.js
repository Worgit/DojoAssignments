var mongoose = require('mongoose');
var UserSchema = new mongoose.Schema({
 name: String,
})
mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'