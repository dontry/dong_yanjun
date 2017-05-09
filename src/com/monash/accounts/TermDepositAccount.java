package com.monash.accounts;

import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by caidong on 8/05/2017.
 */
public class TermDepositAccount {
    private Date startingDate;
    private TypeOfTermDeposit typeOfTermDeposit;
    private Date nextAddInterestDate;
    private double interestRate;
    private HashMap<Long, com.monash.accounts.TermDeposit> mTermDeposits;


    public TermDepositAccount(Date startingDate, TypeOfTermDeposit typeOfTermDeposit, double interestRate) {
        this.startingDate = startingDate;
        this.typeOfTermDeposit = typeOfTermDeposit;
        this.interestRate = interestRate;
        mTermDeposits = new HashMap<>();
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public com.monash.accounts.TypeOfTermDeposit getTypeOfTermDeposit() {
        return typeOfTermDeposit;
    }

    public com.monash.accounts.TermDeposit selectTermDeposit(long id) {
        return mTermDeposits.get(id);
    }

    public void createTermDeposit(long id, double balance, TypeOfTermDeposit type, @Nullable Date startingDate) {
        if(startingDate == null) startingDate = new Date();
       TermDeposit termDeposit = new TermDeposit(id, balance, type, startingDate);
        mTermDeposits.put(id, termDeposit);
    }

    public void deleteTermDeposit(long id) {
        mTermDeposits.remove(id);
    }

}
