package com.monash.accounts;


/**
 * Created by caidong on 8/05/2017.
 */
public class CrediCardAccount extends Account {
    private double mBalance;
    private double mWithdrawDailyLimit;
    private double mLoanLimit;
    private double dailyWithdrawal;

    public CrediCardAccount(long accountId, com.monash.accounts.AccountType accountType, boolean locked, double withdrawDailyLimit, double loanLimit) {
        super(accountId, accountType, locked);
        mWithdrawDailyLimit = withdrawDailyLimit;
        mLoanLimit = loanLimit;
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
