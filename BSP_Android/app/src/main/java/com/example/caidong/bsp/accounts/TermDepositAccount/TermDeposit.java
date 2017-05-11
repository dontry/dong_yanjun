package com.example.caidong.bsp.accounts.TermDepositAccount;


import android.support.annotation.Nullable;

import java.util.Date;

/**
 * Created by caidong on 8/05/2017.
 */
public class TermDeposit {
    private long mTermId;
    private double mBaseDeposit;
    private TypeOfTermDeposit mTypeOfTermDeposit;
    private Date mStartingDate;
    private double mOverallBalance;
    private double mInterestRate;

    public TermDeposit(long mTermId, double mBaseDeposit, TypeOfTermDeposit mTypeOfTermDeposit, double mInterestRate, @Nullable Date mStartingDate) {
        this.mTermId = mTermId;
        this.mBaseDeposit = mBaseDeposit;
        this.mTypeOfTermDeposit = mTypeOfTermDeposit;
        this.mStartingDate = (mStartingDate == null ? new Date() : mStartingDate);
        this.mInterestRate = mInterestRate;
        this.mOverallBalance = mBaseDeposit;
    }

    public double getmInterestRate() {return mInterestRate; };

    public Date getmStartingDate() {
        return mStartingDate;
    }

    public double getmOverallBalance() {
        return mOverallBalance;
    }

    public long getmTermId() {
        return mTermId;
    }

    public double getmBaseDeposit() {
        return mBaseDeposit;
    }

    public TypeOfTermDeposit getmTypeOfTermDeposit() {
        return mTypeOfTermDeposit;
    }

    public void addInterest() {
        //TODO add Interest
    }

    public void penaliseInterest() {
        //TODO penalise Interest
    }

    public double getOverallBalance() {
        //TODO calculate overall balance
        return 0;
    }
}
