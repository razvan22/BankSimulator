package com.company.users;

public enum UserType {
    CLIENT("Client"),
    EMPLOYEE("Employee"),
    ADMIN("Admin");
    private final String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}