import Foundation

class StubContactRepository : ContactRepository{
    func add(toAdd: Contact) {
    }
    
    func getAll() -> [Contact] {
        let contacts : [Contact] = []
        return contacts
    }
}
