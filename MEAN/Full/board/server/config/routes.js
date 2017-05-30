let controller = require('./../controllers/controller');
module.exports = app => {
	app.post('/login', controller.loginReg);
	app.get('/logout', controller.logout);
	app.get('/current', controller.current);
	app.get('/topics', controller.getTopics);
	app.post('/topic', controller.makeTopic);
	app.get('/topic/:id', controller.getTopic);
	app.get('/user/:id', controller.getUser);
	app.post('/topic/:id/post', controller.makePost);
	app.post('/topic/:t_id/post/:p_id/like', controller.likePost);
	app.post('/topic/:t_id/post/:p_id/dislike', controller.dislikePost);
	app.post('/topic/:t_id/post/:p_id/comment', controller.addComment);
}