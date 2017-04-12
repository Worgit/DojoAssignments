//: Playground - noun: a place where people can play

import UIKit

for i in 1...255 {
    print(i)
}

for j in 1...100 {
    if (j % 3 == 0 || j % 5 == 0) && !(j % 3 == 0 && j % 5 == 0){
        print(j)
    }
}

for k in 1...100 {
    if k % 3 == 0 && k % 5 == 0{
        print("FizzBuzz")
    }
    else{
        if k % 3 == 0{
            print("Fizz")
        }
        else if k % 5 == 0{
            print("Buzz")
        }
    }
}