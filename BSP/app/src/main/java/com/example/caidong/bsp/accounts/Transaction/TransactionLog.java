package com.example.caidong.bsp.accounts.Transaction;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by caidong on 9/05/2017.
 */
public class TransactionLog {
    private ArrayList<Transaction> mTransactions;

    public TransactionLog() {
       mTransactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getmTransactions(Date startingDate, Date endingDate) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction: mTransactions) {
            Date transDate = transaction.getmTransDate();
            if (transDate.compareTo(startingDate) > 0  && transDate.compareTo(endingDate) < 0) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public ArrayList<Transaction> getAllTransactions() {
        return mTransactions;
    }

    public void createTransaction(long num, TypeOfTransaction type, Date date, double amount, long from, long to) {
        Transaction transaction = new Transaction(num, type, date, amount, from, to);
    }
}
