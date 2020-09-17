package com.melon.dataGenerator.actions;

import com.melon.dataGenerator.models.Transaction;

import java.util.List;

public class PrintTransactions {

    public String printTransactionsValue(List<Transaction> transactions, int index) {

        return String.valueOf(transactions.get(index).getValue());
    }

}
