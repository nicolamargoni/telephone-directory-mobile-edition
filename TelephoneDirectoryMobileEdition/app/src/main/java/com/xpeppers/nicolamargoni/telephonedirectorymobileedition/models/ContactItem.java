package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models;


public class ContactItem extends Contact {
    public int id;

    public ContactItem(Contact contact, int id) {
        super(contact.firstName, contact.lastName, contact.telephoneNumber);
        this.id = id;
    }
}
