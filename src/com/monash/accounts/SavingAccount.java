package com.monash.accounts;

/**
 * Created by caidong on 8/05/2017.
 */
public class SavingAccount extends Account {
    private double mBalance;
    public SavingAccount(long accountId, double balance, AccountType accountType, boolean locked) {
        super(accountId, accountType, locked);
        mBalance = balance;
    }

    /**
     *
     * @return mBalance
     */
    public double getmBalance() {
        return mBalance;
    }

    public void setmBalance(double mBalance) {
        this.mBalance = mBalance;
    }

    public void addMoney(double amount) {
       mBalance += amount;
    }

    public void deductMoney(double amount) {
        mBalance -= amount;
    }
}
