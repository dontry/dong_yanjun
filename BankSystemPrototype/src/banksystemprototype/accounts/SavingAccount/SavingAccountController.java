package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.accounts.Transaction.Transaction;
import banksystemprototype.widgets.PinFrame;
import banksystemprototype.widgets.PinServiceApi;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by caidong on 10/05/2017.
 */
public class SavingAccountController implements SavingAccountContract.UserActionListener, PinServiceApi.Listener {
    private SavingAccount mSavingAccount;
    private SavingAccountContract.View view;
    private TypeOfAccountAction mAccountAction;
    
    public SavingAccountController(SavingAccountContract.View v) {
        view = v;
    }

    @Override
    public double deposit() {
        double amount = view.getDepositAmount();
        double balance = mSavingAccount.getmBalance();
        balance += amount;
        mSavingAccount.setmBalance(balance);
        view.refreshBalance(String.valueOf(balance));
        return balance;
    }

    @Override
    public double withdraw() throws BalanceLimitException {
        double amount = view.getWithdrawAmount();
        double balance = mSavingAccount.getmBalance();
        balance -= amount;
        if(balance - amount < 0) throw new BalanceLimitException();
        mSavingAccount.setmBalance(balance);
        view.refreshBalance(String.valueOf(balance));
        return balance;
    }

    @Override
    public double transfer() throws BalanceLimitException {
        double amount = view.getTransferAmount();
        long toAccountId = view.getTransferAccountId();
        double balance = mSavingAccount.getmBalance();
        balance -= amount;
        if(balance - amount < 0) throw new BalanceLimitException();
        mSavingAccount.setmBalance(balance);
        view.refreshBalance(String.valueOf(balance));
        return balance;
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
    public boolean verifyPin(Object pin) {
        //verifyPin
        boolean isVerified = true;
        if(isVerified) {
            switch(mAccountAction) {
                case DEPOSIT:
                    deposit();
                    break;
                case TRANSFER:
            {
                try {
                    transfer();
                } catch (BalanceLimitException ex) {
                    Logger.getLogger(SavingAccountController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case WITHDRAW:
            {
                try {
                    withdraw();
                } catch (BalanceLimitException ex) {
                    Logger.getLogger(SavingAccountController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
            }
        } else {
            
        }
        System.out.println("pin verified is" + String.valueOf(isVerified));
        return isVerified;
    }

    @Override
    public void back() {
        DBConnection.closeConnection();
    }

    @Override
    public void newAction(TypeOfAccountAction action) {
        mAccountAction = action;
        new PinFrame(this).setVisible(true);
    }
}
