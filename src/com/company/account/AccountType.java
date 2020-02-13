package com.company.account;

public enum AccountType {
    PRIVATE("Private account"),
    COMPANY("Company account");
    private final String type;

    AccountType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}

