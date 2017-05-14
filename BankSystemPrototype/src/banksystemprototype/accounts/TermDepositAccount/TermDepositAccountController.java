/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.TermDepositAccount;

import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.accounts.SavingAccount.SavingAccountController;
import banksystemprototype.accounts.Transaction.Transaction;
import banksystemprototype.widgets.PinFrame;
import banksystemprototype.widgets.PinServiceApi;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caidong
 */
public class TermDepositAccountController implements TermDepositAccountContract.UserActionListener, PinServiceApi.Listener {
    private TypeOfAccountAction mAccountAction;
    private TermDepositAccountContract.View view;
    private TermDeposit mTermDeposit;
    
    public TermDepositAccountController(TermDepositAccountContract.View v) {
        view = v;
    }
    
    @Override
    public double withdraw() {
        double amount = view.getWithdrawAmount();
        //update Table;
        deleteTermDeposit(mTermDeposit.getmTermId());
        
        return amount;
    }

    @Override
    public void createTermDeposit() {
        double amount = view.getCreateDepositAmount();
        TypeOfTermDeposit type = view.getTypeOfTermDeposit();
        Date startingDate = view.getTermDepositStartingDate();
        //insert to  table
        
    }

   
    private void deleteTermDeposit(long termDepositId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double transfer() {
        double amount = view.getTransferAmount();
        long toAccountId = view.getTransferAccountId();
        //update table
        deleteTermDeposit(mTermDeposit.getmTermId());
        
        return amount;
    }
    
    @Override
    public void viewAllTermDeposits() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TermDeposit checkTermDeposit(long termId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public List<TermDeposit> getAllTermDeposit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void back() {
        DBConnection.closeConnection();
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


 }
    
