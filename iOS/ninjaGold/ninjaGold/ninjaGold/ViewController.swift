//
//  ViewController.swift
//  ninjaGold
//
//  Created by Ezra Bergstein on 4/5/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var score: UILabel!
    
    @IBOutlet weak var farmearn: UILabel!
    @IBOutlet weak var caveearn: UILabel!
    @IBOutlet weak var houseearn: UILabel!
    @IBOutlet weak var casinoearn: UILabel!
    var raw = 0
    
    @IBAction func farm(_ sender: UIButton) {
        let randint = Int(arc4random_uniform(11)) + 10
        raw += randint
        score.text = "Score: \(raw)"
        farmearn.text = "You Earned \(randint) Gold!"
        farmearn.isHidden = false
        caveearn.isHidden = true
        houseearn.isHidden = true
        casinoearn.isHidden = true
    }
    
    
    @IBAction func Cave(_ sender: UIButton) {
        let randint = Int(arc4random_uniform(6)) + 5
        raw += randint
        score.text = "Score: \(raw)"
        caveearn.text = "You Earned \(randint) Gold!"
        farmearn.isHidden = true
        caveearn.isHidden = false
        houseearn.isHidden = true
        casinoearn.isHidden = true
    }
    
    
    @IBAction func House(_ sender: UIButton) {
        let randint = Int(arc4random_uniform(4)) + 2
        raw += randint
        score.text = "Score: \(raw)"
        houseearn.text = "You Earned \(randint) Gold!"
        farmearn.isHidden = true
        caveearn.isHidden = true
        houseearn.isHidden = false
        casinoearn.isHidden = true
    }
    
    
    @IBAction func casino(_ sender: UIButton) {
        let randint = Int(arc4random_uniform(101)) - 50
        raw += randint
        score.text = "Score: \(raw)"
        if randint < 0{
            casinoearn.text = "You Lost \(randint * -1) Gold."
        }
        else{
            casinoearn.text = "You Earned \(randint) Gold!"
        }
        farmearn.isHidden = true
        caveearn.isHidden = true
        houseearn.isHidden = true
        casinoearn.isHidden = false
    }
    
    
    @IBAction func reset(_ sender: UIButton) {
        raw = 0
        score.text = "Score: \(raw)"
        farmearn.isHidden = true
        caveearn.isHidden = true
        houseearn.isHidden = true
        casinoearn.isHidden = true
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        score.text = "Score: \(raw)"
        farmearn.isHidden = true
        caveearn.isHidden = true
        houseearn.isHidden = true
        casinoearn.isHidden = true
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

