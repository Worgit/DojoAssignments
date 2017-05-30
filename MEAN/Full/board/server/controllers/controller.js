var mongoose = require('mongoose');
var User = mongoose.model('User')
var Topic = mongoose.model('Topic')
var Post = mongoose.model('Post')
var Comment = mongoose.model('Comment')
/*module.exports = app => {
	app.post('/login', controller.logreg);
	app.get('/logout', controller.logout);
	app.get('/topics', controller.getTopics);
	app.post('/topic', controller.addTopics);
	app.get('/topic/:id', controller.getTopic);
	app.get('/user/:id', controller.getUser);
	app.post('/topic/:id/post', controller.addPost);
	app.post('/topic/:t_id/post/:p_id/like', controller.likePost);
	app.post('/topic/:t_id/post/:p_id/dislike', controller.dislikePost);
	app.post('/topic/:t_id/post/:p_id/comment', controller.addComment);
}*/
module.exports = {

	loginReg: (req, res) => {
		console.log("in");
		User.findOne({name: req.body.name}, (err, user) =>{
			if(user == null){
				console.log("new");
				let newUser = new User(req.body);
				newUser.save( (err, savedUser) => {
					console.log("save");
					console.log(err);
					if(err){
						console.log("bad");
						console.log(err);
						let errors = "";
						for (let i in err.errors){
							errors+=err.errors[i].message + ",";
						}
						return res.status(500).send(errors)
					}
					else{
						req.session.user = savedUser;
						console.log(savedUser);
						return res.json(savedUser);
					}
				})
			}
			else{
				console.log("old");
				req.session.user = user;
				console.log(user);
				return res.json(user);
			}
		})
	},
	
	logout: (req, res) => {
		req.session.destroy();
		res.redirect('/');
	},
	
	current: (req, res) => {
		if(!req.session.user){
			return res.status(401).send("Nice try!");
		}
		else{
			return res.json(req.session.user);
		}
	},
	
	makeTopic: (req, res) => {
		console.log("*********");
		Topic.findOne({_id: req.body.id}, (err, product) => {
			console.log("*********");
			if(product != null){
				return res.status(500).send("Topic already made")
			}
			var newTopic = new Topic(req.body);
			newTopic._user = req.session.user._id;
			newTopic.save( (err, savedTopic) => {
				if(err){
					console.log("Saving Topic");
					console.log(err)
					let errors = "";
					for (let i in err.errors){
						errors+=err.errors[i].message + ",";
					}
					return res.status(500).send(errors)
				}
				else{
					console.log("*********");
					//var temp = req.session.user;
					User.findOne({_id: req.session.user._id}).populate('_topics').populate('posts').populate('_comments').exec( (err, user)=>{
						if(err){
							console.log(err);
							let errors = "";
							for (let i in err.errors){
								errors+=err.errors[i].message + ",";
							}
							return res.status(500).send(errors)
						}
						else{
							console.log(user);
							user._topics.push(savedTopic._id);
							user.save( (err, savedUser) => {
								console.log("save");
								console.log(err);
								if(err){
									console.log("bad");
									console.log(err);
									let errors = "";
									for (let i in err.errors){
										errors+=err.errors[i].message + ",";
									}
									return res.status(500).send(errors)
								}
								else{
									req.session.user = savedUser;
									console.log(savedUser);
									return res.json(savedTopic);
								}
							})
						}
					})
				}
			})
		})
	},
	getTopics: (req, res) => {
		Topic.find({}).populate('_user').populate('posts').exec( (err, topics)=>{
			if(err){
				console.log(err);
				let errors = "";
				for (let i in err.errors){
					errors+=err.errors[i].message + ",";
				}
				return res.status(500).send(errors)
			}
			else{
				return res.json(topics);
			}
		})
	},
	getTopic: (req, res) => {
		Topic.findOne({_id: req.params.id}).populate('_user').populate({path: 'posts', populate: {path: '_user'}}).populate({path: 'posts', populate: {path: '_comments', populate: {path: '_user'}}}).exec( (err, topic)=>{
			if(err){
				console.log(err);
				let errors = "";
				for (let i in err.errors){
					errors+=err.errors[i].message + ",";
				}
				return res.status(500).send(errors)
			}
			else{
				return res.json(topic);
			}
		})
	},
	getUser: (req, res) => {
		User.find({_id: req.params.id}).populate('_topics').populate('posts').populate('_comments').exec( (err, user)=>{
			if(err){
				console.log(err);
				let errors = "";
				for (let i in err.errors){
					errors+=err.errors[i].message + ",";
				}
				return res.status(500).send(errors)
			}
			else{
				return res.json(user);
			}
		})
	},
	makePost: (req, res) => {
		Topic.findOne({_id: req.params.id}, (err, topic) =>{
			if(topic == null){
				return res.status(500).send("Topic not found")
			} 
			else{
				let post = new Post(req.body);
				post.likes = 0;
				post.dislikes = 0;
				post._user = req.session.user._id
				post.save((err, newPost) => {
					if(err){
						console.log(err);
						let errors = "";
							for (let i in err.errors){
								errors+=err.errors[i].message + ",";
						}
						return res.status(500).send(errors)
					}
					else{
						topic.posts.push(newPost._id);
						topic.save( (err, savedTopic) => {
							if(err){
								console.log("Saving Topic");
								console.log(err)
								let errors = "";
								for (let i in err.errors){
									errors+=err.errors[i].message + ",";
								}
								return res.status(500).send(errors)
							}
							else{
								User.findOne({_id: req.session.user._id}).populate('_topics').populate('posts').populate('_comments').exec( (err, user)=>{
									if(err){
										console.log(err);
										let errors = "";
										for (let i in err.errors){
											errors+=err.errors[i].message + ",";
										}
										return res.status(500).send(errors)
									}
									else{
										if (!user.posts){
											user.posts = [];
										}
										user.posts.push(newPost._id);
										user.save( (err, savedUser) => {
											console.log("save");
											console.log(err);
											if(err){
												console.log("bad");
												console.log(err);
												let errors = "";
												for (let i in err.errors){
													errors+=err.errors[i].message + ",";
												}
												return res.status(500).send(errors)
											}
											else{
												req.session.user = savedUser;
												console.log(savedUser);
												return res.json(newPost);
											}
										})
									}
								})
							}
						})
					}
				})
			}
		})
	},
	likePost: (req, res) => {
		//console.log("*********");
		//console.log(req.body.id);
		Topic.findOne({_id: req.params.t_id}, (err, customer) =>{
			if(post == null){
				return res.status(500).send("Topic not found")
			} 
			else{
				Topic.findOne({_id: req.params.p_id}, (err, customer) =>{
					if(post == null){
						return res.status(500).send("Post not found")
					} 
					else{
						post.likes++;
						post.save((err, newPost) => {
							if(err){
								console.log(err);
								let errors = "";
									for (let i in err.errors){
										errors+=err.errors[i].message + ",";
								}
								return res.status(500).send(errors)
							}
							else{
								return res.json(newPost);
							}
						})
					}
				})
			}
		})
	},
	dislikePost: (req, res) => {
		//console.log("*********");
		//console.log(req.body.id);
		Topic.findOne({_id: req.params.t_id}, (err, customer) =>{
			if(post == null){
				return res.status(500).send("Topic not found")
			} 
			else{
				Topic.findOne({_id: req.params.p_id}, (err, customer) =>{
					if(post == null){
						return res.status(500).send("Post not found")
					} 
					else{
						post.dislikes++;
						post.save((err, newPost) => {
							if(err){
								console.log(err);
								let errors = "";
									for (let i in err.errors){
										errors+=err.errors[i].message + ",";
								}
								return res.status(500).send(errors)
							}
							else{
								return res.json(newPost);
							}
						})
					}
				})
			}
		})
	},
	addComment: (req, res) => {
		//console.log("*********");
		//console.log(req.body.id);
		Topic.findOne({_id: req.params.t_id}, (err, topic) =>{
			if(topic == null){
				return res.status(500).send("Topic not found")
			} 
			else{
				Post.findOne({_id: req.params.p_id}, (err, post) =>{
					if(post == null){
						return res.status(500).send("Post not found")
					} 
					else{
						var comment = new Comment(req.body);
						comment._user = req.session.user._id
						comment.save((err, newComment) => {
							if(err){
								console.log(err);
								let errors = "";
									for (let i in err.errors){
										errors+=err.errors[i].message + ",";
								}
								return res.status(500).send(errors)
							}
							else{
								post._comments.push(newComment._id);
								post.save( (err, savedPost) => {
									if(err){
										console.log("Saving Post");
										console.log(err)
										let errors = "";
										for (let i in err.errors){
											errors+=err.errors[i].message + ",";
										}
										return res.status(500).send(errors)
									}
									else{
										User.findOne({_id: req.session.user._id}).populate('_topics').populate('posts').populate('_comments').exec( (err, user)=>{
											if(err){
												console.log(err);
												let errors = "";
												for (let i in err.errors){
													errors+=err.errors[i].message + ",";
												}
												return res.status(500).send(errors)
											}
											else{
												if (!user._comments){
													user._comments = [];
												}
												user._comments.push(newComment._id);
												user.save( (err, savedUser) => {
													console.log("save");
													console.log(err);
													if(err){
														console.log("bad");
														console.log(err);
														let errors = "";
														for (let i in err.errors){
															errors+=err.errors[i].message + ",";
														}
														return res.status(500).send(errors)
													}
													else{
														req.session.user = savedUser;
														console.log(savedUser);
														return res.json(newComment);
													}
												})
											}
										})
									}
								})
							}
						})
					}
				})
			}
		})
	},
}