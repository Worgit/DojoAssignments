//
//  ViewController.swift
//  madlibs
//
//  Created by Ezra Bergstein on 4/11/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    

    @IBOutlet weak var lib: UILabel!
    @IBAction func unwind(_ segue: UIStoryboardSegue){}
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    /*func submit(by controller: LibViewController, with text1: String, with text2: String, with text3: String, with text4: String){
        lib.text = "We are having a perfectly \(text1) time now.  Later we will \(text2) and \(text3) in the \(text4)."
    }*/


}

