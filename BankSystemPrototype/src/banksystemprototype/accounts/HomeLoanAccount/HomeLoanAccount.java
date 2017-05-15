package banksystemprototype.accounts.HomeLoanAccount;

import banksystemprototype.accounts.Account;
import banksystemprototype.accounts.TypeOfAccount;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by caidong on 8/05/2017.
 */
public class HomeLoanAccount extends Account {
    HashMap<Long, HomeLoan> loans;

    public HomeLoanAccount(long accountId, String username, TypeOfAccount typeOfAccount, boolean locked, double balance) {
        super(accountId, username, typeOfAccount, locked, balance);
        this.loans = new HashMap<Long, HomeLoan>();
    }

    public HomeLoan getLoan(long loanId) {
        return loans.get(loanId);
    }
}
