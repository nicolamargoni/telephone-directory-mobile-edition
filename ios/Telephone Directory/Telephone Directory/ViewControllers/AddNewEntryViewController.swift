import UIKit

class AddNewEntryViewController: UITableViewController, AddNewEntryView {
    
    @IBOutlet weak var firstNameTextField: UITextField!
    @IBOutlet weak var firstNameErrorLabel: UILabel!
    @IBOutlet weak var lastNameTextField: UITextField!
    @IBOutlet weak var telephoneNumberTextField: UITextField!
    
    var presenter : AddNewEntryPresenter! = nil
    var contactRepository : ContactRepository! = nil
    var contactValidator : ContactValidatorProtocol! = nil
    
    var addNewEntryDelegate : AddNewEntryDelegate!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        contactValidator = ContactValidator()
        presenter = AddNewEntryPresenter(contactRepository: contactRepository, contactValidator: contactValidator, view: self)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        firstNameTextField.becomeFirstResponder()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    @IBAction func onTouchCancel(_ sender: UIBarButtonItem) {
        navigationController?.popViewController(animated: true)
    }
    
    @IBAction func onTouchDone(_ sender: UIBarButtonItem) {
        let contactToAdd = Contact(firstName: firstNameTextField.text!, lastName: lastNameTextField.text!, telephoneNumber: telephoneNumberTextField.text!)
        presenter.addContact(contact: contactToAdd)
    }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func onContactAdded(added contact: Contact) {
        navigationController?.popViewController(animated: true)
        addNewEntryDelegate.addNewEntryDidFinish(added: contact)
    }
    
    func setFirstNameError(error: String) {
        tableView.reloadData()
        firstNameErrorLabel.text = error
        firstNameErrorLabel.isHidden = false
    }
    
    
    
}
