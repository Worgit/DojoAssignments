let controller = require('./../controllers/controller');
module.exports = app => {
	app.get('/api/friends', controller.getAll)
	app.post('/api/friends', controller.addFriend);
	app.get('/api/friends/:id', controller.getFriend);
	app.put('/api/friends', controller.editFriend);
}