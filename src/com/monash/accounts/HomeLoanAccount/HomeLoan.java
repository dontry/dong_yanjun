package com.monash.accounts.HomeLoanAccount;

import java.util.Date;

/**
 * Created by caidong on 10/05/2017.
 */
public class HomeLoan {
    private long loanId;
    private double principle;
    private double overallRepayment;
    private Date startingDate;
    private int period;
    private double interest;
    private Date nextRepaymentDate;

    public HomeLoan(long loanId, double principle,  Date startingDate, double interest, int period) {
        this.loanId = loanId;
        this.principle = principle;
        this.overallRepayment = overallRepayment;
        this.startingDate = startingDate;
        this.period = period;
        this.interest = interest;
    }

    public void deductRepayment(double amount) {
        overallRepayment -= amount;
    }

    public void stop() {
        //TODO Stop the mortgage
    }
}
