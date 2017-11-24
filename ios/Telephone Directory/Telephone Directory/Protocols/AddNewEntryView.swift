import Foundation

protocol AddNewEntryView{
    func onContactAdded(added: Contact)
    func setFirstNameError(error: String)
}
