package com.monash.accounts.CreditCardAccount;

import com.monash.accounts.SavingAccount.SavingAccount;
import com.monash.accounts.Transaction.Transaction;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface CreditCardContract {
    interface UserActionListener {
        void depositMoney(@NotNull double amount);
        double withdrawMoney(@NotNull double amount);
        void transferMoney(@NotNull double amount, @NotNull long toAccountId);
        List<Transaction> checkTransactions(Date startingDate, @Nullable Date endingDate);
        void openAccount(@NotNull long accountId);
        void showAccount();
        void saveAccount();
    }
}
