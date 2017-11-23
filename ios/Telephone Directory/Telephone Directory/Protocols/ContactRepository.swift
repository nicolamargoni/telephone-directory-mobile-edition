import Foundation

protocol ContactRepository {
    func add(toAdd: Contact)
    func getAll() -> [Contact]
}
