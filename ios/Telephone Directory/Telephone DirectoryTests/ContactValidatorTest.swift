import XCTest

class ContactValidatorTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }

    func testValidationAValidContact(){
        let validator = ContactValidator()
        let contactValidToValidate = Contact(firstName: "Mario", lastName: "Rossi", telephoneNumber: "+39 340 6710147")
        
        XCTAssertTrue(validator.isValid(toValidate: contactValidToValidate))
    }
    
}
