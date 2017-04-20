/**
 * Created by AF1 on 4/18/17.
 */


// Require the controllers
var tasks = require('./../controllers/tasks.js');

// Define the routes
module.exports = function(app) {

    // Tasks routes ===================================================
    app.get('/tasks', function(req, res) {
        tasks.index(req, res);
    });
    
    app.get('/addDummyData', function(req, res) {
        tasks.add(req, res);
    });
    
    app.post('/tasks', function(req, res) {
        tasks.addNew(req, res);
    });
    
    app.post('/tasks/update/:updateID', function(req, res) {
    	console.log("made1");
        tasks.update(req, res);
    });
    
    app.post('/tasks/delete/:updateID', function(req, res) {
    	console.log("made3");
        tasks.deltask(req, res);
    });


};
