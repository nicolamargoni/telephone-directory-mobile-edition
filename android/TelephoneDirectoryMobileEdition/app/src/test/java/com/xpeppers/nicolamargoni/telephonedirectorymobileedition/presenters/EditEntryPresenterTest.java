package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.Spies.SpyContacts;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.AddNewEntryView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.ContactView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.EditEntryView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class EditEntryPresenterTest {
    private ContactPresenter contactPresenter;
    private EditEntryPresenter presenter;
    private SpyEditNewEntryView view;
    private SpyContacts contacts;
    private int idContact = 0;

    @Before
    public void setUp() throws Exception {
        contacts = new SpyContacts();
        view = new SpyEditNewEntryView();
        contactPresenter = new ContactPresenter();
        contactPresenter.attach(view);
        presenter = new EditEntryPresenter(contacts, idContact, contactPresenter);
        presenter.attach(view);
    }

    @Test
    public void editAValidEntry() throws Exception {
        Contact contact = new Contact("Nicola", "Margoni", "+39 340 345678");
        presenter.editEntry(contact);

        assertTrue(contacts.contactEdited);
        assertTrue(view.onContactEditedCalled);
    }

    @Test
    public void editNotValidEntry() throws Exception {
        Contact contact = new Contact("", "", "39 340 345678");
        presenter.editEntry(contact);

        assertTrue(view.firstNameErrorShown);
        assertTrue(view.lastNameErrorShown);
        assertTrue(view.telephoneNumberErrorShown);
    }

    @Test
    public void editAnEntryWithFirstNameEmpty() throws Exception {
        Contact contact = new Contact("", "Margoni", "+39 340 345678");
        presenter.editEntry(contact);

        assertTrue(view.firstNameErrorShown);
        assertTrue(view.lastNameValidated);
        assertTrue(view.telephoneNumberValidated);
    }

    @Test
    public void editAnEntryWithLastNameEmpty() throws Exception {
        Contact contact = new Contact("Nicola", "", "+39 340 345678");
        presenter.editEntry(contact);

        assertTrue(view.lastNameErrorShown);
        assertTrue(view.firstNameValidated);
        assertTrue(view.telephoneNumberValidated);
    }

    @Test
    public void editAnEntryWithNotValidTelephoneNumber() throws Exception {
        Contact contact = new Contact("Nicola", "Margoni", "+39 340 34568");
        presenter.editEntry(contact);

        assertTrue(view.telephoneNumberErrorShown);
        assertTrue(view.firstNameValidated);
        assertTrue(view.lastNameValidated);
    }

    @Test
    public void publishContact() {
        presenter.publish();

        assertTrue(view.contactPublished());
    }

    private class SpyEditNewEntryView implements EditEntryView, ContactView {
        public boolean firstNameErrorShown = false;
        public boolean lastNameErrorShown = false;
        public boolean telephoneNumberErrorShown = false;

        public boolean firstNameValidated = false;
        public boolean lastNameValidated = false;
        public boolean telephoneNumberValidated = false;

        public boolean firstNamePublished = false;
        public boolean lastNamePublished = false;
        public boolean telephoneNumberPublished = false;


        public boolean onContactEditedCalled = false;

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
            lastNamePublished = true;
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
            firstNamePublished = true;
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
            telephoneNumberPublished = true;
        }

        @Override
        public void onContactEdited() {
            onContactEditedCalled = true;
        }

        public boolean contactPublished() {
            return firstNamePublished && lastNamePublished && telephoneNumberPublished;
        }
    }

}