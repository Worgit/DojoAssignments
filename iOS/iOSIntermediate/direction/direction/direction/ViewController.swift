//
//  ViewController.swift
//  direction
//
//  Created by Ezra Bergstein on 4/11/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func east(_ sender: UIButton) {
        performSegue(withIdentifier: "Change", sender: sender)
    }
    
    @IBAction func south(_ sender: UIButton) {
        performSegue(withIdentifier: "Change", sender: sender)
    }
    @IBAction func west(_ sender: UIButton) {
        performSegue(withIdentifier: "Change", sender: sender)
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if !(segue.identifier == "back"){
            let destination = segue.destination as! DirectionViewController
            if sender is UIButton{
                let button = sender as! UIButton
                destination.text = button.titleLabel!.text
            }
        }
    }
    @IBAction func unwindBack(_ segue: UIStoryboardSegue){}
}

