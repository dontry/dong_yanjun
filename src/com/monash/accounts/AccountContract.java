package com.monash.accounts;

import com.monash.HomeLoanApplication;
import com.monash.Transaction;
import com.monash.users.Customer;
import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 9/05/2017.
 */
public class AccountContract {
    public interface CustomerActionListener {
        double checkBalance(long accountId);
//        double checkBalance(String username, TypeOfAccount typeOfAccount);
        List<Transaction> checkTransactions(long accountId, Date startingDate, @Nullable Date endingDate);
        List<TermDeposit>  selectAllTermDeposits(long accountId);
//        List<TermDeposit> selectAllTermDeposits(String username);
        TermDeposit checkTermDeposit(long termId);
        void createTermDeposit(double amount, TypeOfTermDeposit type, Date startingDate);
//        Account selectAccount(long accountId);
        Account selectAccount(String username, TypeOfAccount typeOfAccount);
        long getAccountId(TypeOfAccount type);
        double withdraw(double amount, long accountId);
//        double withraw(double amount, TypeOfAccount type);
        double transfer(double amount, long fromAccountId, long toAccountId);
        void deposit(double amount, long accountId);
//        void deposit(double amount, TypeOfAccount type);
    }

    public interface  AdministratorListener {
        Account selectAccount(long accountId);
//        Account selectAccount(String username, TypeOfAccount typeOfAccount);
        void deleteAccount(long accountId);
//        void deleteAccount(String username, TypeOfAccount typeOfAccount);
        void unlockAccount(long accountId);
//        void unlockAccount(String username, TypeOfAccount typeOfAccount);
        void createLoan(HomeLoanApplication application);
        long getAccountId(TypeOfAccount type);
    }
}
