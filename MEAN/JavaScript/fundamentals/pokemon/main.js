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
	$.get("http://pokeapi.co/api/v1/pokemon/" + num + "/", function(result){
		pokemon.name = result.name;
		pokemon.weight = result.weight;
	});
	console.log(pokemon);
	return pokemon
}

function playerConstructor(name){
  player = {};
  player.name = name;
	player.hand = [];
  player.addCard = function(card){
    player.hand.push(card);
  };
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
for (player in game.players){
	console.log(player.hand);
}