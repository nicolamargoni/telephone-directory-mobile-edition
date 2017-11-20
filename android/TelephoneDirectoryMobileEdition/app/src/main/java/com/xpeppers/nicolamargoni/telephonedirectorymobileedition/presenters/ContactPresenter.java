package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.ContactView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactValidate;


public class ContactPresenter {
    private ContactView view;

    public void attach(ContactView view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

    public void publish(Contact contact) {
        view.setFirstNameText(contact.firstName);
        view.setLastNameText(contact.lastName);
        view.setTelephoneNumberText(contact.telephoneNumber);
    }

    public void publishErrors(ContactValidate contact) {
        if (contact.firstNameStatus.isValid()) {
            view.setFirtsNameValid();
        } else {
            view.setFirstNameErrorText(contact.firstNameStatus.getDescription());
        }

        if (contact.lastNameStatus.isValid()) {
            view.setLastNameValid();
        } else {
            view.setLastNameErrorText(contact.lastNameStatus.getDescription());
        }

        if (contact.telephoneNumberStatus.isValid()) {
            view.setTelephoneNumberValid();
        } else {
            view.setTelephoneNumberErrorText(contact.telephoneNumberStatus.getDescription());
        }
    }

}
