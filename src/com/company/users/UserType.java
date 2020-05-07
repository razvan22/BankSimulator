package com.company.users;

public enum UserType {
    CLIENT("Client"),
    BANK_EMPLOYEE("Bank Employee");
    private final String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}