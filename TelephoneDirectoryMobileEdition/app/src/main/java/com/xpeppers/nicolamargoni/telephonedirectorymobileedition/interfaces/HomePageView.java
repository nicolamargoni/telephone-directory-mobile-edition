package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactItem;
import java.util.ArrayList;


public interface HomePageView {
    void onUpdateContacts(ArrayList<ContactItem> contacts);
}
