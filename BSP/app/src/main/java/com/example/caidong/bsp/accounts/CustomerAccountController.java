package com.example.caidong.bsp.accounts;


import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.caidong.bsp.accounts.CreditCardAccount.CrediCardAccount;
import com.example.caidong.bsp.accounts.HomeLoanAccount.HomeLoanAccount;
import com.example.caidong.bsp.accounts.SavingAccount.SavingAccount;
import com.example.caidong.bsp.accounts.TermDepositAccount.TermDepositAccount;
import com.example.caidong.bsp.users.Customer;

/**
 * Created by caidong on 9/05/2017.
 */
public class CustomerAccountController implements AccountContract.CustomerActionListener{

    private final CustomerRepository mCustomerRepository;
    private final AccountContract.CustomerHomeView mHomeView;

    public CustomerAccountController(CustomerRepository mCustomerRepository, AccountContract.CustomerHomeView mHomeView) {
        this.mCustomerRepository = mCustomerRepository;
        this.mHomeView = mHomeView;
    }


    @Override
    public void viewCustomerProfile(@NonNull Customer customer) {
        mHomeView.showCustomerProfile(customer);
    }

    @Override
    public Account selectAccount(String username, TypeOfAccount typeOfAccount) {
        return null;
    }

    @Override
    public void openSavingAccount(@NonNull SavingAccount account) {
        mHomeView.showSavingAccount(account.getmAccountId());
    }

    @Override
    public void openTermDepositAccount(@NonNull TermDepositAccount account) {
        mHomeView.showTermDepositAccount(account.getmAccountId());
    }

    @Override
    public void openCreditCardAccount(@NonNull CrediCardAccount account) {
        mHomeView.showSavingAccount(account.getmAccountId());
    }

    @Override
    public void openHomeLoanAccount(HomeLoanAccount account) {
        mHomeView.showHomeLoanAccount(account.getmAccountId());
    }

    @Override
    public void logout() {
        mHomeView.showLogout();
    }
}
