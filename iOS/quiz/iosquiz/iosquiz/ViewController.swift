//
//  ViewController.swift
//  iosquiz
//
//  Created by Ezra Bergstein on 4/5/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var question: UILabel!
    @IBOutlet weak var answer: UILabel!
    
    let quizBank = [
        ("What is the first step of iOS development?", "Create the user interface. As we create the UI, we will get a better understanding of our application. Then we breath life into our application."),
        ("Why do we use Autolayout?", "We use Autolayout to set constraints on our View objects so that it can adapt to different screen sizes and to different orientations (portrait or landscape)"),
        ("What is the difference between IBAction and IBOutlet?", "Both IBAction and IBOutlets are connections from View elements on our storyboard. IBOutlet connects a proprety in our code to an object in a storyboard while an IBAction connects an event generated by an object in a storyboard to a method in our code."),
        ("What is the Model in MVC responsible for?", "Model objects are responsible for the data of our application. It is important to note that Model objects know nothing about the user interface. An example of a Model could be a list of questions and answers."),
        ("What is the View in MVC responsible for?", "View objects are objects that can be seen by the user (objects you drag into the storyboard). Some examples are labels and buttons."),
        ("What is the Controller in MVC responsible for?", "Controller objects facilitate the communication between the Model and the View since the Model and the View should never directly talk to each other (remember the Model knows nothing about the user interface).")
    ]
    var current = 0
    
    @IBAction func answerPressed(_ sender: UIButton) {
        if answer.isHidden == false{
            answer.isHidden = true
        }
        else{
            answer.isHidden = false
        }
    }
    
    @IBAction func nextPressed(_ sender: UIButton) {
        if current < quizBank.count - 1{
            current += 1
        }
        else{
            current = 0
        }
        updateUI()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        updateUI()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func updateUI(){
        question.text = quizBank[current].0
        answer.text = quizBank[current].1
        answer.isHidden = true
    }


}

