import Foundation

class AddNewEntryPresenter{
    let contactRepository : ContactRepository!
    let validator : Validator!
    let view : AddNewEntryView!
    
    required init(contactRepository: ContactRepository, validator: Validator, view: AddNewEntryView) {
        self.contactRepository = contactRepository
        self.validator = validator
        self.view = view
    }
    
    func addContact(contact: Contact){
        if validator.isValid(toValidate: contact) {
            contactRepository.add(toAdd: contact)
            view.onContactAdded(added: contact)
        }
    }
}
