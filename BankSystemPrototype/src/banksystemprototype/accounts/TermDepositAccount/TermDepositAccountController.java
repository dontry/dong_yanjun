/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.TermDepositAccount;

import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.accounts.Transaction.Transaction;
import java.util.Date;
import java.util.List;

/**
 *
 * @author caidong
 */
public class TermDepositAccountController implements TermDepositAccountContract.UserActionListener {

    @Override
    public double withdrawMoneyFromTermDepsoit(long termDeposit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createTermDeposit(double amount, TypeOfTermDeposit type, Date startingDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTermDeposit(long termDeposit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double transferMoney(double amount, long toAccountId) {
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
    
}
