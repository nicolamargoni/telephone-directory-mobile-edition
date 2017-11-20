package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.Contacts;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.EditEntryView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactValidate;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.services.ContactValidator;

public class EditEntryPresenter {
    private EditEntryView view;
    private Contacts contacts;
    private ContactPresenter contactPresenter;

    private int idContact;


    public EditEntryPresenter(Contacts contacts, int idContact, ContactPresenter contactPresenter) {
        this.contacts = contacts;
        this.idContact = idContact;
        this.contactPresenter = contactPresenter;
    }

    public void attach(EditEntryView view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

    public void editEntry(Contact contact) {
        ContactValidate contactValidate = ContactValidator.validate(contact);

        if (ContactValidator.isValid(contactValidate)) {
            contacts.edit(contactValidate, idContact);
            view.onContactEdited();
        } else {
            contactPresenter.publishErrors(contactValidate);
        }
    }

    public void publish() {
        contactPresenter.publish(getContact(idContact));
    }

    public Contact getContact(int idContact) {
        return contacts.get(idContact);
    }

}
