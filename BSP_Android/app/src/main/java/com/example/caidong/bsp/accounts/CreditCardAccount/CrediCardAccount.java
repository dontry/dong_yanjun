package com.example.caidong.bsp.accounts.CreditCardAccount;


import com.example.caidong.bsp.accounts.Account;
import com.example.caidong.bsp.accounts.TypeOfAccount;

/**
 * Created by caidong on 8/05/2017.
 */
public class CrediCardAccount extends Account {
    private double mBalance;
    private double mWithdrawDailyLimit;
    private double mLoanLimit;
    private double dailyWithdrawal;

    public CrediCardAccount(long accountId, TypeOfAccount typeOfAccount, boolean locked, double balance, double withdrawDailyLimit, double loanLimit) {
        super(accountId, typeOfAccount, locked);
        mBalance = balance;
        mWithdrawDailyLimit = withdrawDailyLimit;
        mLoanLimit = loanLimit;
        dailyWithdrawal = 0;
    }

    public double getmBalance() {
        return mBalance;
    }

    public double getDailyWithdrawal() {
        return dailyWithdrawal;
    }

    public double getmWithdrawDailyLimit() {
        return mWithdrawDailyLimit;
    }

    public double getmLoanLimit() {
        return mLoanLimit;
    }

    public void setWithdrawDailyLimit(double withdrawDailyLimit) {
        mWithdrawDailyLimit = withdrawDailyLimit;
    }

    public void setLoanLimit(double loanLimit) {
        mLoanLimit = loanLimit;
    }

    public void addMoney(double amount) {
        mBalance += amount;
    }

    public void deductMoney(double amount) {
        mBalance -= amount;
    }
}
