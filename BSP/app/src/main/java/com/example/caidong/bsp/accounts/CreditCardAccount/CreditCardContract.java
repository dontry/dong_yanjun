package com.example.caidong.bsp.accounts.CreditCardAccount;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import com.example.caidong.bsp.accounts.Transaction.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface CreditCardContract {
    interface UserActionListener {
        void depositMoney(@NonNull double amount);
        double withdrawMoney(@NonNull double amount);
        void transferMoney(@NonNull double amount, @NonNull long toAccountId);
        List<Transaction> checkTransactions(Date startingDate, @Nullable Date endingDate);
        void openAccount(@NonNull long accountId);
        void showAccount();
        void saveAccount();
    }
}
