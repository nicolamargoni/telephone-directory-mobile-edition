import Foundation

class SpyAddNewEntryView : AddNewEntryView{
    var onContactAddedGotCalled = false
    var setFirstNameErrorGotCalled = false
    func onContactAdded(added contact: Contact) {
        onContactAddedGotCalled = true
    }

    func setFirstNameError(error: String) {
        setFirstNameErrorGotCalled = true
    }
}
