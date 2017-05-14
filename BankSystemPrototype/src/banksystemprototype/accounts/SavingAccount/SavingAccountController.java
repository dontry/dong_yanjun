package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.accounts.Database.DBManager;
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
    private String ACCOUNT_TABLE_NAME =  "S27624366.ACCOUNT";
    private String CUSTOMER_TABLE_NAME = "S27624366.CUSTOMER";
    private String mUsername;
    
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
    public void openAccount(String username) {
        String condition = " WHERE username = '" + username + "'";
        mUsername = username;
        Object[] obj = DBManager.check(ACCOUNT_TABLE_NAME, condition).get(0);
        
    }

    @Override
    public void showAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public boolean verifyPin(Object pin) {
        //verifyPin
        String condition = " WHERE username = '" + mUsername + "' AND pin = " + pin ;
        Object[] obj = DBManager.check(CUSTOMER_TABLE_NAME, condition).get(0);
        boolean isVerified = obj.length > 0;
        if(isVerified) {
            try {
                proceedTransaction();
                        } catch (BalanceLimitException ex) {
                Logger.getLogger(SavingAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
        }
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
    
      private void proceedTransaction() throws BalanceLimitException {
        switch(mAccountAction) {
            case CREATE_DEPOSIT:
                deposit();
                break;
            case TRANSFER:
                transfer();
                break;
            case WITHDRAW:
                withdraw();              
                break;
        }
        view.disposeActionDialog(mAccountAction);
    }

}
