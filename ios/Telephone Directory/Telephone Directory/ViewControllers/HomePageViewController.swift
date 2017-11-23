import UIKit

class HomePageViewController: UITableViewController, HomePageView, AddNewEntryDelegate {
   
    var contactRepository : InMemoryContactRepository!
    var presenter : HomePagePresenter!
    var contacts : [Contact] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        contactRepository = InMemoryContactRepository()
        presenter = HomePagePresenter(contactRepository: contactRepository, view: self)
        presenter.updateContacts()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return contacts.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ContactItem", for: indexPath)
        
        let fullNameLabel = cell.viewWithTag(1000) as! UILabel
        let telephoneNumber = cell.viewWithTag(1001) as! UILabel
        
        fullNameLabel.text = contacts[indexPath.row].fullName
        telephoneNumber.text = contacts[indexPath.row].telephoneNumber
 
        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
    }
    
    func updateContacts(contacts: [Contact]) {
        self.contacts = contacts
    }
    
    func addNewEntryDidFinish(added contact: Contact) {
        presenter.updateContacts()
        
        let newRowIndex = contacts.count-1
        let indexPath = IndexPath(row: newRowIndex, section:0)
        let indexPaths = [indexPath]
        
        tableView.insertRows(at: indexPaths, with: .automatic)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        switch segue.identifier {
        case "addNewEntry"?:
            let controller = segue.destination as! AddNewEntryViewController
            controller.contactRepository = self.contactRepository
            controller.addNewEntryDelegate = self
            break
        default:
            break
        }
    }

}
