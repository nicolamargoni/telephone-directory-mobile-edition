import Foundation

class SpyHomePageView : HomePageView{
    var updateContactsGotCalled = false
    
    func updateContacts(contacts: [Contact]){
        updateContactsGotCalled = true
    }
}
