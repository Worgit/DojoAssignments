//
//  Protocols.swift
//  newbucket
//
//  Created by Ezra Bergstein on 4/10/17.
//  Copyright © 2017 Ezra Bergstein. All rights reserved.
//

import Foundation
protocol Choice: class {
    func cancelButtonPressed(by controller: ListViewController)
    func addButtonPressed(by controller: ListViewController, with text:String, with oldtext: String?, at indexPath: NSIndexPath?)
}
