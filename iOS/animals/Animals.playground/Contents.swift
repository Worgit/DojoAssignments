//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"

class Animal{
    
    var name: String
    var health = 100
    
    init (name:String){
        self.name = name
    }
    
    func displayHealth(){
        print(health)
    }
}

class Cat: Animal{
    
    func growl(){
        print("Rawwr!")
    }
    
    func run(){
        if health - 10 < 0{
            print("Cannot Run")
        }
        else{
            print("Running")
            health -= 10
        }
    }
}

class Lion: Cat{
    
    override init (name:String) {
        super.init(name: name)
        health = 200
    }
    
    override func growl() {
        print("ROAR!!!! I am the King of the Jungle")
    }
}

class Cheetah: Cat{
    
    override func run() {
        if health - 50 < 0{
            print("Cannot Run")
        }
        else{
            print("Running Fast")
            health -= 50
        }
    }
    
    func sleep(){
        if health + 50 >= 200{
            health = 200
        }
        else{
            health += 50
        }
    }
}

var cheetah: Cheetah = Cheetah(name: "Chester")
cheetah.run()
cheetah.run()
cheetah.run()
cheetah.run()
cheetah.displayHealth()
var lion: Lion = Lion(name:"Leo")
lion.run()
lion.run()
lion.run()
lion.growl()
cheetah.sleep()
cheetah.displayHealth()
cheetah.growl()