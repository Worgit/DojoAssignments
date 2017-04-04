//: Playground - noun: a place where people can play

import UIKit

var arr: [Int] = []

for i in 1...255{
    arr.append(i)
}
let input1: Int = Int(arc4random_uniform(255))
let input2: Int = Int(arc4random_uniform(255))
let temp: Int = arr[input1]
arr[input1] = arr[input2]
arr[input2] = temp
for i in 1...100{
    var input1: Int = Int(arc4random_uniform(255))
    var input2: Int = Int(arc4random_uniform(255))
    var temp: Int = arr[input1]
    arr[input1] = arr[input2]
    arr[input2] = temp
}
for i in 0...254{
    if arr[i] == 42{
        arr.remove(at: i)
        print("We found the answer to the Ultimate Question of Life, the Universe, and Everything at index \(i)")
        break
    }
}
print(arr)
