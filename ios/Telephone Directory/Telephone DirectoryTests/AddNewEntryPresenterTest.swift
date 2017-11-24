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
        let presenter = AddNewEntryPresenter(contactRepository: spyContactRepository, contactValidator: stubContactValidator, view: spyView)
        let dummyContact = Contact(firstName: "Mario",lastName: "Rossi",telephoneNumber: "+39 340 1234567")
        stubContactValidator.whenValidateCalled(returnFirtsNameValid: true)
        
        presenter.addContact(contact: dummyContact)
        
        XCTAssertTrue(spyContactRepository.addGotCalled
            && spyView.onContactAddedGotCalled)
    }
    
    func testInsertNotValidContactWithFirstNameEmpty(){
        let spyContactRepository = SpyContactRepository()
        let stubContactValidator = StubContactValidator()
        let spyView = SpyAddNewEntryView()
        let presenter = AddNewEntryPresenter(contactRepository: spyContactRepository, contactValidator: stubContactValidator, view: spyView)
        let dummyContact = Contact(firstName: "",lastName: "Rossi",telephoneNumber: "+39 340 1234567")
        stubContactValidator.whenValidateCalled(returnFirtsNameValid: false)
        
        presenter.addContact(contact: dummyContact)
        
        XCTAssertTrue(!spyContactRepository.addGotCalled
            && !spyView.onContactAddedGotCalled
            && spyView.setFirstNameErrorGotCalled)
    }
}
