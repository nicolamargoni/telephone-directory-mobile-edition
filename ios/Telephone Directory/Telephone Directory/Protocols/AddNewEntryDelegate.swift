//
//  File.swift
//  Telephone Directory
//
//  Created by Nicola Margoni on 23/11/17.
//  Copyright © 2017 Nicola Margoni. All rights reserved.
//

import Foundation

protocol AddNewEntryDelegate {
    func addNewEntryDidFinish(added contact: Contact)
}
