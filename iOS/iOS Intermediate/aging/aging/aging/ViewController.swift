//
//  ViewController.swift
//  aging
//
//  Created by Ezra Bergstein on 4/10/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    var names = ["George", "Betty", "Fran", "Joe", "Helda", "Winifred", "Zed", "Sara", "Jeffy", "Abraham", "Anna", "Melinda"]
    @IBOutlet weak var table: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        table.dataSource = self
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}

extension ViewController: UITableViewDataSource{
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return names.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Names", for: indexPath)
        cell.textLabel?.text = "\(names[indexPath.row])"
        cell.detailTextLabel?.text = "\(String(arc4random_uniform(90) + 5)) years old"
        return cell
        
    }
}
