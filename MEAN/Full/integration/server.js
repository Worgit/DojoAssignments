let express = require("express");
let app = express();
let bodyParser = require('body-parser');
let path = require('path');
app.use(express.static(path.join(__dirname, 'public', 'dist')));
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());
require("./server/config/mongoose");
require("./server/config/routes")(app);
app.get('*', function (req, res){
	res.sendFile(path.resolve('public/dist/index.html'));
})
app.listen(8000, ()=> console.log("Server is listening on 8000."))