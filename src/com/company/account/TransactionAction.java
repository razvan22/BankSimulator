package com.company.account;

public enum TransactionAction {
    SENT("sent"),
    RECEIVED("received");
    private final String action;

    TransactionAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
