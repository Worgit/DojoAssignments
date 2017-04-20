//
//  DirectionViewController.swift
//  direction
//
//  Created by Ezra Bergstein on 4/11/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class DirectionViewController: UIViewController {
    
    var text: String?

    @IBOutlet weak var direction: UILabel!
    @IBAction func backPressed(_ sender: UIButton) {
        self.performSegue(withIdentifier: "back", sender: sender)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        direction.text = text

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
