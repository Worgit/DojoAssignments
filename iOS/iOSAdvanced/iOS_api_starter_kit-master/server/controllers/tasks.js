/**
 * Created by AF1 on 4/18/17.
 */

// Require Mongoose
var mongoose = require('mongoose');

// Require the model and save it in a variable
var Task = mongoose.model('Task');



module.exports = (function() {
    return {

        index: function(req, res) {
          // Find all tasks and then return that data in res.json()
          Task.find({}).exec(function(err,result){
          	res.json(result);
          })

        },
        
        add: function(req, res){
        	var newTask = Task({objective: "My First task!"});
        	newTask.save(function(err){
        		res.redirect("/tasks");
        	})
        },
        addNew: function(req, res){
        	var newTask = new Task(req.body)
        	newTask.save(function(err){
        		res.redirect("/tasks");
        	})
        },
        
        update: function(req, res){
        	console.log("made2");
        	Task.findOne({_id: req.params.updateID}).exec(function(err,result){
        		result.objective = req.body.objective;
        		result.save(function(err){
        			res.redirect("/tasks");
        		})
        	})
        },
        
        deltask: function(req, res){
        	console.log("made2");
        	Task.remove({_id: req.params.updateID}).exec(function(err){
        		res.redirect("/tasks");
        	})
        }
    }
})();
