//
//  ViewController.swift
//  tictactoe
//
//  Created by Ezra Bergstein on 4/5/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var winner: UILabel!
    var player = "red"
    var checkedlist = ["","","","","","","","",""]
    var selected = "grey"
    
    @IBOutlet weak var button1: UIButton!
    @IBOutlet weak var button2: UIButton!
    @IBOutlet weak var button3: UIButton!
    @IBOutlet weak var button4: UIButton!
    @IBOutlet weak var button5: UIButton!
    @IBOutlet weak var button6: UIButton!
    @IBOutlet weak var button7: UIButton!
    @IBOutlet weak var button8: UIButton!
    @IBOutlet weak var button9: UIButton!
    
    @IBAction func square(_ sender: UIButton) {
        if player == "red" && sender.backgroundColor != UIColor.red && sender.backgroundColor != UIColor.blue{
            sender.backgroundColor = UIColor.red
            checkedlist[sender.tag - 1] = "red"
            selected = "red"
        }
        else if player == "blue" && sender.backgroundColor != UIColor.red && sender.backgroundColor != UIColor.blue{
            sender.backgroundColor = UIColor.blue
            checkedlist[sender.tag - 1] = "blue"
            selected = "blue"
        }
        check()
        if player == "red" && selected == "red"{
            player = "blue"
        }
        else if player == "blue" && selected == "blue"{
            player = "red"
        }
    }
    
    @IBAction func reset(_ sender: UIButton) {
        player = "red"
        checkedlist = ["","","","","","","","",""]
        button1.backgroundColor = UIColor.gray
        button2.backgroundColor = UIColor.gray
        button3.backgroundColor = UIColor.gray
        button4.backgroundColor = UIColor.gray
        button5.backgroundColor = UIColor.gray
        button6.backgroundColor = UIColor.gray
        button7.backgroundColor = UIColor.gray
        button8.backgroundColor = UIColor.gray
        button9.backgroundColor = UIColor.gray
        winner.isHidden = true
    }
    
    func check(){
        if (checkedlist[0] == player && checkedlist[1] == player && checkedlist[2] == player) || (checkedlist[0] == player && checkedlist[3] == player && checkedlist[6] == player) || (checkedlist[0] == player && checkedlist[4] == player && checkedlist[8] == player) || (checkedlist[2] == player && checkedlist[4] == player && checkedlist[6] == player) || (checkedlist[3] == player && checkedlist[4] == player && checkedlist[5] == player) || (checkedlist[6] == player && checkedlist[7] == player && checkedlist[8] == player) || (checkedlist[1] == player && checkedlist[4] == player && checkedlist[7] == player) || (checkedlist[2] == player && checkedlist[5] == player && checkedlist[8] == player){
            winner.text = "The \(player) player won!"
            winner.isHidden = false
            player = "done"
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        winner.isHidden = true
        button1.backgroundColor = UIColor.gray
        button2.backgroundColor = UIColor.gray
        button3.backgroundColor = UIColor.gray
        button4.backgroundColor = UIColor.gray
        button5.backgroundColor = UIColor.gray
        button6.backgroundColor = UIColor.gray
        button7.backgroundColor = UIColor.gray
        button8.backgroundColor = UIColor.gray
        button9.backgroundColor = UIColor.gray
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

