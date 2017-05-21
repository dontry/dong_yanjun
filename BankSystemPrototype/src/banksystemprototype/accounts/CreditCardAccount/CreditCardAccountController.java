/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.CreditCardAccount;

import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.Exceptions.TypeOfLimit;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.TypeOfMessageDialog;
import banksystemprototype.Utils.BspConstants;
import banksystemprototype.accounts.Account;
import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.accounts.SavingAccount.SavingAccountController;
import banksystemprototype.accounts.Transaction.Transaction;
import banksystemprototype.users.Customer;
import banksystemprototype.widgets.PinFrame;
import banksystemprototype.widgets.PinServiceApi;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.javalite.activejdbc.Base;

/**
 *
 * @author caidong
 */
public class CreditCardAccountController implements CreditCardContract.UserActionListener, PinServiceApi.Listener{
    private TypeOfAccountAction mAccountAction;
    private CreditCardContract.View view;
    private CreditCardAccount mCreditCardAccount;
    private String mUsername;
    private double mLoanLimit;
    private double mDailyLimit;
    
    public CreditCardAccountController(CreditCardContract.View v) {
        view = v;
    }

    
    @Override
    public double deposit() throws BalanceLimitException {
        double amount = view.getDepositAmount();
        double balance = mCreditCardAccount.getBalance();
        balance += amount;
        double dailyPayment = mCreditCardAccount.getDailyPayment() - amount;
        if(amount <= 0) throw new BalanceLimitException(TypeOfLimit.BALANCE);
        mCreditCardAccount.setBalance(balance);
        mCreditCardAccount.setTodayPament(dailyPayment);
        
        view.refreshBalance(String.valueOf(mCreditCardAccount.getBalance()));
        view.refreshDailyPayment(mCreditCardAccount.getDailyPayment());
        return balance;    
    }

    @Override
    public double withdraw() throws BalanceLimitException {
        double amount = view.getWithdrawAmount();
        double balance = mCreditCardAccount.getBalance();
        balance -= amount;
        double dailyPayment = mCreditCardAccount.getDailyPayment() + amount;
        if(balance < mLoanLimit) throw new BalanceLimitException(TypeOfLimit.LOAN);
        if(dailyPayment > mDailyLimit) throw new BalanceLimitException(TypeOfLimit.DAILY_PAYMENT);
        if(amount <= 0) throw new BalanceLimitException(TypeOfLimit.AMOUNT);
        if(amount > balance) throw new BalanceLimitException(TypeOfLimit.BALANCE);        mCreditCardAccount.setBalance(balance);
        mCreditCardAccount.setTodayPament(dailyPayment);
        
        view.refreshBalance(String.valueOf(mCreditCardAccount.getBalance()));
        view.refreshDailyPayment(mCreditCardAccount.getDailyPayment());
        return balance;    
    }

    @Override
    public double transfer() throws BalanceLimitException {
        double amount = view.getTransferAmount();
        Long toAccountId = view.getTransferId();
        double balance = mCreditCardAccount.getBalance();
        balance -= amount;
        double dailyPayment = mCreditCardAccount.getDailyPayment() + amount;
        if(balance < mLoanLimit) throw new BalanceLimitException(TypeOfLimit.LOAN);
        if(dailyPayment > mDailyLimit) throw new BalanceLimitException(TypeOfLimit.DAILY_PAYMENT);
        if(amount <= 0) throw new BalanceLimitException(TypeOfLimit.AMOUNT);
        if(amount > balance) throw new BalanceLimitException(TypeOfLimit.BALANCE);
        Account toAccount = Account.findFirst(" account_id = ?", toAccountId);
        double toAccountNewBalance = toAccount.getBalance() + amount;
        mCreditCardAccount.setBalance(balance);
        mCreditCardAccount.setTodayPament(dailyPayment);
        toAccount.setBalance(toAccountNewBalance);
        
        view.refreshBalance(String.valueOf(mCreditCardAccount.getBalance()));
        view.refreshDailyPayment(mCreditCardAccount.getDailyPayment());
        return balance;    
    }

    @Override
    public void openAccount(String username) throws Exception {
        Base.open(BspConstants.DB_DRIVER, BspConstants.DB_CONNECTION, BspConstants.DB_USER, BspConstants.DB_PASSWORD);
        mCreditCardAccount = new CreditCardAccount(username);
        mUsername = username;
        mLoanLimit = mCreditCardAccount.getLoanLimit();
        mDailyLimit = mCreditCardAccount.getDailyLimit();
       
        initialize();
    }

    @Override
    public void back() {
        closeAccount();
        view.close();
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
    public void initialize() {
        view.refreshBalance(mCreditCardAccount.getBalance());
        view.refreshDailyPayment(mCreditCardAccount.getDailyPayment());
        view.showLoanLimit(mLoanLimit);
        view.showDailyPaymentLimit(mDailyLimit);
    }

    @Override
    public void freezeAccount() {
        mCreditCardAccount.freezeAccount();
        view.showMessageDialog(BspConstants.ACCOUNT_LOCKED_MSG, TypeOfMessageDialog.WARNING);
        back();
    }

}
