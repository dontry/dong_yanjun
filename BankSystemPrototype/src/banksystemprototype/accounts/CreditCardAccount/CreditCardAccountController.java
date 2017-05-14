/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.CreditCardAccount;

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
 *
 * @author caidong
 */
public class CreditCardAccountController implements CreditCardContract.UserActionListener, PinServiceApi.Listener{
    private TypeOfAccountAction mAccountAction;
    private CreditCardContract.View view;
    
    public CreditCardAccountController(CreditCardContract.View v) {
        view = v;
    }

    
    @Override
    public void deposit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double withdraw() throws BalanceLimitException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transfer() throws BalanceLimitException {
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
        if(isVerified) {
            proceedTransaction();
        } else {
            //
        }
        System.out.println("pin verified is" + String.valueOf(isVerified));
        return isVerified;
    }

    @Override
    public void newAction(TypeOfAccountAction action) {
        mAccountAction = action;
        new PinFrame(this).setVisible(true);   
    }
    
    private void proceedTransaction(){
        switch(mAccountAction) {
            case DEPOSIT:
                deposit();
                break;
            case TRANSFER:
        {
            try {
                transfer();
            } catch (BalanceLimitException ex) {
                Logger.getLogger(CreditCardAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case WITHDRAW:
        {
            try {
                withdraw();
            } catch (BalanceLimitException ex) {
                Logger.getLogger(CreditCardAccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
        }
        view.disposeActionDialog(mAccountAction);
    }
}
