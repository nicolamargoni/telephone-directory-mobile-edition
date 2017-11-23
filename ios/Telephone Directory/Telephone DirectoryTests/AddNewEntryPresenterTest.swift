import XCTest

class AddNewEntryPresenterTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testInsertValidContact(){
        let spyContactRepository = SpyContactRepository()
        let stubContactValidator = StubContactValidator()
        let spyView = SpyAddNewEntryView()
        let presenter = AddNewEntryPresenter(contactRepository: spyContactRepository, validator: stubContactValidator, view: spyView)
        let contact = Contact(firstName: "Mario",lastName: "Rossi",telephoneNumber: "+39 340 1234567")
        stubContactValidator.whenIsValidCalled(return: true)
        
        presenter.addContact(contact: contact)
        
        XCTAssertTrue(spyContactRepository.addGotCalled && spyView.onContactAddedGotCalled)
    }
}
