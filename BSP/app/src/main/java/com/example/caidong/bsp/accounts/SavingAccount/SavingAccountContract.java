package com.example.caidong.bsp.accounts.SavingAccount;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.caidong.bsp.accounts.Transaction.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface SavingAccountContract {
    interface View {
    }
    interface UserActionListener {
        void deposit(double amount);
        double withdraw(double amount);
        void transfer(double amount, long toAccountId);
        List<Transaction> checkTransactions(Date startingDate, @Nullable Date endingDate);
        void openAccount(@NonNull long accountId);
        void showAccount();
        void saveAccount();
    }
}
