package banksystemprototype.accounts.TermDepositAccount;

import banksystemprototype.Utils.DataConverter;
import banksystemprototype.accounts.Account;
import banksystemprototype.accounts.TypeOfAccount;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
//import org.joda.time.Days;

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
    private boolean mIsfinished;

    public TermDeposit(long mTermId, double mBaseDeposit, TypeOfTermDeposit mTypeOfTermDeposit,  Date mStartingDate, boolean isFinished ) {
        this.mTermId = mTermId;
        this.mBaseDeposit = mBaseDeposit;
        this.mTypeOfTermDeposit = mTypeOfTermDeposit;
        this.mStartingDate =  mStartingDate;
        this.mInterestRate = initInterestRate(mTypeOfTermDeposit);
        this.mOverallBalance = mBaseDeposit;
        this.mIsfinished = isFinished;
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
            case THREE_MONTHS: return 0.03;  // interest rate 3%
            case SIX_MONTHS: return 0.04;    // interest rate 4%
            case TWELVE_MONTHS: return 0.05;  // interest rate 5%
                
        }
        return 0;
    }
    
    //Calculate interest rate
    //Early withdrawal will produce a penalty with half of interest.
    //If the term ends, the interest stops accrues.
    public double calculateInterest(Date date) {
        int diffMonth = DataConverter.monthBetweenDates(mStartingDate, date);
        double base = 0;
        double interest = 0;
        if(diffMonth < mTypeOfTermDeposit.month()) {
            base = 1 + mInterestRate / 2; 
            interest = Math.pow(base, diffMonth);
        } else {
            base = 1 + mInterestRate;
            interest = Math.pow(base, mTypeOfTermDeposit.month());
        }
        return interest;
    }
    
    public double getTotalAccrueAmount(Date date) {
        double interest = calculateInterest(date);
        return mBaseDeposit * interest;
    }
    
    public static TermDeposit convertToTermDeposit(HashMap<String, Object> map){
        Long td_purchase_id = ((BigDecimal) map.get("td_purchase_id")).longValueExact();
        Long account_id = ((BigDecimal) map.get("account_id")).longValueExact();
        TypeOfTermDeposit type = TypeOfTermDeposit.THREE_MONTHS;
        switch((Integer)map.get("account_type")) {
            case 3:
                type = TypeOfTermDeposit.THREE_MONTHS;
                break;
            case 6:
                type = TypeOfTermDeposit.SIX_MONTHS;
                break;
            case 12:
                type = TypeOfTermDeposit.TWELVE_MONTHS;
                break;
        }
        Date start_date = (Date) map.get("start_date");
        Date end_date = (Date) map.get("end_date");
        boolean finish_status = ((String) map.get("finish_status")).equals("N") ? false : true;
        Double amount = ((BigDecimal) map.get("balance")).doubleValue();
     
        return new TermDeposit(td_purchase_id, amount, type, start_date, finish_status);
    }
}
