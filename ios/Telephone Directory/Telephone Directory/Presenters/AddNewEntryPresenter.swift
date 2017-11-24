import Foundation

class AddNewEntryPresenter{
    let contactRepository : ContactRepository!
    let contactValidator : ContactValidatorProtocol!
    let view : AddNewEntryView!
    
    required init(contactRepository: ContactRepository, contactValidator: ContactValidatorProtocol, view: AddNewEntryView) {
        self.contactRepository = contactRepository
        self.contactValidator = contactValidator
        self.view = view
    }
    
    func addContact(contact: Contact){
        let contactValidation = contactValidator.validate(toValidate: contact)
        
        if contactValidation.isValid {
            contactRepository.add(toAdd: contact)
            view.onContactAdded(added: contact)
        } else {
            view.setFirstNameError(error: "first name can't be empty")
        }
    }
}
