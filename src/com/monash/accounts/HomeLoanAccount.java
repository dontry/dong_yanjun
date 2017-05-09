package com.monash.accounts;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by caidong on 8/05/2017.
 */
public class HomeLoanAccount extends Account {
    HashMap<Long, com.monash.accounts.Loan> loans;

    public HomeLoanAccount(long accountId, Ac accountType, boolean locked) {
        super(accountId, accountType, locked);
        this.loans = new HashMap<Long, Loan>();
    }

    public Loan getLoan(long loanId) {
        return loans.get(loanId);
    }

    public void createLoan(long loanId, double principle, Date startingDate, double interest, int period) {
        Loan loan = new Loan(loanId, principle, startingDate, interest, period);
    }
}
