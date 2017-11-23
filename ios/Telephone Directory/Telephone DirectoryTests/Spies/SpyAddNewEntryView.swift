import Foundation

class SpyAddNewEntryView : AddNewEntryView{
    var onContactAddedGotCalled = false
    func onContactAdded(added contact: Contact) {
        onContactAddedGotCalled = true
    }
}
