package banksystemprototype.accounts;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by caidong on 8/05/2017.
 */
public class _Account {
    private long mAccountId;
    private String mUsername;
    private TypeOfAccount mTypeOfAccount;
    private boolean mLocked;
    private double mBalance;

    public _Account(long accountId, String username, TypeOfAccount typeOfAccount, boolean locked, double balance) {
        mAccountId = accountId;
        mTypeOfAccount = typeOfAccount;
        mLocked = locked;
        mUsername = username;
        mBalance = balance;
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
    
    public String getUsername() {
        return mUsername;
    }
    
    public double getBalance() {
        return mBalance;
    }
    
    public void setBalance(double balance) {
        mBalance = balance;
    }
    
    public static _Account convertToAccount(HashMap<String, Object> map) {
        Long account_id = ((BigDecimal) map.get("account_id")).longValueExact();
        String username = (String) map.get("username");
        TypeOfAccount type = (TypeOfAccount) TypeOfAccount.valueOf(String.valueOf(map.get("account_type")).trim());
        boolean lockStatus = ((String) map.get("lock_status")).equals("N") ? false : true;
        Double balance = ((BigDecimal) map.get("balance")).doubleValue();
     
        return new _Account(account_id, username, type, lockStatus, balance);
    }
}
