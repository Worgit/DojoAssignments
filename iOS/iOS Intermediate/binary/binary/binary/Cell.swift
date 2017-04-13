//
//  Cell.swift
//  binary
//
//  Created by Ezra Bergstein on 4/12/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import UIKit

protocol CellDeligate: class {
    func add(cell: Cell)
    func sub(cell: Cell)
}


class Cell: UITableViewCell{
    
    var base = 0
    var path: Int?
    weak var delegate: CellDeligate?
    
    @IBOutlet weak var number: UILabel!
    @IBAction func minus(_ sender: UIButton) {
        /*if data - base >= 0{
            number.text = String(data - base)*/
        //data = data - base
        delegate?.sub(cell: self)
    }
    @IBAction func plus(_ sender: UIButton) {
        /*number.text = String(data + base)*/
        //data = data + base
        delegate?.add(cell: self)
    }
}
