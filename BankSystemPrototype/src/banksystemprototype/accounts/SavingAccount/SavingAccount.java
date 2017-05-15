package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.accounts.Account;
import banksystemprototype.accounts.TypeOfAccount;

/**
 * Created by caidong on 8/05/2017.
 */
public class SavingAccount extends Account {
    public SavingAccount(long accountId, String username, TypeOfAccount typeOfAccount, boolean locked, double balance) {
        super(accountId, username, typeOfAccount, locked, balance);
    }

    public void addMoney(double amount) {
       super.setBalance(super.getBalance()+amount);
    }

    public void deductMoney(double amount) {
       super.setBalance(super.getBalance()-amount);
    }
}
