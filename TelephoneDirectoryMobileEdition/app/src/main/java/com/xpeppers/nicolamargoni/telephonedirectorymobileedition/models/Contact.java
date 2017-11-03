package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models;


public class Contact {
    public String firstName;
    public String lastName;
    public String telephoneNumber;

    public Contact(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
    }

    public void edit(Contact contact) {
        this.firstName = contact.firstName;
        this.lastName = contact.lastName;
        this.telephoneNumber = contact.telephoneNumber;
    }
}
