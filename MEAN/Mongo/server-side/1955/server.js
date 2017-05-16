// Require the Express Module
var express = require('express');
var path = require('path');
// Create an Express App
var app = express();
// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
app.use(bodyParser.urlencoded({ extended: true }));
// Setting our Static Folder Directory
app.use(bodyParser.json());
require('./server/config/mongoose.js')
// Root Request
var routes_setter = require('./server/config/routes.js');
routes_setter(app);
// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})