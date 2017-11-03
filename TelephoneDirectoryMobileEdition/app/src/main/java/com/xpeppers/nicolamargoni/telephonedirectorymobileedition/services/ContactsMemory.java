package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.services;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.Contacts;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactItem;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.utils.Utils;

import java.util.ArrayList;


public class ContactsMemory implements Contacts {
    private static ContactsMemory instance = null;
    private ArrayList<ContactItem> contacts;

    public static ContactsMemory getInstance() {
        if (Utils.isNull(instance)) {
            instance = new ContactsMemory();
        }
        return instance;
    }

    public ContactsMemory() {
        contacts = new ArrayList<>();
    }

    @Override
    public ArrayList<ContactItem> getAll() {
        return contacts;
    }

    @Override
    public ArrayList<ContactItem> getAll(String query) {
        ArrayList<ContactItem> contacts = new ArrayList<>();

        for (ContactItem contact : this.contacts) {
            if (isMatching(contact, query)) {
                contacts.add(contact);
            }
        }

        return contacts;
    }

    @Override
    public void edit(Contact contact, int id) {
        get(id).edit(contact);
    }

    @Override
    public ContactItem get(int id) {
        int i = 0;
        boolean found = false;
        ContactItem contact = null;

        while (i < contacts.size() && found == false) {
            if (contacts.get(i).id == id) {
                found = true;
                contact = contacts.get(i);
            }
            i++;
        }

        return contact;
    }

    @Override
    public void add(Contact contact) {
        contacts.add(new ContactItem(contact, generateID()));
    }

    private boolean isMatching(Contact contact, String query) {
        return contact.firstName.contains(query) || contact.lastName.contains(query) || contact.telephoneNumber.contains(query);
    }

    private int generateID() {
        return contacts.size();
    }
}
