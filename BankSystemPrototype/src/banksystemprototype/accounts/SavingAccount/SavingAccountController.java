package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.Exceptions.TypeOfLimit;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.TypeOfMessageDialog;
import banksystemprototype.Utils.BspConstants;
import banksystemprototype.Utils.DataConverter;
import banksystemprototype.accounts.Account;
import banksystemprototype.accounts._Account;
import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.accounts.Database.DBManager;
import banksystemprototype.accounts.Transaction.Transaction;
import banksystemprototype.accounts.TypeOfAccount;
import banksystemprototype.users.Customer;
import banksystemprototype.widgets.PinFrame;
import banksystemprototype.widgets.PinServiceApi;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.javalite.activejdbc.Base;

/**
 * Created by caidong on 10/05/2017.
 */
public class SavingAccountController implements SavingAccountContract.UserActionListener, PinServiceApi.Listener {
    private Account mSavingAccount;
    private SavingAccountContract.View view;
    private TypeOfAccountAction mAccountAction;
    private String ACCOUNT_TABLE_NAME =  "S27624366.ACCOUNT";
    private String CUSTOMER_TABLE_NAME = "S27624366.CUSTOMER";
    private String mUsername;
    
    public SavingAccountController(SavingAccountContract.View v) {
        view = v;
    }

    @Override
    public double deposit() throws BalanceLimitException{
        double amount = view.getDepositAmount();
        double balance = mSavingAccount.getBalance();
        balance += amount;
        if(amount < 0) throw new BalanceLimitException(TypeOfLimit.BALANCE);
        mSavingAccount.setBalance(balance);
        
        view.refreshBalance(String.valueOf(mSavingAccount.getBalance()));
        return balance;
    }

    @Override
    public double withdraw() throws BalanceLimitException {
        double amount = view.getWithdrawAmount();
        double balance = mSavingAccount.getBalance();
        balance -= amount;
        if(balance < 0 || amount < 0) throw new BalanceLimitException(TypeOfLimit.BALANCE);
        mSavingAccount.setBalance(balance);

        view.refreshBalance(String.valueOf(mSavingAccount.getBalance()));
        return balance;
    }

    @Override
    public double transfer() throws BalanceLimitException {
        double amount = view.getTransferAmount();
        Long toAccountId = view.getTransferAccountId();
        double balance = mSavingAccount.getBalance();
        balance -= amount;
        if(balance < 0 || amount < 0) throw new BalanceLimitException(TypeOfLimit.BALANCE);
        
        Account toAccount = Account.findFirst(" account_id = ?", toAccountId);
        double toAccountNewBalance = toAccount.getBalance() + amount;
        mSavingAccount.setBalance(balance);
        toAccount.setBalance(toAccountNewBalance);
        
        view.refreshBalance(String.valueOf(mSavingAccount.getBalance()));
        return balance;
    }


    @Override
    public void openAccount(String username) {
        Base.open(BspConstants.DB_DRIVER, BspConstants.DB_CONNECTION, BspConstants.DB_USER, BspConstants.DB_PASSWORD);
        mSavingAccount = Account.findFirst(" username = ? AND account_type = 'SAVING' AND lockstatus = 'N' ", username);
        mUsername = username;
        view.refreshBalance(String.valueOf(mSavingAccount.getBalance()));
    }

   
    @Override
    public boolean verifyPin(Object pin) {
        //verifyPin
        Customer customer = Customer.findFirst(" username = ? AND pin = ? ", mUsername, pin);
        boolean isVerified = customer != null;
        if(isVerified) {
            try {
                proceedTransaction();
            } catch (BalanceLimitException ex) {
                view.showMessageDialog("Sorry, the amount exceeds the limit.", TypeOfMessageDialog.WARNING);
                Logger.getLogger(SavingAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            view.showMessageDialog("Sorry, your PIN is incorrect.", TypeOfMessageDialog.WARNING);
        }
        return isVerified;
    }

    @Override
    public void back() {
        closeAccount();
    }

    @Override
    public void newAction(TypeOfAccountAction action) {
        mAccountAction = action;
        new PinFrame(this).setVisible(true);
    }
    
    private void proceedTransaction() throws BalanceLimitException {
        switch(mAccountAction) {
            case DEPOSIT:
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

    @Override
    public void closeAccount() {
        Base.close();
    }

}
