// require express
var express = require("express");
// path module -- try to figure out where and why we use this
var path = require("path");
// create the express app
var app = express();
var bodyParser = require('body-parser');
// use it!
app.use(bodyParser.urlencoded({ extended: true }));
// static content
app.use(express.static(path.join(__dirname, "./static")));
// setting up ejs and our views folder
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view
app.get('/', function(req, res) {
 res.render("index");
})
// tell the express app to listen on port 8000
var server = app.listen(8000, function() {
 console.log("listening on port 8000");
});
// this is a new line we're adding AFTER our server listener
// take special note how we're passing the server
// variable. unless we have the server variable, this line will not work!!
var io = require('socket.io').listen(server);
// Whenever a connection event happens (the connection event is built in) run the following code
io.sockets.on('connection', function (socket) {
  console.log("WE ARE USING SOCKETS!");
  console.log(socket.id);
  //all the socket code goes in here!
  // If you don't know where this code is supposed to go reread the above info 
	socket.on("posting_form", function (data){
		//console.log('Someone clicked a button!  Reason: ' + data.form);
		console.log(data.form);
		console.log(data.form[0]);
		var responcetest = "You emitted the following information to the server: { name: " + data.form[0].value + ", location: " + data.form[1].value + ", language: " + data.form[2].value + ", comment: " + data.form[3].value + "}"
		socket.emit('updated_message', {response: responcetest});
		var randNum = Math.floor(Math.random()*999) + 1
		var randString = "Your lucky number emitted by the server is " + randNum + "."
		socket.emit('random_number', {response: randString});
	})
})
