package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;

import java.util.ArrayList;


public interface Contacts {

    ArrayList<Contact> getAll();

    ArrayList<Contact> getAll(String query);

    void edit(Contact contact, int id);

    Contact get(int id);

    void add(Contact contact);
}
