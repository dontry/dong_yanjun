package banksystemprototype.accounts.TermDepositAccount;

import banksystemprototype.Utils.BspConstants;
import java.util.Date;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;
import org.javalite.activejdbc.annotations.IdGenerator;
//import org.joda.time.Days;

/**
 * Created by caidong on 8/05/2017.
 */
@IdName("td_purchase_id")
@Table("term_deposits")
@IdGenerator("td_purchase_id_seq.nextVal")
public class TermDeposit extends Model{
//    private final Date mStartDate;
//    private final Date mEndDate;
//    private final double mInterestRate;
//    private final double mBase;
//    private final TypeOfTermDeposit mTypeOfTermDeposit;
//    
//    public TermDeposit() {
//        super();
//        mStartDate = this.getDate("start_date");
//        mEndDate = this.getDate("end_date");
//        mBase = this.getDouble("amount");
//        mTypeOfTermDeposit = initTypeOfTermDeposit();
//        mInterestRate = convertInterestRate(mTypeOfTermDeposit.month());
//    }
    
    public long getTermId() {
        return this.getLong("td_purchase_id");
    }
    public double getAccountId() {
        return this.getLong("account_id"); 
    };
    
    public final TypeOfTermDeposit convertTypeOfTermDeposit() {
        int typeNum = this.getInteger("td_type");
        switch(typeNum) {
            case 3:
                return TypeOfTermDeposit.THREE_MONTHS;
            case 6:
                return TypeOfTermDeposit.SIX_MONTHS;
            case 12:
                return TypeOfTermDeposit.TWELVE_MONTHS;
        }
        return null; 
    }
    
    public TypeOfTermDeposit getTypeOfTermDeposit() {
      return convertTypeOfTermDeposit();
    }
    
    public Date getStartDate() {
        return this.getDate("start_date");
    }
    
    public Date getEndDate() {
        return this.getDate("end_date");
    }
    
    public double getBaseDeposit() {
        return this.getDouble("amount");
    }
    
    private double getInterestRate() {
        return this.getDouble("interest_rate");
    }
    
    public boolean getFinishSatus() {
        return this.getString("finish_status").equals("Y");
    }
    //Calculate interest rate
    //Early withdrawal will produce a penalty with half of interest.
    //If the term ends, the interest stops accrues.
    public double calculateInterest(Date date) {
        double base = 0;
        double interest = 0;
        Date curDate = new Date();
        if(curDate.before(this.getEndDate())) {
            base = 1 + this.getInterestRate() / 2;
            int diffMonths = (int) Math.floor( (curDate.getTime() - this.getStartDate().getTime()) / BspConstants.MILLISECOND_PER_MONTH);
            interest = Math.pow(base, diffMonths);
        } else {
            base += this.getInterestRate();
            interest = Math.pow(base, this.getTypeOfTermDeposit().month());
        }
        return interest;
    }
    
    public double getTotalAccrueAmount(Date date) {
        double interest = calculateInterest(date);
        double total = this.getBaseDeposit() * interest;
        return total;
    }
    
    public void finishTerm() {
        this.set("finish_status", "Y").save();
    }
    
//    public static int convertType(int months) {
//        switch(months) {
//            case 3:
//                return 1;
//            case 6:
//                return 2;
//            case 12:
//                return 3;
//            default:
//                return 0;
//        }
//    }
    public static double convertInterestRate(int months) {
          switch(months) {
            case 3:
                return 0.03;
            case 6:
                return 0.04;
            case 12:
                return 0.05;
            default:
                return 0;
        }
    }
    
       public static void main(String args[]) {
       Base.open(BspConstants.DB_DRIVER, BspConstants.DB_CONNECTION, BspConstants.DB_USER, BspConstants.DB_PASSWORD);
       TermDeposit t = new TermDeposit();
       Object id = t.getId();
      
        t.set("account_id", 10)
         .set("td_type",6)
         .set("interest_rate",TermDeposit.convertInterestRate(6))
         .setDate("start_date",new Date())
         .setDate("end_date",new Date())
         .set("amount",10000)
         .set("finish_status","N");
       
       System.out.println(t);
        t.saveIt();
    }
}
