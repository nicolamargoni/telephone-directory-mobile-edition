package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums;


public enum FirstNameStatus {
    IS_VALID(0, "The first name is valid"),
    IS_EMPTY(1, "The first name is empty");

    private int code;
    private String description;

    FirstNameStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isValid() {
        return code == 0;
    }
}