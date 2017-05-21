package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.Exceptions.AccountException;
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
    private final SavingAccountContract.View view;
    private TypeOfAccountAction mAccountAction;
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
        
        if(balance < amount) throw new BalanceLimitException(TypeOfLimit.BALANCE);
        if(amount < 0)throw new BalanceLimitException(TypeOfLimit.AMOUNT);
        balance -= amount;
        mSavingAccount.setBalance(balance);

        view.refreshBalance(String.valueOf(mSavingAccount.getBalance()));
        return balance;
    }

    @Override
    public double transfer() throws BalanceLimitException {
        double amount = view.getTransferAmount();
        Long toAccountId = view.getTransferAccountId();
        double balance = mSavingAccount.getBalance();
        
        if(balance < amount) throw new BalanceLimitException(TypeOfLimit.BALANCE);
        if(amount < 0)throw new BalanceLimitException(TypeOfLimit.AMOUNT);
        balance -= amount;
        Account toAccount = Account.findFirst(" account_id = ?", toAccountId);
        double toAccountNewBalance = toAccount.getBalance() + amount;
        mSavingAccount.setBalance(balance);
        toAccount.setBalance(toAccountNewBalance);
        
        view.refreshBalance(String.valueOf(mSavingAccount.getBalance()));
        return balance;
    }


    @Override
    public void openAccount(String username) throws Exception{
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
                view.showMessageDialog(ex.getMessage(), TypeOfMessageDialog.WARNING);
                Logger.getLogger(SavingAccountController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex) {
                view.showMessageDialog(ex.getMessage(), TypeOfMessageDialog.WARNING);
            }
        }
        return isVerified;
    }

    @Override
    public void back() {
        closeAccount();
        view.close();
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

    @Override
    public void freezeAccount() {
        mSavingAccount.freezAccount();
        view.showMessageDialog(BspConstants.ACCOUNT_LOCKED_MSG, TypeOfMessageDialog.WARNING);
        back();
    }

}
