/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.TermDepositAccount;

import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.TypeOfMessageDialog;
import banksystemprototype.Utils.BspConstants;
import banksystemprototype.accounts.Account;
import banksystemprototype.accounts.SavingAccount.SavingAccountController;
import banksystemprototype.users.Customer;
import banksystemprototype.widgets.PinFrame;
import banksystemprototype.widgets.PinServiceApi;
import java.util.Date;
import java.util.HashMap;
import java.text.DecimalFormat;
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
    private String mUsername;
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
    public void openAccount(String username) throws Exception{
        Base.open(BspConstants.DB_DRIVER, BspConstants.DB_CONNECTION, BspConstants.DB_USER, BspConstants.DB_PASSWORD);
        mTermDepositAccount = new TermDepositAccount(username);
        mUsername = username;
        mTermDeposits = mTermDepositAccount.getTermDeposits();
        double totalBalance = 0;
        totalBalance = mTermDeposits.entrySet().stream().map((entry) -> {
            Long key = entry.getKey();
            return entry;
        }).map((entry) -> entry.getValue()).map((value) -> value.getTotalAccrueAmount(new Date())).reduce(totalBalance, (accumulator, _item) -> accumulator + _item);
        String balanceString = new DecimalFormat("#0.00").format(totalBalance);
        view.refreshBalance(String.valueOf(balanceString));        
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
        if(isVerified){
            try {
                proceedTransaction();
            } catch (BalanceLimitException ex) {
                view.showMessageDialog(ex.getMessage(), TypeOfMessageDialog.WARNING);
                Logger.getLogger(TermDepositAccountController.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public long getAccountId() {
        return  mTermDepositAccount.getAccountId();
    }

    @Override
    public void freezeAccount() {
        mTermDepositAccount.freezeAccount();
        view.showMessageDialog(BspConstants.ACCOUNT_LOCKED_MSG, TypeOfMessageDialog.WARNING);
        back();
    }
 }
    
