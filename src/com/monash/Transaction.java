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
    private long mAmount;

    public Transaction(long mTransNum, Date mTransDate, long mAmount, long mFromAccountId, @Nullable long mToAccountId) {
        this.mTransNum = mTransNum;
        this.mFromAccountId = mFromAccountId;
        this.mToAccountId = mToAccountId;
        this.mTransDate = mTransDate;
        this.mAmount = mAmount;
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

    public long getmAmount() {
        return mAmount;
    }
}
