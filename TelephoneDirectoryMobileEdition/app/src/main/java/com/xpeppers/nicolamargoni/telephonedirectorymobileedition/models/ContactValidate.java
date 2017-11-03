package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.FirstNameStatus;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.LastNameStatus;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.TelephoneNumberStatus;


public class ContactValidate extends Contact {

    public FirstNameStatus firstNameStatus;
    public LastNameStatus lastNameStatus;
    public TelephoneNumberStatus telephoneNumberStatus;

    public ContactValidate(Contact contact, FirstNameStatus firstNameStatus,
                           LastNameStatus lastNameStatus,
                           TelephoneNumberStatus telephoneNumberStatus) {

        super(contact.firstName, contact.lastName, contact.telephoneNumber);

        this.firstNameStatus = firstNameStatus;
        this.lastNameStatus = lastNameStatus;
        this.telephoneNumberStatus = telephoneNumberStatus;
    }
}
