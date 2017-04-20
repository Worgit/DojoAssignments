//
//  ViewController.swift
//  starwarsencyclopedia
//
//  Created by Ezra Bergstein on 4/17/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit
class PeopleViewController: UITableViewController {
    // Hardcoded data for now
    var people = [String]()
    var indexes = [String: NSDictionary]()
    override func viewDidLoad() {
        super.viewDidLoad()
        StarWarsModel.getAllPeople(completionHandler: { // passing what becomes "completionHandler" in the 'getAllPeople' function definition in StarWarsModel.swift
            data, response, error in
            do {
                // Try converting the JSON object to "Foundation Types" (NSDictionary, NSArray, NSString, etc.)
                if let jsonResult = try JSONSerialization.jsonObject(with: data!, options: JSONSerialization.ReadingOptions.mutableContainers) as? NSDictionary {
                    if let results = jsonResult["results"] as? NSArray {
                        var counter = 0;
                        for person in results {
                            let personDict = person as! NSDictionary
                            //print(personDict)
                            self.people.append(personDict["name"]! as! String)
                            self.indexes[personDict["name"]! as! String] = personDict
                            counter += 1
                        }
                    }
                }
                DispatchQueue.main.async {
                    self.tableView.reloadData()
                }
            } catch {
                print("Something went wrong")
            }
        })
    }

    
    /*func add(_ name: String){
        people.append(name)
        //print(people)
    }*/
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "view", sender: indexPath)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    override func numberOfSections(in tableView: UITableView) -> Int {
        // if we return - sections we won't have any sections to put our rows in
        return 1
    }
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // return the count of people in our data array
        return people.count
    }
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // Create a generic cell
        let cell = UITableViewCell()
        // set the default cell label to the corresponding element in the people array
        cell.textLabel?.text = people[indexPath.row]
        // return the cell so that it can be rendered
        return cell
    }
    /*func populate(personController: PersonDetailController, personDict: NSDictionary){
        return
    }*/
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let personController = segue.destination as! PersonDetailController
        let index = sender as! NSIndexPath
        let person = people[index.row]
        let info = indexes[person]!
        let birth = info["birth_year"] as! String
        let gender = info["gender"] as! String
        let mass = info["mass"] as! String
        personController.nameText = person
        personController.birthText = birth
        personController.genderText = gender
        personController.massText = mass
    }
}
