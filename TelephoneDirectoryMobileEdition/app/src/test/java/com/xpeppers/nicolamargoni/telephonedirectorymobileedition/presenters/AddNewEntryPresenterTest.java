package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.Spies.SpyContacts;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.ContactView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.AddNewEntryView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddNewEntryPresenterTest {
    private ContactPresenter contactPresenter;
    private AddNewEntryPresenter presenter;
    private SpyAddNewEntryView view;
    private SpyContacts contacts;

    @Before
    public void setUp() throws Exception {
        contacts = new SpyContacts();
        view = new SpyAddNewEntryView();
        contactPresenter = new ContactPresenter();
        contactPresenter.attach(view);
        presenter = new AddNewEntryPresenter(contacts, contactPresenter);
        presenter.attach(view);
    }

    @Test
    public void addAValidNewEntry() throws Exception {
        Contact contact = new Contact("Nicola", "Margoni", "+39 340 345678");
        presenter.addNewEntry(contact);

        assertTrue(contacts.contactAdded);
        assertTrue(view.onContactAddedCalled);
    }

    @Test
    public void addANotValidNewEntry() throws Exception {
        Contact contact = new Contact("", "", "39 340 345678");
        presenter.addNewEntry(contact);

        assertTrue(view.firstNameErrorShown);
        assertTrue(view.lastNameErrorShown);
        assertTrue(view.telephoneNumberErrorShown);
    }

    @Test
    public void addANewEntryWithFirstNameEmpty() throws Exception {
        Contact contact = new Contact("", "Margoni", "+39 340 345678");
        presenter.addNewEntry(contact);

        assertTrue(view.firstNameErrorShown);
        assertTrue(view.lastNameValidated);
        assertTrue(view.telephoneNumberValidated);
    }

    @Test
    public void addANewEntryWithLastNameEmpty() throws Exception {
        Contact contact = new Contact("Nicola", "", "+39 340 345678");
        presenter.addNewEntry(contact);

        assertTrue(view.lastNameErrorShown);
        assertTrue(view.firstNameValidated);
        assertTrue(view.telephoneNumberValidated);
    }

    @Test
    public void addANewEntryWithNotValidTelephoneNumber() throws Exception {
        Contact contact = new Contact("Nicola", "Margoni", "+39 340 34568");
        presenter.addNewEntry(contact);

        assertTrue(view.telephoneNumberErrorShown);
        assertTrue(view.firstNameValidated);
        assertTrue(view.lastNameValidated);
    }


    private class SpyAddNewEntryView implements AddNewEntryView, ContactView {
        public boolean firstNameErrorShown = false;
        public boolean lastNameErrorShown = false;
        public boolean telephoneNumberErrorShown = false;

        public boolean firstNameValidated = false;
        public boolean lastNameValidated = false;
        public boolean telephoneNumberValidated = false;

        public boolean onContactAddedCalled = false;

        @Override
        public void setLastNameErrorText(String description) {
            lastNameErrorShown = true;
        }

        @Override
        public void setLastNameValid() {
            lastNameValidated = true;
        }

        @Override
        public void setLastNameText(String text) {

        }

        @Override
        public void setFirstNameErrorText(String description) {
            firstNameErrorShown = true;
        }

        @Override
        public void setFirtsNameValid() {
            firstNameValidated = true;
        }

        @Override
        public void setFirstNameText(String text) {

        }

        @Override
        public void setTelephoneNumberErrorText(String description) {
            telephoneNumberErrorShown = true;
        }

        @Override
        public void setTelephoneNumberValid() {
            telephoneNumberValidated = true;
        }

        @Override
        public void setTelephoneNumberText(String text) {

        }

        @Override
        public void onContactAdded() {
            onContactAddedCalled = true;
        }
    }


}