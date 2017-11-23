import Foundation

class InMemoryContactRepository : ContactRepository{
    var contacts : [Contact]
    
    required init(){
        contacts = []
    }
    
    func add(toAdd contact: Contact) {
        contacts.append(contact)
    }
     
    func getAll() -> [Contact] {
        return contacts
    }
    
}
