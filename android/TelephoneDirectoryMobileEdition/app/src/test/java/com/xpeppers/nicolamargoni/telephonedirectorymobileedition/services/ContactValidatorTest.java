package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.services;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.FirstNameStatus;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.LastNameStatus;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums.TelephoneNumberStatus;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by nicolamargoni on 30/10/17.
 */
public class ContactValidatorTest {

    @Test
    public void validateName() {
        ContactValidator contactValidator = new ContactValidator();
        assertEquals(contactValidator.validateFirstName(stringEmpty), FirstNameStatus.IS_EMPTY);
        assertEquals(contactValidator.validateFirstName(stringNotEmpty), FirstNameStatus.IS_VALID);
    }

    @Test
    public void validateSurname() {
        ContactValidator contactValidator = new ContactValidator();
        assertEquals(contactValidator.validateLastName(stringEmpty), LastNameStatus.IS_EMPTY);
        assertEquals(contactValidator.validateLastName(stringNotEmpty), LastNameStatus.IS_VALID);
    }

    @Test
    public void validateTelephoneNumbers() {
        ContactValidator contactValidator = new ContactValidator();

        for (TelephoneNumber telephoneNumber : telephoneNumbers) {
            assertEquals(contactValidator.validateTelephoneNumber(telephoneNumber.number),
                    telephoneNumber.status);
        }
    }

    private String stringNotEmpty = "notEmpty";
    private String stringEmpty = "";

    private TelephoneNumber[] telephoneNumbers = {
            new TelephoneNumber("+3990 02212 1234567213", TelephoneNumberStatus.IS_VALID),
            new TelephoneNumber("+39 02 1234567", TelephoneNumberStatus.IS_VALID),
            new TelephoneNumber("+1 1 123456", TelephoneNumberStatus.IS_VALID),
            new TelephoneNumber("+1 1 12345", TelephoneNumberStatus.IS_NOT_VALID),
            new TelephoneNumber("+ 1 123456", TelephoneNumberStatus.IS_NOT_VALID),
            new TelephoneNumber("+453 32", TelephoneNumberStatus.IS_NOT_VALID),
            new TelephoneNumber("39 02 1234567", TelephoneNumberStatus.IS_NOT_VALID),
            new TelephoneNumber("+21", TelephoneNumberStatus.IS_NOT_VALID)
    };

    private class TelephoneNumber {
        String number;
        TelephoneNumberStatus status;

        public TelephoneNumber(String telephoneNumber, TelephoneNumberStatus status) {
            this.number = telephoneNumber;
            this.status = status;
        }
    }

}