import Foundation

struct ContactValidation{
    var firstNameValidation: FirstNameValidation = .notValidate
    var isValid: Bool{
        get {
            return firstNameValidation == .isValid
        }
    }
}
