package com.monash.accounts.TermDepositAccount;

import com.monash.accounts.Account;
import com.monash.accounts.TypeOfAccount;
import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by caidong on 8/05/2017.
 */
public class TermDepositAccount extends Account {
    private HashMap<Long, TermDeposit> mTermDeposits;


    public TermDepositAccount(long accountId, TypeOfAccount typeOfAccount, boolean locked) {
        super(accountId, typeOfAccount, locked);
        mTermDeposits = new HashMap<>();
    }

    public TermDeposit selectTermDeposit(long id) {
        return mTermDeposits.get(id);
    }

    public HashMap<Long, TermDeposit> getmAllTermDeposits() {
        return mTermDeposits;
    }

//    public void createTermDeposit(long id, double balance, TypeOfTermDeposit type, @Nullable Date startingDate) {
//        if(startingDate == null) startingDate = new Date();
//       TermDeposit termDeposit = new TermDeposit(id, balance, type, startingDate);
//        mTermDeposits.put(id, termDeposit);
//    }
//
//    public void deleteTermDeposit(long id) {
//        mTermDeposits.remove(id);
//    }
}
