package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces;


public interface ContactView {
    void setFirstNameErrorText(String description);
    void setFirtsNameValid();
    void setFirstNameText(String text);

    void setLastNameErrorText(String description);
    void setLastNameValid();
    void setLastNameText(String text);

    void setTelephoneNumberErrorText(String description);
    void setTelephoneNumberValid();
    void setTelephoneNumberText(String text);
}
