package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactItem;

import java.util.ArrayList;


public interface Contacts {

    ArrayList<ContactItem> getAll();

    ArrayList<ContactItem> getAll(String query);

    void edit(Contact contact, int id);

    Contact get(int id);

    void add(Contact contact);
}
