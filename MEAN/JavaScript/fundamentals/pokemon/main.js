var game = {
  players: [],
  addPlayer: function(player){
  	this.players.push(player);
  }
};

var body = document.body

function newCard(){
	var num = Math.floor(Math.random() * 718) + 1;
	var pokemon = {
		name: "",
		weight: -1
	};
	$.ajax({
		url: "http://pokeapi.co/api/v1/pokemon/" + num + "/", 
		success: function(result){
			//console.log("before");
			pokemon.name = result.name;
			pokemon.weight = result.weight;
		},
		async: false
	});
	//console.log("after");
	return pokemon
}

/*function getData(){
}*/

function playerConstructor(name){
  player = {};
  player.name = name;
  player.hand = [];
  player.handWeight = 0;
  player.addCard = function(card){
  	//console.log(card)
    player.hand.push(card);
    //console.log(player.hand);
  };
  //console.log(player.name);
  return player;
};
var player1 = playerConstructor("Ted");
var player2 = playerConstructor("Rick");
var player3 = playerConstructor("Baxter");
player1.addCard(newCard());
player1.addCard(newCard());
player1.addCard(newCard());
player2.addCard(newCard());
player2.addCard(newCard());
player3.addCard(newCard());
game.addPlayer(player1);
game.addPlayer(player2);
game.addPlayer(player3);
console.log(game);
var win = -1;
var maxweight = 0;
for (player in game.players){
	game.players[player].handWeight = 0;
	for (card in game.players[player].hand){
		game.players[player].handWeight += game.players[player].hand[card].weight;
	}
	if(game.players[player].handWeight > maxweight){
		maxweight = game.players[player].handWeight
		win = player;
	}
}
console.log(game.players[win].name + " won!");