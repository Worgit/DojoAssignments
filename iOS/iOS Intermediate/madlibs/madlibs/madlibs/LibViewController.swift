//
//  LibControllerViewController.swift
//  madlibs
//
//  Created by Ezra Bergstein on 4/11/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class LibViewController: UIViewController {
    
    //weak var delegate: Submitting?

    @IBOutlet weak var textField1: UITextField!
    @IBOutlet weak var textField2: UITextField!
    @IBOutlet weak var textField3: UITextField!
    @IBOutlet weak var textField4: UITextField!
    @IBAction func submitPressed(_ sender: UIButton) {
        performSegue(withIdentifier: "submit", sender: sender)
    }
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if !(segue.identifier == "edit"){
            let destination = segue.destination as! ViewController
            if sender is UIButton{
                let text1 = textField1.text!
                let text2 = textField2.text!
                let text3 = textField3.text!
                let text4 = textField4.text!
                //destination.submit(by: self, with: text1, with: text2, with: text3, with: text4)
                destination.lib.text =
            "We are having a perfectly \(text1) time now.  Later we will \(text2) and \(text3) in the \(text4)."
            }
        }
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
