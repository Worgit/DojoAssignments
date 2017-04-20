//
//  ViewController.swift
//  tipster
//
//  Created by Ezra Bergstein on 4/6/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var input: UILabel!
    @IBOutlet weak var lowpercent: UILabel!
    @IBOutlet weak var midpercent: UILabel!
    @IBOutlet weak var highpercent: UILabel!
    @IBOutlet weak var lowdiff: UILabel!
    @IBOutlet weak var middiff: UILabel!
    @IBOutlet weak var highdiff: UILabel!
    @IBOutlet weak var lowtotal: UILabel!
    @IBOutlet weak var midtotal: UILabel!
    @IBOutlet weak var hightotal: UILabel!
    @IBOutlet weak var people: UILabel!
    var size = 1
    var inputVal = 0.0
    var tip = 0.01
    var period = 0
    var digit = 0
    
    @IBAction func button(_ sender: UIButton) {
        if sender.tag == 10{
            input.text = "0"
            inputVal = 0.0
            tip = 0.01
            size = 1
            lowpercent.text = "\(round(tip * 100))%"
            midpercent.text = "\(round(tip * 100 + 5))%"
            highpercent.text = "\(round(tip * 100 + 10))%"
            lowdiff.text = String(round((inputVal * tip / Double(size)) * 100)/100)
            middiff.text = String(round((inputVal * (tip + 0.05)/Double(size))*100)/100)
            highdiff.text = String(round((inputVal * (tip + 0.1)/Double(size))*100)/100)
            lowtotal.text = String(round(((inputVal + inputVal * tip)/Double(size))*100)/100)
            midtotal.text = String(round(((inputVal + inputVal * (tip + 0.05))/Double(size))*100)/100)
            hightotal.text = String(round(((inputVal + inputVal * (tip + 0.1))/Double(size))*100)/100)
            period = 0
            digit = 0

        }
        else if sender.tag == 11 && period == 0{
            let check = input.text
            if check != nil{
                input.text = check! + "."
            }
            period += 1
        }
        else if !((sender.tag == 0 && inputVal == 0.0)) && sender.tag != 11 && digit < 2{
            let check = input.text
            if check != nil{
                if check == "0"{
                    input.text = String(sender.tag)
                }
                else{
                    input.text = check! + String(sender.tag)
                }
            }
            inputVal = Double(input.text!)!
            lowpercent.text = "\(round(tip * 100))%"
            midpercent.text = "\(round(tip * 100 + 5))%"
            highpercent.text = "\(round(tip * 100 + 10))%"
            lowdiff.text = String(round((inputVal * tip / Double(size)) * 100)/100)
            middiff.text = String(round((inputVal * (tip + 0.05)/Double(size))*100)/100)
            highdiff.text = String(round((inputVal * (tip + 0.1)/Double(size))*100)/100)
            lowtotal.text = String(round(((inputVal + inputVal * tip)/Double(size))*100)/100)
            midtotal.text = String(round(((inputVal + inputVal * (tip + 0.05))/Double(size))*100)/100)
            hightotal.text = String(round(((inputVal + inputVal * (tip + 0.1))/Double(size))*100)/100)
            if period == 1{
                digit += 1
            }
        }
    }
    
    @IBAction func tipupdate(_ sender: UISlider) {
        tip = Double(sender.value)
        update()
    }
    @IBAction func group(_ sender: UISlider) {
        size = Int(sender.value)
        people.text = "Group Size: \(Int(sender.value))"
        update()
    }
    
    func update(){
        lowpercent.text = "\(round(tip * 100))%"
        midpercent.text = "\(round(tip * 100 + 5))%"
        highpercent.text = "\(round(tip * 100 + 10))%"
        lowdiff.text = String(round((inputVal * tip / Double(size)) * 100)/100)
        middiff.text = String(round((inputVal * (tip + 0.05)/Double(size))*100)/100)
        highdiff.text = String(round((inputVal * (tip + 0.1)/Double(size))*100)/100)
        lowtotal.text = String(round(((inputVal + inputVal * tip)/Double(size))*100)/100)
        midtotal.text = String(round(((inputVal + inputVal * (tip + 0.05))/Double(size))*100)/100)
        hightotal.text = String(round(((inputVal + inputVal * (tip + 0.1))/Double(size))*100)/100)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        input.text = "0"
        lowpercent.text = "\(round(tip * 100))%"
        midpercent.text = "\(round(tip * 100 + 5))%"
        highpercent.text = "\(round(tip * 100 + 10))%"
        lowdiff.text = String(round((inputVal * tip / Double(size)) * 100)/100)
        middiff.text = String(round((inputVal * (tip + 0.05)/Double(size))*100)/100)
        highdiff.text = String(round((inputVal * (tip + 0.1)/Double(size))*100)/100)
        lowtotal.text = String(round(((inputVal + inputVal * tip)/Double(size))*100)/100)
        midtotal.text = String(round(((inputVal + inputVal * (tip + 0.05))/Double(size))*100)/100)
        hightotal.text = String(round(((inputVal + inputVal * (tip + 0.1))/Double(size))*100)/100)
        people.text = "Group Size: 1"

        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

