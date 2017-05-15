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

/**
 *
 * @author caidong
 */
public class TermDepositAccountController implements TermDepositAccountContract.UserActionListener, PinServiceApi.Listener {
    private TypeOfAccountAction mAccountAction;
    private TermDepositAccountContract.View view;
    private List<TermDeposit> mTermDepositList;
    private TermDeposit mTermDeposit;
    private static final String TERM_DEPOSIT_TABLE_NAME = "S27624366.TERM_DEPOSIT";
    private String ACCOUNT_TABLE_NAME =  "S27624366.ACCOUNT";
    private Account mTermDepositAccount;
    private String mUsername;
    
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
        String[] attributes = {};
        String termDepositId = "td_purchase_id_seq.nextVal";
        String accountId = "17";
        int month = view.getTypeOfTermDeposit().month();
        String period = String.valueOf(month);
        Date startingDate = view.getTermDepositStartingDate();
        String amount = String.valueOf(view.getCreateDepositAmount());
        Date endingDate = new Date(startingDate.getTime() + month * 30 * BspConstants.MILLISECOND_PER_DAY); 
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
        ArrayList<TermDeposit> terms = new ArrayList<>();
        String condition1 = " WHERE accountId = " + String.valueOf(mTermDepositAccount.getmAccountId());
        List<Object[]> objList = DBManager.check(TERM_DEPOSIT_TABLE_NAME, condition1);
        for(Object[] o: objList) {
            HashMap<String, Object> map = DataConverter.objectArrayToHashMap(BspConstants.ACCOUNT_ATTR_NAME, o);
            TermDeposit term = TermDeposit.convertToTermDeposit(map);
            terms.add(term);
        }
        return terms;
    }

    @Override
    public List<Transaction> checkTransactions(Date startingDate, Date endingDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void openAccount(String username) {
        String condition = " WHERE username = '" + username + "'";
        mUsername = username;
        Object[] obj = DBManager.check(ACCOUNT_TABLE_NAME, condition).get(0);
        HashMap<String, Object> map = DataConverter.objectArrayToHashMap(BspConstants.ACCOUNT_ATTR_NAME, obj);
        mTermDepositAccount = Account.convertToAccount(map);
        mTermDepositList  = getAllTermDeposit();
        view.showTermDeposit(mTermDepositList);
       
        view.refreshBalance(String.valueOf(mTermDepositAccount.getBalance()));    
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
    
