package com.monash.accounts.SavingAccount;

import com.monash.accounts.Account;
import com.monash.accounts.TypeOfAccount;

/**
 * Created by caidong on 8/05/2017.
 */
public class SavingAccount extends Account {
    private double mBalance;
    public SavingAccount(long accountId, double balance, TypeOfAccount typeOfAccount, boolean locked) {
        super(accountId, typeOfAccount, locked);
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
