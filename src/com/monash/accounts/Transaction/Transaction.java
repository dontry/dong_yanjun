package com.monash.accounts.Transaction;

import com.monash.Utils.DataConverter;
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
    private TypeOfTransaction mTransType;

    public Transaction(long mTransNum, TypeOfTransaction mTransType, Date mTransDate, double mAmount, @Nullable long mToAccountId, long mFromAccountId) {
        this.mTransNum = mTransNum;
        this.mFromAccountId = mFromAccountId;
        this.mToAccountId = mToAccountId; //what if long is null?
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

    public TypeOfTransaction getmTransType() { return mTransType; }

    public String toString() {
        String toAccountString = mToAccountId == 0 ? "" : ("\nTo Account:" + mToAccountId);
        return "Transaction No. " + mTransNum +
                "\nTransaction Date: " + DataConverter.dateToString(mTransDate) +
                "\nTransaction Type: " + mTransType +
                "\nFrom Account" + mFromAccountId +
                 toAccountString +
                "\nTransaction amount: $" + mAmount;
    }
}
