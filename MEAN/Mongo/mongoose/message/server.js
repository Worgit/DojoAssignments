// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/messages');
mongoose.Promise = global.Promise;
var Schema = mongoose.Schema;
var PostSchema = new mongoose.Schema({
 name: {type: String, required: true, minlength: 4 },
 text: {type: String, required: true },
 comments: [{type: Schema.Types.ObjectId, ref: 'Comment'}]
}, { timestamps: true });
var CommentSchema = new mongoose.Schema({
 // since this is a reference to a different document, the _ is the naming convention!
 _post: {type: Schema.Types.ObjectId, ref: 'Post'},
 name: { type: String, required: true, minlength: 4 },
 text: { type: String, required: true },
}, {timestamps: true });
mongoose.model('Post', PostSchema); // We are setting this Schema in our Models as 'User'
mongoose.model('Comment', CommentSchema); // We are setting this Schema in our Models as 'User'
var Post = mongoose.model('Post') // We are retrieving this Schema from our Models, named 'User'
var Comment = mongoose.model('Comment') // We are retrieving this Schema from our Models, named 'User'
app.use(bodyParser.urlencoded({ extended: true }));
// Require path
var path = require('path');
// Setting our Static Folder Directory
app.use(express.static(path.join(__dirname, './static')));
// Setting our Views Folder Directory
app.set('views', path.join(__dirname, './views'));
// Setting our View Engine set to EJS
app.set('view engine', 'ejs');
// Routes
// Root Request
app.get('/', function(req, res){
	Post.find({})
	.populate("comments")
	.exec(function(err, posts) {
		res.render('index', {messages: posts});
	})
});
 app.post('/message', function (req, res){
  console.log("POST DATA", req.body);
  // create a new User with the name and age corresponding to those from req.body
  var post = new Post({name: req.body.name, text: req.body.message, comments: []});
  // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
  post.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong');
      res.redirect('/');
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a user!');
      res.redirect('/');
    }
  })
 });	// This is where we will retrieve the users from the database and include them in the view page we will be rendering.
app.post('/message/:id', function (req, res){
  Post.findOne({_id: req.params.id}, function(err, post){
         var comment = new Comment({name: req.body.name, text: req.body.comment});
         comment._post = post._id;
         post.comments.push(comment);
         comment.save(function(err){
                 post.save(function(err){
                       if(err) { console.log('Error'); } 
                       else { res.redirect('/'); }
                 });
         });
   });
 });	
// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})