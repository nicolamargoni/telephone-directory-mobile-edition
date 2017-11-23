import Foundation

class SpyContactRepository : ContactRepository{
    var addGotCalled = false
    var getAllGotCalled = false
    
    func add(toAdd: Contact){
        addGotCalled = true;
    }
    
    func getAll() -> [Contact] {
        getAllGotCalled = true
        let contacts: [Contact] = []
        return contacts
    }
}
