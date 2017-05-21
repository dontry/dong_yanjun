package banksystemprototype.accounts.TermDepositAccount;



import banksystemprototype.accounts.Account;
import banksystemprototype.accounts.CreditCardAccount.CreditAccount;
import banksystemprototype.accounts._Account;
import banksystemprototype.accounts.TypeOfAccount;
import java.util.HashMap;
import java.util.Iterator;
import org.javalite.activejdbc.LazyList;
import java.util.List;

/**
 * Created by caidong on 8/05/2017.
 */
public class TermDepositAccount {
    private Account mAccount;


    public TermDepositAccount(String username) {
        mAccount =  Account.findFirst(" username = ? AND account_type = 'TERM_DEPOSIT' AND lockstatus = 'N' ", username);   
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
        return status.equals("Y");
    }
    
    public double getBalance() {
        return mAccount.getDouble("balance");
    }
    
    public void setBalance(double balance) {
        mAccount.set("balance", balance).save();
    }
    
    public HashMap<Long, TermDeposit> getTermDeposits() {
        List<TermDeposit> terms = TermDeposit.find("account_id = ? AND finish_status='N' ", this.getAccountId());
        HashMap<Long, TermDeposit> map = new HashMap<>();
        for (Iterator<TermDeposit> iterator = terms.iterator(); iterator.hasNext();) {
            TermDeposit next = iterator.next();
            map.put(next.getTermId(), next);
        }
        return map;
    }
    public void freezeAccount() {
        mAccount.freezAccount();
    }
}
