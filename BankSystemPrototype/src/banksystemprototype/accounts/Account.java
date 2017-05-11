package banksystemprototype.accounts;

/**
 * Created by caidong on 8/05/2017.
 */
public class Account {
    private long mAccountId;
    private TypeOfAccount mTypeOfAccount;
    private boolean mLocked;

    public Account(long accountId, TypeOfAccount typeOfAccount, boolean locked) {
        mAccountId = accountId;
        mTypeOfAccount = typeOfAccount;
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
    public TypeOfAccount getmTypeOfAccount() {
        return mTypeOfAccount;
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
