//
//  ViewController.swift
//  coldcall1
//
//  Created by Ezra Bergstein on 4/5/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var text: UILabel!
    @IBOutlet weak var number: UILabel!
    
    let nameBank = ["Firebird", "Phoenix", "Abomination", "Argosy", "Enterprise", "Cruiser", "Carrier", "Thunderforge"]
    
    @IBAction func call(_ sender: UIButton) {
        let index = Int(arc4random_uniform(UInt32(nameBank.count)))
        text.text = nameBank[index]
        let genNum = arc4random_uniform(5) + 1
        number.text = String(genNum)
        if genNum < 3{
            number.textColor = UIColor.red
        }
        else if genNum < 5{
            number.textColor = UIColor.orange
        }
        else{
            number.textColor = UIColor.green
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

