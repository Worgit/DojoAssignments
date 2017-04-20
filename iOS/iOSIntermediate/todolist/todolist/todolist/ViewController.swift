//
//  ViewController.swift
//  todolist
//
//  Created by Ezra Bergstein on 4/13/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    weak var delegate: Task?

    @IBOutlet weak var titlebox: UITextField!
    @IBOutlet weak var textbox: UITextView!
    @IBOutlet weak var datebox: UIDatePicker!
    @IBAction func add(_ sender: UIButton) {
        let titletext = titlebox.text!
        let text = textbox.text!
        let datetext = datebox.date
        delegate?.add(by: self, with: titletext, with: text, with: datetext)
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

