package com.company.account;

public enum AccountType {
    PRIVATE("Private"),
    COMPANY("Company");
    private final String type;

    AccountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}

