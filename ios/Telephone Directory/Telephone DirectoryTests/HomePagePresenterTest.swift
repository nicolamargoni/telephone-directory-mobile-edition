import XCTest

class HomePagePresenterTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testDisplayAllContacts(){
        let spyView = SpyHomePageView()
        let stubContactRepository = StubContactRepository()
        let presenter = HomePagePresenter(contactRepository: stubContactRepository, view: spyView)
        
        presenter.updateContacts()
        
        XCTAssertTrue(spyView.updateContactsGotCalled)
    }
    
    
}
