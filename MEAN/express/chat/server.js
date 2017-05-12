// require express and path
var express = require("express");
var path = require("path");
// create the express app
var session = require('express-session');
//var sharedsession = require('express-socket.io-session');
var app = express();
var bodyParser = require('body-parser');
var text = "";
app.use(bodyParser.urlencoded({ extended: true }));
// static content 
app.use(express.static(path.join(__dirname, "./static")));
app.use(session({secret: 'codingdojorocks'}));
// setting up ejs and our views folder
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view
app.get('/', function(req, res) {
	if(req.session.name == undefined){
		res.render("index");
	}
	else{
		var name = req.session.name;
		res.render("board", {name: name});
	}
})
app.post('/register', function(req, res) {
	console.log("POST DATA", req.body);
	req.session.name = req.body.name
	res.redirect('/');
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
/*io.use(sharedsession(session, {
	autoSave:true
}));*/
// Whenever a connection event happens (the connection event is built in) run the following code
io.sockets.on('connection', function (socket) {
  console.log("WE ARE USING SOCKETS!");
  console.log(socket.id);
  //all the socket code goes in here!
  // If you don't know where this code is supposed to go reread the above info 
	socket.on("posting_form", function (data){
		console.log('Someone clicked a button!  Reason: ' + data.form);
		console.log(data.form);
		console.log(data.form[0]);
		console.log(data.form[1]);
		text += "<p>" + data.form[1].value + ":	" + data.form[0].value + "</p>"
		io.emit('updated_message', {response: text});
	})
	socket.on("init", function (data){
		//console.log('Someone clicked a button!  Reason: ' + data.form);
		socket.emit('updated_message', {response: text});
	})
})
 