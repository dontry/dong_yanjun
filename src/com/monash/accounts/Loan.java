package com.monash.accounts;

import java.util.Date;

/**
 * Created by caidong on 8/05/2017.
 */
public class Loan {
    private long loanId;
    private double principle;
    private double overallRepayment;
    private Date startingDate;
    private int period;
    private double interest;
    private Date nextRepaymentDate;

    public Loan(long loanId, double principle,  Date startingDate, double interest, int period) {
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
