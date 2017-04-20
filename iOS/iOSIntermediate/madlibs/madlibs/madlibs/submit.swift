//
//  submit.swift
//  madlibs
//
//  Created by Ezra Bergstein on 4/11/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import Foundation

protocol Submitting: class {
    func submit(by controller: LibViewController, with text1: String, with text2: String, with text3: String, with text4: String)
}
