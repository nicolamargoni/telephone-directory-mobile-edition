import XCTest

class Telephone_DirectoryUITests: XCTestCase {
    var app: XCUIApplication!
    
    override func setUp() {
        super.setUp()
        app = XCUIApplication()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testValidEntryInsertion() {
        app.launch()
        app.navigationBars.buttons["Add"].tap()
        app.tables.cells.textFields["firstName"].typeText("Mario")
        app.tables.cells.textFields["lastName"].tap()
        app.tables.cells.textFields["lastName"].typeText("Rossi")
        app.tables.cells.textFields["telephoneNumber"].tap()
        app.tables.cells.textFields["telephoneNumber"].typeText("+39 340 1234567")
        app.navigationBars.buttons["Done"].tap()
        let cell = app.tables.cells.containing(.staticText, identifier: "Mario Rossi").element
        XCTAssertTrue(cell.exists)
    }
    
    func testEntryWithNotValidFirstNameWillShowAnError(){
        app.launch()
        app.navigationBars.buttons["Add"].tap()
        app.tables.cells.textFields["firstName"].typeText("")
        app.tables.cells.textFields["lastName"].tap()
        app.tables.cells.textFields["lastName"].typeText("Rossi")
        app.tables.cells.textFields["telephoneNumber"].tap()
        app.tables.cells.textFields["telephoneNumber"].typeText("+39 340 1234567")
        app.navigationBars.buttons["Done"].tap()
        let error = app.tables.cells.staticTexts["first name can't be empty"]
        XCTAssertTrue(error.exists)
    }
}
