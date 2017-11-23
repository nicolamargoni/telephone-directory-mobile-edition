import Foundation

class HomePagePresenter{
    var contactRepository : ContactRepository!
    var view : HomePageView!
    
    required init(contactRepository: ContactRepository, view: HomePageView){
        self.contactRepository = contactRepository
        self.view = view
    }
    
    func updateContacts(){
        view.updateContacts(contacts: contactRepository.getAll())
    }
}
