import XCTest

class ContactValidatorTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }

    func testValidationAValidContact(){
        let contactValidator = ContactValidator()
        let contactValidToValidate = Contact(firstName: "Mario", lastName: "Rossi", telephoneNumber: "+39 340 6710147")
        let contactValidation = contactValidator.validate(toValidate: contactValidToValidate)
        
        XCTAssertTrue(contactValidation.isValid)
    }
    
    func testValidationNotValidContactWithEmptyFirstName(){
        let contactValidator = ContactValidator()
        let contactValidToValidate = Contact(firstName: "", lastName: "Rossi", telephoneNumber: "+39 340 6710147")
        let contactValidation = contactValidator.validate(toValidate: contactValidToValidate)
        
        XCTAssertTrue(!contactValidation.isValid && contactValidation.firstNameValidation == .notValidIsEmpty)
    }
    
}
