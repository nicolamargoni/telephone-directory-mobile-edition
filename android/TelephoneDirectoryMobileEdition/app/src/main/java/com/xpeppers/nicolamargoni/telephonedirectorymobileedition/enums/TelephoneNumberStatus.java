package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums;


public enum TelephoneNumberStatus {
    IS_VALID(0, "The telephone number is valid"),
    IS_NOT_VALID(1, "The telephone number is not valid");

    private int code;
    private String description;

    TelephoneNumberStatus(int code, String description) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isValid() {
        return code == 0;
    }

}