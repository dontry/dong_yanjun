package com.example.caidong.bsp.accounts;


import com.example.caidong.bsp.HomeLoanApplication;
import com.example.caidong.bsp.accounts.CreditCardAccount.CrediCardAccount;
import com.example.caidong.bsp.accounts.HomeLoanAccount.HomeLoanAccount;
import com.example.caidong.bsp.accounts.SavingAccount.SavingAccount;
import com.example.caidong.bsp.accounts.TermDepositAccount.TermDepositAccount;
import com.example.caidong.bsp.users.Customer;

import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 9/05/2017.
 */
public interface AccountContract {

    public interface CustomerHomeView {
        void setProgressIndicator(boolean active);

        void showSavingAccount(long accountId);
        void showTermDepositAccount(long accountId);
        void showCreditCardAccount(long accountId);
        void showHomeLoanAccount(long accountId);
        void showCustomerProfile(Customer profile);
        void showLogout();
    }

    public interface CustomerActionListener {
/*        double checkBalance(long accountId);
        List<Transaction> checkTransactions(long accountId, Date startingDate, @Nullable Date endingDate);
        List<TermDeposit>  selectAllTermDeposits(long accountId);
        TermDeposit checkTermDeposit(long termId);
        void createTermDeposit(double amount, TypeOfTermDeposit type, Date startingDate);*/
        void viewCustomerProfile(Customer customer);
        Account selectAccount(String username, TypeOfAccount typeOfAccount);
        void openSavingAccount(SavingAccount account);
        void openTermDepositAccount(TermDepositAccount account);
        void openCreditCardAccount(CrediCardAccount account);
        void openHomeLoanAccount(HomeLoanAccount account);
        void logout();

    }

    public interface  AdministratorListener {
        Customer getCustomer(String username);
        Account selectAccount(long accountId);
        void deleteAccount(long accountId);
        void unlockAccount(long accountId);
        void createLoan(HomeLoanApplication application);
        void showLoanApplication(HomeLoanApplication application);
        long getAccountId(String username, TypeOfAccount type);
        void changeCustomerPIN(String username, long newPIN);
    }
}
