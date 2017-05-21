package banksystemprototype.accounts.CreditCardAccount;

import banksystemprototype.accounts.Account;
import banksystemprototype.accounts.TypeOfAccount;

import java.util.Date;
/**
 * Created by caidong on 8/05/2017.
 */
public class CreditCardAccount{
    private final CreditAccount mCredit;
    private final Account mAccount;
    public CreditCardAccount(String username) {
        mAccount = Account.findFirst(" username = ? AND account_type = 'CREDIT' AND lockstatus = 'N' ", username);
        mCredit = CreditAccount.findFirst(" account_id = ? ", mAccount.getAccountId());
        //Clear today payment for a new day
        if(mCredit.getCurrentDate().getDate() != new Date().getDate()){
            mCredit.setTodayPayment(0);
        }
                
    }
    
    public double getDailyLimit() {
        return mCredit.getDailyLimit();
    }
    
    public double getLoanLimit() {
        return mCredit.getLoanLimit();
    }
    
    public Date getCurrentDate() {
        return mCredit.getCurrentDate();
    }
    
    public double getDailyPayment() {
        return mCredit.getTodayPayment();
    }
    
    public void setTodayPament(double amount) {
        double payment = mCredit.getDouble("daily_payment");
        mCredit.set("daily_payment", payment + amount).save();
    }
    
    public long getAccountId() {
        return  mAccount.getLong("account_id");
    }
    
    public String getUsername() {
        return mAccount.getString("username");
    }
    
    public TypeOfAccount getTypeOfAccount() {
        String type = mAccount.getString("account_type");
        return TypeOfAccount.valueOf(type);
    }
    
    public boolean getLockStatus() {
        String status = mAccount.getString("lockstatus");
        if(status.equals("N")) {
            return false;
        } else {
            return true;
        }
    }
    
    public double getBalance() {
        return mAccount.getDouble("balance");
    }
    
    public void setBalance(double balance) {
        mAccount.set("balance", balance).save();
    }
    public void freezeAccount() {
        mAccount.freezAccount();
    }
}
