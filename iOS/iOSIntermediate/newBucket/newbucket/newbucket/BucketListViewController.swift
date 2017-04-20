//
//  ViewController.swift
//  newbucket
//
//  Created by Ezra Bergstein on 4/10/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit
import CoreData

class BucketViewController: UITableViewController, Choice{
    
    //var items = [BucketListItem]()
    var newitems: [String] = []
    var ids: [String: String] = [:]

    let managedObjectContext = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    
    override func viewDidLoad() {
        TaskModel.getAllTasks(){
        data, response, error in
            do {
                //print ("**********")
                if let tasks = try JSONSerialization.jsonObject(with: data!, options: JSONSerialization.ReadingOptions.mutableContainers) as? NSArray {
                    for task in tasks{
                        let taskDict = task as! NSDictionary
                        //print ("**********")
                        //print(tasks)
                        let temp = taskDict["objective"]! as! String
                        self.newitems.append(temp)
                        let temp2 = taskDict["_id"]! as! String
                        self.ids[temp] = temp2
                    }
                }
                DispatchQueue.main.async {
                    self.tableView.reloadData()
                }
            } catch {
                print("Something went wrong")
            }
        }
        super.viewDidLoad()
        //fetchAllItems()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        //return items.count
        return newitems.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Item")!
        //cell.textLabel?.text = items[indexPath.row].text!
        cell.textLabel?.text = newitems[indexPath.row]
        return cell
    }
    
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        let item = newitems[indexPath.row]
        let id = ids[item]
        /*managedObjectContext.delete(item)
        do{
            try managedObjectContext.save()
        } catch {
            print("\(error)")
        }
        items.remove(at: indexPath.row)*/
        //newitems.remove(at: indexPath.row)
        TaskModel.deleteTaskWithObjective(id: id!, objective: item){
            data, response, error in
            do {
                //print ("**********")
                if let tasks = try JSONSerialization.jsonObject(with: data!, options: JSONSerialization.ReadingOptions.mutableContainers) as? NSArray {
                    for task in tasks{
                        let taskDict = task as! NSDictionary
                        //print ("**********")
                        print(taskDict)
                    }
                }
                DispatchQueue.main.async {
                    self.tableView.reloadData()
                }
            } catch {
                print("Something went wrong")
                print(error)
            }
        }
        newitems = []
        ids = [:]
        TaskModel.getAllTasks(){
            data, response, error in
            do {
                //print ("**********")
                if let tasks = try JSONSerialization.jsonObject(with: data!, options: JSONSerialization.ReadingOptions.mutableContainers) as? NSArray {
                    for task in tasks{
                        let taskDict = task as! NSDictionary
                        //print ("**********")
                        //print(tasks)
                        let temp = taskDict["objective"]! as! String
                        self.newitems.append(temp)
                        let temp2 = taskDict["_id"]! as! String
                        self.ids[temp] = temp2
                    }
                }
                DispatchQueue.main.async {
                    self.tableView.reloadData()
                }
            } catch {
                print("Something went wrong")
            }
        }
        tableView.reloadData()
    }
    
    
    func cancelButtonPressed(by controller: ListViewController){
        dismiss(animated: true, completion: nil)
    }
    
    override func tableView(_ tableView: UITableView, accessoryButtonTappedForRowWith indexPath: IndexPath) {
        performSegue(withIdentifier: "EditList", sender: indexPath)
    }
    
    func addButtonPressed(by controller: ListViewController, with text: String, with oldText: String?, at indexPath: NSIndexPath?){
        if indexPath != nil{
            /*let item = items[temp.row]
            item.text = text*/
            //newitems[temp.row] = text
            print(ids)
            TaskModel.updateTaskWithObjective(id: ids[oldText!]!, objective: text){
                data, response, error in
                do {
                    if let tasks = try JSONSerialization.jsonObject(with: data!, options: JSONSerialization.ReadingOptions.mutableContainers) as? NSArray {
                        /*for task in tasks{
                            let taskDict = task as! NSDictionary
                            //print ("**********")
                            print(taskDict)
                        }*/
                        //print ("**********")
                        print(tasks)
                    }
                    DispatchQueue.main.async {
                        self.tableView.reloadData()
                    }
                } catch {
                    print("Something went wrong")
                    print(error)
                }
            }
            
        }
        else{/*
            let item = NSEntityDescription.insertNewObject(forEntityName: "BucketListItem", into: managedObjectContext) as! BucketListItem
            item.text = text
            //items.append(item)
            newitems.append(text)
             */
            TaskModel.addTaskWithObjective(objective: text){
                data, response, error in
                do {
                    //print ("**********")
                    if let tasks = try JSONSerialization.jsonObject(with: data!, options: JSONSerialization.ReadingOptions.mutableContainers) as? NSArray {
                        for task in tasks{
                            let taskDict = task as! NSDictionary
                            //print ("**********")
                            print(taskDict)
                        }
                    }
                    DispatchQueue.main.async {
                        self.tableView.reloadData()
                    }
                } catch {
                    print("Something went wrong")
                }
            }
        }/*
        do{
            try managedObjectContext.save()
        } catch {
            print("\(error)")
        }*/
        newitems = []
        ids = [:]
        TaskModel.getAllTasks(){
            data, response, error in
            do {
                //print ("**********")
                if let tasks = try JSONSerialization.jsonObject(with: data!, options: JSONSerialization.ReadingOptions.mutableContainers) as? NSArray {
                    for task in tasks{
                        let taskDict = task as! NSDictionary
                        //print ("**********")
                        //print(tasks)
                        let temp = taskDict["objective"]! as! String
                        self.newitems.append(temp)
                        let temp2 = taskDict["_id"]! as! String
                        self.ids[temp] = temp2
                    }
                }
                DispatchQueue.main.async {
                    self.tableView.reloadData()
                }
            } catch {
                print("Something went wrong")
            }
        }
        tableView.reloadData()
        dismiss(animated: true, completion: nil)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let navigationController = segue.destination as! UINavigationController
        let controller = navigationController.topViewController as! ListViewController
        controller.delegate = self
        if !(sender is UIBarButtonItem){
            let indexPath = sender as! NSIndexPath
            //let item = items[indexPath.row]
            let item = newitems[indexPath.row]
            controller.item = item
            controller.indexPath = indexPath
        }
    }/*

    func fetchAllItems(){
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "BucketListItem")
        do{
            let result = try managedObjectContext.fetch(request)
            items = result as! [BucketListItem]
        } catch {
            print("\(error)")
        }
    }*/
}

