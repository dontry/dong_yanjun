package com.monash.accounts.TermDepositAccount;

import com.monash.accounts.Transaction.Transaction;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface TermDepositAccountContract {
    interface UserActionListener {
        double withdrawMoneyFromTermDepsoit(long termDeposit);
        void createTermDeposit(double amount, TypeOfTermDeposit type, Date startingDate);
        void deleteTermDeposit(long termDeposit);
        double transferMoney(double amount, long toAccountId);
        TermDeposit checkTermDeposit(long termId);
        List<TermDeposit> getAllTermDeposit();
        List<Transaction> checkTransactions(Date startingDate, @Nullable Date endingDate);
        void openAccount(@NotNull long accountId);
        void showAccount();
        void saveAccount();
    }
}
