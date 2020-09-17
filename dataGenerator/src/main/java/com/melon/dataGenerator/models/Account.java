package com.melon.dataGenerator.models;

import java.util.LinkedList;
import java.util.List;

public class Account {
    private Department department;
    private String name;
    private List<Transaction> transactions;
    private static int accountId = 0;

    public Account(Department department, String name) {
        this.department = department;
        this.name = name;
        this.transactions = new LinkedList<>();
        this.accountId++;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getAccountId() {
        return accountId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


}
