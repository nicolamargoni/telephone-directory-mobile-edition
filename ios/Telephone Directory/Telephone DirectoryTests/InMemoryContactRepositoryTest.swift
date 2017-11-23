import XCTest

class InMemoryContactRepositoryTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testContactInsertionInMemory(){
        let contactRepository = InMemoryContactRepository()
        let contactToAdd = Contact(firstName: "Mario", lastName: "Rossi", telephoneNumber: "+39 340 1234567")
        
        contactRepository.add(toAdd: contactToAdd)
        
        XCTAssertTrue(contactRepository.contacts.contains(where: {contact in contact === contactToAdd}))
    }
    
}
