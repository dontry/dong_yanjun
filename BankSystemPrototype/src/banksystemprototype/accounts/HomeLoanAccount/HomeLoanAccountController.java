/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.HomeLoanAccount;

import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.widgets.PinServiceApi;

/**
 *
 * @author caidong
 */
public class HomeLoanAccountController implements HomeLoanAccountContract.UserActionListener, PinServiceApi.Listener {
    private HomeLoanAccountContract.View view;
    public HomeLoanAccountController(HomeLoanAccountContract.View v) {
     view = v;   
    }
    @Override
    public void depositMoney(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void repayMoney(double amount) {
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
        return false;
    }

    @Override
    public void newAction(TypeOfAccountAction action) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
