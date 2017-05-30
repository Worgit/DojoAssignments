let mongoose = require('mongoose');
let Schema = mongoose.Schema;
let CommentSchema = new Schema({
	_user: {type: Schema.Types.ObjectId, ref: 'User'},
	description: {type: String, required: [true, "Your post needs content"]},
}, {timestamps:true});
mongoose.model('Comment', CommentSchema)