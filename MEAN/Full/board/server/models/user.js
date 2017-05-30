let mongoose = require('mongoose');
let Schema = mongoose.Schema;
let UserSchema = new Schema({
	name: {type: String, required: [true, "You need to input your name"]},
	_topics: [{type: Schema.Types.ObjectId, ref: 'Topic'}],
	posts: [{type: Schema.Types.ObjectId, ref: 'Post'}],
	_comments: [{type: Schema.Types.ObjectId, ref: 'Comment'}],
}, {timestamps:true});
mongoose.model('User', UserSchema)