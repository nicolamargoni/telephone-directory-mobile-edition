import Foundation

class StubContactValidator : Validator {
    var valid : Bool = false
    func isValid(toValidate: Contact) -> Bool {
        return valid
    }
    
    func whenIsValidCalled(return result: Bool){
        valid = result
    }
}
