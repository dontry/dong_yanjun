package com.monash.accounts.SavingAccount;

import com.monash.accounts.TermDepositAccount.TermDepositAccount;
import com.monash.accounts.Transaction.Transaction;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface SavingAccountContract {
    interface UserActionListener {
        void deposit(double amount);
        double withdraw(double amount);
        void transfer(double amount, long toAccountId);
        List<Transaction> checkTransactions(Date startingDate, @Nullable Date endingDate);
        void openAccount(@NotNull long accountId);
        void showAccount();
        void saveAccount();
    }
}
