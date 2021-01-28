package com.melon.dataGenerator.actions;

import com.melon.dataGenerator.models.Account;
import com.melon.dataGenerator.models.Transaction;

import java.util.List;

public class AddAccountAndTransactions {

    public void addAccounts(List<Account> accounts, Account account) {
        accounts.add(account);
    }

    public void addTransactions(List<Transaction> transactions, Transaction transaction) {
        transactions.add(transaction);
    }


}
