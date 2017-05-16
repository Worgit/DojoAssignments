var suits = ['Clubs', 'Hearts', 'Spades', 'Diamonds'];
var values = ['Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Jack', 'Queen', 'King', 'Ace'];
var deck = [];
for(var i in suits){
	for(var j in values){
		deck.push({
			suit: suits[i],
			value: values[j]
		});
	}
}
function shuffle(){
	for(var i = 0; i < deck.length; i++){
		var index = Math.floor(Math.random() * 52);
		var card = deck[index];
		deck.splice(index, 1);
		deck.push(card);
	}
}
function deal(){
		var index = Math.floor(Math.random() * deck.length);
		var card = deck[index];
		deck.splice(index, 1);
		return (card);
}
shuffle();
for(var k in deck){
	console.log(deck[k].value + " of " + deck[k].suit);
}
console.log('\n');
//console.log(deal());
function playerConstructor(name){
  player = {};
  player.name = name;
  player.hand = [];
  player.addCard = function(){
  	//console.log(card)
    player.hand.push(deal());
    //console.log(player.hand);
  };
  player.discard = function(card){
  	for(check in player.hand){
  		if (player.hand[check].value == card.value && player.hand[check].suit == card.suit){
  			player.hand.splice(check, 1);
  			break;
  		}
  	}
  };
  //console.log(player.name);
  return player;
};
var player = playerConstructor("Verge");
player.addCard();
player.addCard();
player.addCard();
player.addCard();
player.addCard();
for(card in player.hand){
	console.log(player.hand[card].value + " of " + player.hand[card].suit);
}
console.log('\n');
var test = player.hand[3];
console.log(test)
player.discard(test);
for(card in player.hand){
	console.log(player.hand[card].value + " of " + player.hand[card].suit);
}