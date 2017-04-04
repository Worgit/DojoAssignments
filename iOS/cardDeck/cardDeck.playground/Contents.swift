//: Playground - noun: a place where people can play

import UIKit

struct Card{
    var value: String
    var suit: String
    var numerical_value: Int
}

class Deck{
    let suits = ["Clubs", "Diamonds", "Hearts", "Spades"]
    let numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
    let values = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
    var cards: [Card] = []
    init(){
        for i in 0...3{
            for j in 0...12{
                let new: Card = Card(value: values[j], suit: suits[i], numerical_value: numbers[j])
                cards.append(new)
            }
        }
    }
    
    func deal() -> Card{
        let top: Card = cards.remove(at: 0)
        return top
    }
    
    func reset(){
        cards = []
        for i in 0...3{
            for j in 0...12{
                let new: Card = Card(value: values[j], suit: suits[i], numerical_value: numbers[j])
                cards.append(new)
            }
        }
    }
    
    func shuffle(){
        for _ in 0...cards.count - 1{
            let index1 = Int(arc4random_uniform(UInt32(cards.count)))
            let index2 = Int(arc4random_uniform(UInt32(cards.count)))
            let temp = cards[index1]
            cards[index1] = cards[index2]
            cards[index2] = temp
        }
    }
}

class Player{
    var hand: [Card] = []
    
    func draw(deck: Deck) -> Card{
        let card = deck.deal()
        hand.append(card)
        return card
    }
    
    func discard(drop: Card) -> Bool{
        for i in 0...hand.count - 1{
            if hand[i].value == drop.value && hand[i].suit == drop.suit && hand[i].numerical_value == drop.numerical_value{
                hand.remove(at: i)
                return true
            }
        }
        return false
    }
}

var testDeck: Deck = Deck()
