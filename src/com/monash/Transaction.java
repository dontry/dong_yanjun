package com.monash;

import com.sun.istack.internal.Nullable;

import java.util.Date;

/**
 * Created by caidong on 9/05/2017.
 */
public class Transaction {
    private long mTransNum;
    private long mFromAccountId;
    private long mToAccountId;
    private Date mTransDate;
    private double mAmount;
    private TransactionType mTransType;

    public Transaction(long mTransNum, TransactionType mTransType, Date mTransDate, double mAmount, @Nullable long mToAccountId, long mFromAccountId) {
        this.mTransNum = mTransNum;
        this.mFromAccountId = mFromAccountId;
        this.mToAccountId = mToAccountId;
        this.mTransDate = mTransDate;
        this.mAmount = mAmount;
        this.mTransType = mTransType;
    }

    public long getmTransNum() {
        return mTransNum;
    }

    public long getmFromAccountId() {
        return mFromAccountId;
    }

    public long getmToAccountId() {
        return mToAccountId;
    }

    public Date getmTransDate() {
        return mTransDate;
    }

    public double getmAmount() {
        return mAmount;
    }

    public TransactionType getmTransType() { return mTransType; }
}
