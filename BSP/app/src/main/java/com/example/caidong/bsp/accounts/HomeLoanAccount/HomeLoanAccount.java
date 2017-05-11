package com.example.caidong.bsp.accounts.HomeLoanAccount;


import com.example.caidong.bsp.accounts.Account;
import com.example.caidong.bsp.accounts.TypeOfAccount;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by caidong on 8/05/2017.
 */
public class HomeLoanAccount extends Account {
    HashMap<Long, HomeLoan> loans;

    public HomeLoanAccount(long accountId, TypeOfAccount typeOfAccount, boolean locked) {
        super(accountId, typeOfAccount, locked);
        this.loans = new HashMap<Long, HomeLoan>();
    }

    public HomeLoan getLoan(long loanId) {
        return loans.get(loanId);
    }
}
