package com.melon.dataGenerator.models;

public class Transaction {
    private String type;
    private int value;
    private static int transactionId = 0;

    public Transaction(String type, int value) {
        this.type = type;
        this.value = value;
        this.transactionId++;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getTransactionId() {
        return transactionId;
    }


}
