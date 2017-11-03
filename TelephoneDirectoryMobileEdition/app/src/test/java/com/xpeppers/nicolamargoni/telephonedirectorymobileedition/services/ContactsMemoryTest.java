package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.services;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by nicolamargoni on 02/11/17.
 */
public class ContactsMemoryTest {
    private ContactsMemory contacts;

    @Before
    public void setUp() throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException {

        contacts = new ContactsMemory();
    }

    @Test
    public void emptyList() {
        assertEquals(0, contacts.getAll().size());
    }


    @Test
    public void addContact() {
        contacts.add(contact);

        assertEquals(1, contacts.getAll().size());
        assertEquals(contact.firstName, contacts.getAll().get(0).firstName);
        assertEquals(contact.lastName, contacts.getAll().get(0).lastName);
        assertEquals(contact.telephoneNumber, contacts.getAll().get(0).telephoneNumber);
    }

    @Test
    public void editContact() {
        Contact contact = new Contact("Nico", "Marg",
                "+39 345 785421");

        contacts.add(contact);
        int idContact = contacts.get(0).id;
        contact.firstName = "Nicola";
        contact.lastName = "Margoni";
        contacts.edit(contact, idContact);

        assertEquals(contact.firstName, contacts.getAll().get(0).firstName);
        assertEquals(contact.lastName, contacts.getAll().get(0).lastName);
        assertEquals(contact.telephoneNumber, contacts.getAll().get(0).telephoneNumber);
    }

    @Test
    public void searchContactsWithNoOneMatching() {
        contacts.add(contact);
        String query = "ota";

        assertEquals(0, contacts.getAll(query).size());
    }

    @Test
    public void searchContactsWithOneMatchingInFirstName() {
        contacts.add(contact);
        String query = "ola";

        assertEquals(1, contacts.getAll(query).size());
    }

    @Test
    public void searchContactsWithOneMatchingInLastName() {
        contacts.add(contact);
        String query = "oni";

        assertEquals(1, contacts.getAll(query).size());
    }

    @Test
    public void searchContactsWithOneMatchingInTelephoneNumber() {
        contacts.add(contact);
        String query = "34";

        assertEquals(1, contacts.getAll(query).size());
    }


    Contact contact = new Contact("Nicola", "Margoni",
            "+39 345 754331");


}