package banksystemprototype.accounts.HomeLoanAccount;

import java.util.Date;

/**
 * Created by caidong on 10/05/2017.
 */
public class HomeLoan {
    private long loanId;
    private double principle;
    private double remainingLoan;
    private Date startingDate;
    private int period;
    private double interest;
    private Date nextRepaymentDate;
    private double repaymentAmount;

    public HomeLoan(long loanId, double principle,  Date startingDate, double interest, int period, double repaymentAmount) {
        this.loanId = loanId;
        this.principle = principle;
        this.remainingLoan = remainingLoan;
        this.startingDate = startingDate;
        this.period = period;
        this.interest = interest;
        this.repaymentAmount = repaymentAmount;
    }

    public void deductRepayment(double amount) {
        remainingLoan -= amount;
    }

    public void stop() {
        //TODO Stop the mortgage
    }
}
