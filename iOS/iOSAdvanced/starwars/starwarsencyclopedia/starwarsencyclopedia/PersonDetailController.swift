//
//  PersonDetailController.swift
//  starwarsencyclopedia
//
//  Created by Ezra Bergstein on 4/17/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class PersonDetailController: UIViewController {

    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var gender: UILabel!
    @IBOutlet weak var birth: UILabel!
    @IBOutlet weak var mass: UILabel!
    var nameText: String?
    var genderText: String?
    var birthText: String?
    var massText: String?
    @IBAction func back(_ sender: UIButton) {
        dismiss(animated: true, completion: nil)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        name.text = nameText
        gender.text = genderText
        birth.text = birthText
        mass.text = massText

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
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
