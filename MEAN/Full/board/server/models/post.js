let mongoose = require('mongoose');
let Schema = mongoose.Schema;
let PostSchema = new Schema({
	_user: {type: Schema.Types.ObjectId, ref: 'User'},
	_comments: [{type: Schema.Types.ObjectId, ref: 'Comment'}],
	description: {type: String, required: [true, "Your post needs content"]},
	likes: {type: Number},
	dislikes: {type: Number},
}, {timestamps:true});
mongoose.model('Post', PostSchema)