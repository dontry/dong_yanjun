package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.accounts.Transaction.Transaction;
import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public class SavingAccountController implements SavingAccountContract.UserActionListener {
    private SavingAccount mSavingAccount;
    private SavingAccountContract.View view;
    
    public SavingAccountController(SavingAccountContract.View v) {
        view = v;
    }

    @Override
    public double deposit(double amount) {
        double balance = mSavingAccount.getmBalance();
        balance += amount;
        mSavingAccount.setmBalance(balance);
        view.refreshBalance(String.valueOf(balance));
        return balance;
    }

    @Override
    public double withdraw(double amount) throws Exception {
        double balance = mSavingAccount.getmBalance();
        balance -= amount;
        if(balance - amount < 0) throw new BalanceLimitException();
        mSavingAccount.setmBalance(balance);
        view.refreshBalance(String.valueOf(balance));
        return balance;
    }

    @Override
    public double transfer(double amount, long toAccountId) throws Exception {
        double balance = mSavingAccount.getmBalance();
        balance -= amount;
        if(balance - amount < 0) throw new BalanceLimitException();
        mSavingAccount.setmBalance(balance);
        view.refreshBalance(String.valueOf(balance));
        return balance;
    }

    @Override
    public List<Transaction> checkTransactions(Date startingDate, Date endingDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void openAccount(long accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
