import Foundation

protocol ContactValidatorProtocol {
    func validate(toValidate contact: Contact) -> ContactValidation
}
