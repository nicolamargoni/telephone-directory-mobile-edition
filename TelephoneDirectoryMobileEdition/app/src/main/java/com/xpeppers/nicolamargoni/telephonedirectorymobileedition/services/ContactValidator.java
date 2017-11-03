package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.services;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.FirstNameStatus;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.LastNameStatus;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.TelephoneNumberStatus;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactValidate;

import java.util.regex.Pattern;


public class ContactValidator {
    private static final String REG_EX_TELEPHONE_NUMBER = "\\+\\d+\\s\\d+\\s\\d{6,}";

    public static ContactValidate validate(Contact contact) {
        return new ContactValidate(contact, validateFirstName(contact.firstName),
                validateLastName(contact.lastName),
                validateTelephoneNumber(contact.telephoneNumber));
    }

    public static boolean isValid(ContactValidate contactValidate) {
        return contactValidate.firstNameStatus.isValid() &&
                contactValidate.lastNameStatus.isValid() &&
                contactValidate.telephoneNumberStatus.isValid();
    }

    public static FirstNameStatus validateFirstName(String firstName) {
        if (isStringEmpty(firstName)) {
            return FirstNameStatus.IS_EMPTY;
        }
        return FirstNameStatus.IS_VALID;
    }

    public static LastNameStatus validateLastName(String lastName) {
        if (isStringEmpty(lastName)) {
            return LastNameStatus.IS_EMPTY;
        }
        return LastNameStatus.IS_VALID;
    }

    public static TelephoneNumberStatus validateTelephoneNumber(String telephoneNumber) {
        if (Pattern.matches(REG_EX_TELEPHONE_NUMBER, telephoneNumber)) {
            return TelephoneNumberStatus.IS_VALID;
        } else {
            return TelephoneNumberStatus.IS_NOT_VALID;
        }
    }

    public static boolean isStringEmpty(String string) {
        return string.isEmpty();
    }

}
