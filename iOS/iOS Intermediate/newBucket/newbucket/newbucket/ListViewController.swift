//
//  ListViewController.swift
//  newbucket
//
//  Created by Ezra Bergstein on 4/10/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ListViewController: UITableViewController{
    weak var delegate: Choice?
    var item: String?
    var indexPath: NSIndexPath?
    
    @IBOutlet weak var textField: UITextField!
    @IBAction func cancelButtonPressed(_ sender: UIBarButtonItem) {
        delegate?.cancelButtonPressed(by: self)
    }
    @IBAction func savePressed(_ sender: UIBarButtonItem) {
        let text = textField.text!
        delegate?.addButtonPressed(by: self, with: text, at: indexPath)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        textField.text = item
    }
}
