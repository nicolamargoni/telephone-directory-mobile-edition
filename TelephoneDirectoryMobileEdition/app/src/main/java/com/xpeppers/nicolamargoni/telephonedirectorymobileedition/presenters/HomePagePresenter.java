package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.Contacts;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.HomePageView;


public class HomePagePresenter {
    private HomePageView view;
    private Contacts contacts;

    public HomePagePresenter(Contacts contacts) {
        this.contacts = contacts;
    }

    public void attach(HomePageView view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public void search(String query) {
        view.onUpdateContacts(contacts.getAll(query));
    }

    public void update() {
        view.onUpdateContacts(contacts.getAll());
    }


}
