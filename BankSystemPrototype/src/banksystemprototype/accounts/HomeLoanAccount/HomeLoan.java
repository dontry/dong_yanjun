package banksystemprototype.accounts.HomeLoanAccount;

import java.util.Date;
import org.javalite.activejdbc.Model;
/**
 * Created by caidong on 10/05/2017.
 */
public class HomeLoan extends Model{
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
    public Date getEndDate() {
        return this.getDate("end_date");
    }
    public Date getRepayDate() {
        return this.getDate("repay_date");
    }
    public Date getNextRepayDate() {
        return this.getDate("next_repay_date");
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
