/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.TermDepositAccount;

import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.Utils.BspConstants;
import banksystemprototype.Utils.DataConverter;
import banksystemprototype.accounts.Account;
import banksystemprototype.accounts._Account;
import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.accounts.Database.DBManager;
import banksystemprototype.accounts.SavingAccount.SavingAccountController;
import banksystemprototype.accounts.Transaction.Transaction;
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
 *
 * @author caidong
 */
public class TermDepositAccountController implements TermDepositAccountContract.UserActionListener, PinServiceApi.Listener {
    private TypeOfAccountAction mAccountAction;
    private TermDepositAccountContract.View view;
    private HashMap<Long, TermDeposit> mTermDeposits;
   
    private TermDepositAccount mTermDepositAccount;
    
    public TermDepositAccountController(TermDepositAccountContract.View v) {
        view = v;
    }
    
    @Override
    public void withdraw() {
        long termId = view.getWithdrawTermDepositId();
        
        //finish term;
        TermDeposit term = mTermDeposits.get(termId);
        term.finishTerm();
        refreshTermDeposits();
        view.refreshBalance(String.valueOf(mTermDepositAccount.getBalance() - term.getBaseDeposit()));
    }

    @Override
    public void createTermDeposit() { 
        long accountId = mTermDepositAccount.getAccountId();
        int type = view.getTypeOfTermDeposit().month();
        Date startingDate = view.getTermDepositStartingDate();
        double amount = view.getCreateDepositAmount();
        Date endingDate = new Date(startingDate.getTime() + type * BspConstants.MILLISECOND_PER_MONTH); 
        TermDeposit term = new TermDeposit()
                .set("account_id", accountId)
                .set("td_type",type)
                .set("interest_rate",TermDeposit.convertInterestRate(type))
                .setDate("start_date",startingDate)
                .setDate("end_date",endingDate)
                .set("amount",amount)
                .set("finish_status","N");
        term.saveIt();
        
        refreshTermDeposits();
        view.refreshBalance(String.valueOf(mTermDepositAccount.getBalance() + term.getBaseDeposit()));
    }

    @Override
    public double transfer() {
        long termId = view.getTransferTermDepositId();
        long toAccountId = view.getTransferAccountId();
        
        TermDeposit term = mTermDeposits.get(termId);
        double amount = term.getTotalAccrueAmount(new Date());
        Account account  = Account.findById(toAccountId);
        
        term.finishTerm();
         
        account.setBalance(account.getBalance() + amount);
        view.refreshBalance(String.valueOf(mTermDepositAccount.getBalance() - term.getBaseDeposit()));
        refreshTermDeposits();
        return amount;
    }
    
    @Override
    public void showTermDeposits(TypeOfAccountAction action) {
        view.showTermDeposit(mTermDeposits, action);
    }

    @Override
    public void openAccount(String username) {
        Base.open(BspConstants.DB_DRIVER, BspConstants.DB_CONNECTION, BspConstants.DB_USER, BspConstants.DB_PASSWORD);
        mTermDepositAccount = new TermDepositAccount(username);
        mTermDeposits = mTermDepositAccount.getTermDeposits();
        view.refreshBalance(String.valueOf(mTermDepositAccount.getBalance()));       
    }

    @Override
    public void back() {
        closeAccount();
    }

    @Override
    public boolean verifyPin(Object pin) {
        //verifyPin
        boolean isVerified = true;
        if(isVerified){
            proceedTransaction();
        }
        return isVerified;
    }
    

    @Override
    public void newAction(TypeOfAccountAction action) {
        mAccountAction = action;
        new PinFrame(this).setVisible(true);    
    }
    
    private void proceedTransaction() {
        switch(mAccountAction) {
            case CREATE_DEPOSIT:
                createTermDeposit();
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
    
    private void refreshTermDeposits() {
        mTermDeposits = mTermDepositAccount.getTermDeposits();
    }

    @Override
    public void closeAccount() {
        Base.close();
    }
 }
    
