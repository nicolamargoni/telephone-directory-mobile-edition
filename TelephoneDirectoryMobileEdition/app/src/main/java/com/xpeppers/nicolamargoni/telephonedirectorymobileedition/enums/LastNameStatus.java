package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.enums;


public enum LastNameStatus {
    IS_VALID(0, "The last name is valid"),
    IS_EMPTY(1, "The last name is empty");

    private int code;
    private String description;

    LastNameStatus(int code, String description) {
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