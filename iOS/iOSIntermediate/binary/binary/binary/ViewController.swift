//
//  ViewController.swift
//  binary
//
//  Created by Ezra Bergstein on 4/12/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController, CellDeligate {
    
    var nums: [Int] = []
    var totalsum: [Int] = []
    var total = 0

    @IBOutlet weak var sum: UILabel!
    @IBOutlet weak var tableView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        if nums.count == 0{
            for i in 0...15{
                if i == 0{
                    nums.append(1)
                }
                else{
                    nums.append(nums[i-1] * 10)
                }
                totalsum.append(0)
            }
        }
        //total = 0
        for i in 0...15{
            total = total + totalsum[i]
        }
        sum.text = String(total)
        tableView.dataSource = self
        print(nums)/*
        print(nums.count)*/
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func add(cell: Cell){
        //print(cell.indexPath?.row)
        totalsum[cell.path!] += cell.base
        total = 0
        for i in 0...15{
            total = total + totalsum[i]
        }
        sum.text = String(total)

        //tableView.reloadData()
    }
    func sub(cell: Cell){
        //print(cell.indexPath?.row)
        totalsum[cell.path!] -= cell.base
        total = 0
        for i in 0...15{
            total = total + totalsum[i]
        }
        sum.text = String(total)

        //tableView.reloadData()
    }


}

extension ViewController: UITableViewDataSource{
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell") as! Cell
        //if cell.base == nums[indexPath.row]{
        cell.number.text = "\(nums[indexPath.row])"
        //}
        cell.base = nums[indexPath.row]
        cell.delegate = self
        cell.path = indexPath.row
        return cell
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return nums.count
    }
    
}

