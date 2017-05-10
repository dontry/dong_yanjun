package com.monash.accounts;

import com.monash.HomeLoanApplication;
import com.monash.accounts.Transaction.Transaction;
import com.monash.accounts.TermDepositAccount.TermDeposit;
import com.monash.accounts.TermDepositAccount.TypeOfTermDeposit;
import com.monash.users.Customer;
import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 9/05/2017.
 */
public interface AccountContract {
    public interface CustomerActionListener {
//        double checkBalance(long accountId);
//        List<Transaction> checkTransactions(long accountId, Date startingDate, @Nullable Date endingDate);
//        List<TermDeposit>  selectAllTermDeposits(long accountId);
//        TermDeposit checkTermDeposit(long termId);
//        void createTermDeposit(double amount, TypeOfTermDeposit type, Date startingDate);
        Account selectAccount(String username, TypeOfAccount typeOfAccount);
        long getAccountId(TypeOfAccount type);
    }

    public interface  AdministratorListener {
        Customer getCustomer(String username);
        Account selectAccount(long accountId);
        void deleteAccount(long accountId);
        void unlockAccount(long accountId);
        void createLoan(HomeLoanApplication application);
        void showLoanApplication(HomeLoanApplication application);
        long getAccountId(String usernam, TypeOfAccount type);
    }
}
