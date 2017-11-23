import Foundation

class Contact : NSObject{
    var firstName : String!
    var lastName : String!
    var telephoneNumber : String!
    
    var fullName : String {
        get {
            return firstName + " " + lastName
        }
    }
    
    required init(firstName: String, lastName: String, telephoneNumber: String) {
        self.firstName = firstName
        self.lastName = lastName
        self.telephoneNumber = telephoneNumber
    }
}
