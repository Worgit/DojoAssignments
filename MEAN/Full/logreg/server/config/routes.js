let controller = require('./../controllers/controller');
module.exports = app => {
	app.get('/api/login/:email', controller.login);
	app.post('/api/register', controller.register);
}