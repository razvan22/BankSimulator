package com.company.users;

public enum UserType {
    CLIENT("Client"),
    TELLER("TELLER");
    private final String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
