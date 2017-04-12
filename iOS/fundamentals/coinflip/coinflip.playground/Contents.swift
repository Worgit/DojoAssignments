//: Playground - noun: a place where people can play

import UIKit

func coinToss() -> Int{
    print("Tossing a Coin!")
    let result: Int = Int(arc4random_uniform(2))
    if result == 0{
        print("Heads")
    }
    else{
        print ("Tails")
    }
    return result
}

func tossMultipleCoins(total: Int) -> Double{
    var heads: Double = 0.0
    var tails: Double = 0.0
    for _ in 1...total{
        let toss = coinToss()
        if toss == 0{
            heads += 1
        }
        else{
            tails += 1
        }
    }
    return heads/(heads+tails)
}

print(tossMultipleCoins(total: 5))