package banksystemprototype.accounts.TermDepositAccount;

import banksystemprototype.Utils.DataConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.Days;

/**
 * Created by caidong on 8/05/2017.
 */
public class TermDeposit {
    private long mTermId;
    private double mBaseDeposit;
    private TypeOfTermDeposit mTypeOfTermDeposit;
    private Date mStartingDate;
    private double mOverallBalance;
    private double mInterestRate;

    public TermDeposit(long mTermId, double mBaseDeposit, TypeOfTermDeposit mTypeOfTermDeposit,  Date mStartingDate) {
        this.mTermId = mTermId;
        this.mBaseDeposit = mBaseDeposit;
        this.mTypeOfTermDeposit = mTypeOfTermDeposit;
        this.mStartingDate =  mStartingDate;
        this.mInterestRate = initInterestRate(mTypeOfTermDeposit);
        this.mOverallBalance = mBaseDeposit;
    }

    public double getmInterestRate() {return mInterestRate; };

    public Date getmStartingDate() {
        return mStartingDate;
    }

    public double getmOverallBalance() {
        return mOverallBalance;
    }

    public long getmTermId() {
        return mTermId;
    }

    public double getmBaseDeposit() {
        return mBaseDeposit;
    }

    public TypeOfTermDeposit getmTypeOfTermDeposit() {
        return mTypeOfTermDeposit;
    }

    public void addInterest() {
        //TODO add Interest
    }

    public void penaliseInterest() {
        //TODO penalise Interest
    }

    public double getOverallBalance() {
        //TODO calculate overall balance
        return 0;
    }
    
    private double initInterestRate(TypeOfTermDeposit type) {
        switch(type) {
            case THREE_MONTHS: return 0.03;
            case SIX_MONTHS: return 0.04;
            case TWELVE_MONTHS: return 0.05;
                
        }
        return 0;
    }
    
    //Calculate interest rate
    //Early withdrawal will produce a penalty with half of interest.
    public double calculateInterest(Date date) {
        int diffMonth = DataConverter.monthBetweenDates(mStartingDate, date);
        double base = 0;
        if(diffMonth < mTypeOfTermDeposit.month()) {
            base = 1 + mInterestRate / 2; 
        } else {
            base = 1 + mInterestRate;
        }
        
        return Math.pow(base, diffMonth);
    }
    
    public double getTotalAccrueAmount(Date date) {
        double interest = calculateInterest(date);
        return mBaseDeposit * interest;
    }
}
