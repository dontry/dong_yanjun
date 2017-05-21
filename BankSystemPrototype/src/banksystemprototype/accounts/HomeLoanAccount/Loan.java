package banksystemprototype.accounts.HomeLoanAccount;

import java.util.Date;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
/**
 * Created by caidong on 10/05/2017.
 */
@IdName("loan_id")
public class Loan extends Model{
    static {
        dateFormat("yyyy-MM-dd", "start_date");
        dateFormat("yyyy-MM-dd", "end_date");
        dateFormat("yyyy-MM-dd", "repay_date");
        dateFormat("yyyy-MM-dd", "next_date");
        dateFormat("yyyy-MM-dd", "next_repay_date");
    }
    public long getLoanId() {
        return this.getLong("loan_id");
    }
    public long getAccountId() {
        return this.getLong("account_id");
    }
    public double getPrincipal() {
        return this.getDouble("principal");
    }
    public double getInterest() {
        return this.getDouble("interest");
    }
    public double getInterestRate() {
        return this.getDouble("interest_rate");
    }
    public double getRemainLoan() {
        return this.getDouble("remain_loan");
    }
    public double getRepaymentAmount() {
        return this.getDouble("repayment_amount");
    }
    public int getPeriod() {
        return this.getInteger("period");
    }
    public Date getStartDate() {
        return this.getDate("start_date");
    }
    public String getStartDateString() {
        return this.getString("start_date");
    }
    public Date getEndDate() {
        return this.getDate("end_date");
    }
    public String getEndDateString() {
        return this.getString("end_date");
    }
    public Date getRepayDate() {
        return this.getDate("repay_date");
    }
    public String getRepayDateString() {
        return this.getString("repay_date");
    }
    public Date getNextRepayDate() {
        return this.getDate("next_repay_date");
    }
    public String getNextRepayDateString() {
        return this.getString("next_repay_date");
    }
    public boolean getFinishStatus() {
        String isFinished =  this.getString("finish_status");
        return isFinished.equals("Y");
    }
    public boolean getFrozenStatus() {
        String isFrozen = this.getString("frozen_status");
        return isFrozen.equals("Y");
    }
}
