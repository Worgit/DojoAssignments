//
//  FilmDetailController.swift
//  starwarsencyclopedia
//
//  Created by Ezra Bergstein on 4/18/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class FilmDetailController: UIViewController {

    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var director: UILabel!
    @IBOutlet weak var opening: UILabel!
    @IBOutlet weak var relDate: UILabel!
    var titleText: String?
    var directorText: String?
    var relText: String?
    var openText: String?
    override func viewDidLoad() {
        super.viewDidLoad()
        name.text = titleText
        director.text = directorText
        relDate.text = relText
        opening.text = openText
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func backPressed(_ sender: UIButton) {
        dismiss(animated: true, completion: nil)
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
