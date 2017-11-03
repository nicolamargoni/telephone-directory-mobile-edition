package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.Contacts;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.AddNewEntryView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactValidate;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.services.ContactValidator;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.utils.Utils;

public class AddNewEntryPresenter {
    private AddNewEntryView view;
    private Contacts contacts;
    private ContactPresenter contactPresenter;

    public AddNewEntryPresenter(Contacts contacts, ContactPresenter contactPresenter) {
        this.contacts = contacts;
        this.contactPresenter = contactPresenter;
    }

    public void attach(AddNewEntryView view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

    public void addNewEntry(Contact contact) {
        ContactValidate contactValidate = ContactValidator.validate(contact);

        if (ContactValidator.isValid(contactValidate)) {
            contacts.add(contactValidate);
            view.onContactAdded();
        } else {
            contactPresenter.publishErrors(contactValidate);
        }
    }

    public boolean isViewAttached() {
        return !Utils.isNull(view);
    }
}
