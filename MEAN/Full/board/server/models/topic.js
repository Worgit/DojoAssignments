let mongoose = require('mongoose');
let Schema = mongoose.Schema;
let TopicSchema = new Schema({
	_user: {type: Schema.Types.ObjectId, ref: 'User'},
	posts: [{type: Schema.Types.ObjectId, ref: 'Post'}],
	header: {type: String, required: [true, "You need to input a header"]},
	description: {type: String, required: [true, "Your post needs content"]},
	category: {type: String},
}, {timestamps:true});
mongoose.model('Topic', TopicSchema)