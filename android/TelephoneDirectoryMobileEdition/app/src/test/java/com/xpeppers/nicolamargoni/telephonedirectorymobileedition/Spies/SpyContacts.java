package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.Spies;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.Contacts;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;

import java.util.ArrayList;


public class SpyContacts implements Contacts {
    public boolean contactAdded = false;
    public boolean contactEdited = false;

    @Override
    public ArrayList<Contact> getAll() {
        return null;
    }

    @Override
    public ArrayList<Contact> getAll(String query) {
        return null;
    }

    @Override
    public void edit(Contact contact, int id) {
        contactEdited = true;
    }

    @Override
    public Contact get(int id) {
        return new Contact(new Contact("Mario", "Margoni", "+39 340 456789"), id);
    }

    @Override
    public void add(Contact contact) {
        contactAdded = true;
    }
}