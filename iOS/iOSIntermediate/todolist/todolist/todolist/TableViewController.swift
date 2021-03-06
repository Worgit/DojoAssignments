//
//  TableViewController.swift
//  todolist
//
//  Created by Ezra Bergstein on 4/13/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit
import CoreData

class TableViewController: UITableViewController, Task {

    var tasks = [TaskItem]()
    
    let managedObjectContext = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    override func viewDidLoad() {
        super.viewDidLoad()
        fetchAllItems()
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return tasks.count
    }
    
    func fetchAllItems(){
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "TaskItem")
        do{
            let result = try managedObjectContext.fetch(request)
            tasks = result as! [TaskItem]
        } catch {
            print("\(error)")
            //print("****************")
        }
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if let cell = tableView.cellForRow(at: indexPath) {
            if cell.accessoryType == .none{
                cell.accessoryType = .checkmark
            }
            else{
                cell.accessoryType = .none
            }
            do{
                try managedObjectContext.save()
            } catch {
                print("\(error)")
            }
        }
    }
    /*
    override func tableView(_ tableView: UITableView, didDeselectRowAt indexPath: IndexPath) {
        if let cell = tableView.cellForRow(at: indexPath) {
            cell.accessoryType = .none
            do{
                try managedObjectContext.save()
            } catch {
                print("\(error)")
            }
        }
    }*/

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let controller = segue.destination as! ViewController
        controller.delegate = self
    }
    
    func add(by controller: ViewController, with title: String, with text: String, with date: Date){
        let task = NSEntityDescription.insertNewObject(forEntityName: "TaskItem", into: managedObjectContext) as! TaskItem
        task.title = title
        task.text = text
        task.date = date as NSDate
        tasks.append(task)
        do{
            try managedObjectContext.save()
        } catch {
            print("\(error)")
        }
        //print("****************")
        //print(tasks)
        tableView.reloadData()
        dismiss(animated: true, completion: nil)
        
    }
    
     override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
     let cell = tableView.dequeueReusableCell(withIdentifier: "Cell") as!  Cell
     cell.title.text = tasks[indexPath.row].title!
     cell.desc.text = tasks[indexPath.row].text!
     cell.date.text = String(describing: tasks[indexPath.row].date!)
     return cell
     }
    /*
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "reuseIdentifier", for: indexPath)

        // Configure the cell...

        return cell
    }
    */

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
