package com.monash.accounts;

import com.sun.istack.internal.Nullable;

/**
 * Created by caidong on 8/05/2017.
 */
public class Account {
    private long mAccountId;
    private com.monash.accounts.AccountType mAccountType;
    private boolean mLocked;

    public Account(long accountId, com.monash.accounts.AccountType accountType, @Nullable  boolean locked) {
        mAccountId = accountId;
        mAccountType = accountType;
        mLocked = locked;
    }

    /**
     *
     * @return accountId;
     */
    public long getmAccountId() {
        return mAccountId;
    }

    /**
     *
     * @return accountType
     */
    public com.monash.accounts.AccountType getmAccountType() {
        return mAccountType;
    }

    /**
     *
     * @return lockStatus
     */
    public boolean ismLockStatus() {
        return mLocked;
    }

    public void setmLocked(boolean mLocked) {
        this.mLocked = mLocked;
    }
}
