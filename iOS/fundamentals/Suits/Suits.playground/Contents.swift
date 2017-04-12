//: Playground - noun: a place where people can play

import UIKit

let suits = ["Clubs", "Diamonds", "Hearts", "Spades"]
let cards = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
var deckOfCards = [String: [Int]]()
for suit in suits{
    for card in cards{
        if let temp = deckOfCards[suit]{
            deckOfCards[suit]!.append(card)
        }
        else{
            print(suit)
            deckOfCards[suit] = [card]
        }
    }
}
print(deckOfCards)
