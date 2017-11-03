package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.Spies.SpyContacts;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.HomePageView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactItem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by nicolamargoni on 02/11/17.
 */
public class HomePagePresenterTest {
    private SpyHomePageView view;
    private HomePagePresenter presenter;
    private SpyContacts contacts;

    @Before
    public void setUp() {
        contacts = new SpyContacts();
        view = new SpyHomePageView();
        presenter = new HomePagePresenter(contacts);
        presenter.attach(view);
    }

    @Test
    public void search() {
        presenter.search("query");

        assertTrue(view.onUpldateContactsCalled);
    }

    @Test
    public void update() {
        presenter.update();

        assertTrue(view.onUpldateContactsCalled);
    }


    private class SpyHomePageView implements HomePageView {
        public boolean onUpldateContactsCalled = false;

        @Override
        public void onUpdateContacts(ArrayList<ContactItem> contacts) {
            onUpldateContactsCalled = true;
        }
    }

}