package banksystemprototype.accounts.TermDepositAccount;



import banksystemprototype.accounts.Account;
import banksystemprototype.accounts.TypeOfAccount;
import java.util.HashMap;

/**
 * Created by caidong on 8/05/2017.
 */
public class TermDepositAccount extends Account {
    private HashMap<Long, TermDeposit> mTermDeposits;


    public TermDepositAccount(long accountId, String username, TypeOfAccount typeOfAccount, boolean locked, double balance) {
        super(accountId, username, typeOfAccount, locked, balance);
        mTermDeposits = new HashMap<>();
    }

    public TermDeposit selectTermDeposit(long id) {
        return mTermDeposits.get(id);
    }

    public HashMap<Long, TermDeposit> getmAllTermDeposits() {
        return mTermDeposits;
    }

//    public void createTermDeposit(long id, double balance, TypeOfTermDeposit type,  Date startingDate) {
//        if(startingDate == null) startingDate = new Date();
//       TermDeposit termDeposit = new TermDeposit(id, balance, type, startingDate);
//        mTermDeposits.put(id, termDeposit);
//    }
//
//    public void deleteTermDeposit(long id) {
//        mTermDeposits.remove(id);
//    }
}
