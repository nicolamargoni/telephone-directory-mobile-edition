import Foundation

class ContactValidator : ContactValidatorProtocol{
    func validate(toValidate contact: Contact) -> ContactValidation {
        var contactValidation = ContactValidation()
        
        if(contact.firstName.isEmpty){
            contactValidation.firstNameValidation = .notValidIsEmpty
        } else {
            contactValidation.firstNameValidation = .isValid
        }
        
        return contactValidation
    }
}
