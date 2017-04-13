//
//  TableViewDelegate.swift
//  todolist
//
//  Created by Ezra Bergstein on 4/13/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import Foundation
protocol Task: class{
    func add(by controller: ViewController, with title: String, with text: String, with date: Date)
}
