package com.example.caidong.bsp.accounts.TermDepositAccount;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.caidong.bsp.accounts.Transaction.Transaction;

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
        void openAccount(@NonNull long accountId);
        void showAccount();
        void saveAccount();
    }
}
