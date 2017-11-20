package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;

import java.util.ArrayList;


public interface HomePageView {
    void onUpdateContacts(ArrayList<Contact> contacts);
}
