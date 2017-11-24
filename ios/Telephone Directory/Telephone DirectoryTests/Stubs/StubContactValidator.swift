import Foundation

class StubContactValidator : ContactValidatorProtocol {
    var firstNameValid : Bool = false
    
    func validate(toValidate contact: Contact) -> ContactValidation {
        var validation = ContactValidation()
        
        if(firstNameValid){
            validation.firstNameValidation = .isValid
        } else {
            validation.firstNameValidation = .notValidIsEmpty
        }
        
        return validation
    }
    
    func whenValidateCalled(returnFirtsNameValid firstNameValid: Bool){
        self.firstNameValid = firstNameValid
    }
}
