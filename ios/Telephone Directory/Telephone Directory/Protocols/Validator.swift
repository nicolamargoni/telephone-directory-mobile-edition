import Foundation

protocol Validator {
    func isValid(toValidate: Contact) -> Bool
}
