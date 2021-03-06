// require express and path
var express = require("express");
var path = require("path");
var count = 0;
// create the express app
var app = express();
// static content 
app.use(express.static(path.join(__dirname, "./static")));
// setting up ejs and our views folder
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view
app.get('/', function(req, res) {
 res.render("index");
})
// this selects our port and listens
// note that we're now storing our app.listen within
// a variable called server. this is important!!
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
	socket.on("update", function (data){
		console.log(count);
		count++;
		io.emit('increment', {response: String(count)});
	})
	socket.on("reset", function (data){
		console.log(count);
		count = 0;
		io.emit('increment', {response: String(count)});
	})
	socket.on("init", function (data){
		io.emit('increment', {response: String(count)});
	})
})
 