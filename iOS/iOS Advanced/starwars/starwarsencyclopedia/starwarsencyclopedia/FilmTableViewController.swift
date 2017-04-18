//
//  FilmTableViewController.swift
//  starwarsencyclopedia
//
//  Created by Ezra Bergstein on 4/17/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class FilmTableViewController: UITableViewController {
    // Hardcoded data for now
    var films = [String]()
    var indexes = [String: NSDictionary]()
    override func viewDidLoad() {
        super.viewDidLoad()
        StarWarsModel.getAllFilms(completionHandler: { // passing what becomes "completionHandler" in the 'getAllPeople' function definition in StarWarsModel.swift
            data, response, error in
            do {
                // Try converting the JSON object to "Foundation Types" (NSDictionary, NSArray, NSString, etc.)
                if let jsonResult = try JSONSerialization.jsonObject(with: data!, options: JSONSerialization.ReadingOptions.mutableContainers) as? NSDictionary {
                    if let results = jsonResult["results"] as? NSArray {
                        for film in results {
                            let filmDict = film as! NSDictionary
                            self.films.append(filmDict["title"]! as! String)
                            self.indexes[filmDict["title"]! as! String] = filmDict
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
    /*
    func add(_ name: String){
        films.append(name)
        //print(people)
    }*/
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "filmView", sender: indexPath)
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
        return films.count
    }
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // Create a generic cell
        let cell = UITableViewCell()
        // set the default cell label to the corresponding element in the people array
        cell.textLabel?.text = films[indexPath.row]
        // return the cell so that it can be rendered
        return cell
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let filmController = segue.destination as! FilmDetailController
        let index = sender as! NSIndexPath
        let film = films[index.row]
        let info = indexes[film]!
        let relDate = info["release_date"] as! String
        let director = info["director"] as! String
        let opening = info["opening_crawl"] as! String
        filmController.titleText = film
        filmController.relText = relDate
        filmController.directorText = director
        filmController.openText = opening
    }

}
