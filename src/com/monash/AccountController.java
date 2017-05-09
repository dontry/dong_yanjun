package com.monash;

import com.monash.accounts.Account;
import com.monash.accounts.AccountType;
import com.sun.istack.internal.Nullable;

import java.util.Date;

/**
 * Created by caidong on 9/05/2017.
 */
public class AccountController {
    public Account selectAccount(long accountId) {
        //TODO: select account
        return null;
    }

    public boolean createAccount(String username, AccountType type) {
        //TODO: create account
        return false;
    }

    public double checkBalance(long accountId) {
        //TODO: check balance
        return 0;
    }

    public boolean checkBalance(String username, AccountType type) {
        //TODO: check balance
        return false;
    }

    public boolean checkTransactionLog(long accountId, Date startingDate, @Nullable Dat endingDate) {
        //TODO: check transaction log
        return false;
    }


}
