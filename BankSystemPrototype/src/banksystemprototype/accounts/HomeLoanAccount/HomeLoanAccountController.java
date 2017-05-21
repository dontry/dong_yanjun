/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.HomeLoanAccount;

import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.Utils.BspConstants;
import banksystemprototype.accounts.Account;
import org.javalite.activejdbc.Base;

/**
 *
 * @author caidong
 */
public class HomeLoanAccountController implements HomeLoanAccountContract.UserActionListener {
    private HomeLoanAccountContract.View view;
    private Account mHomeLoanAccount;
    public HomeLoanAccountController(HomeLoanAccountContract.View v) {
     view = v;   
    }
 

    @Override
    public void openAccount(String username) throws Exception{
        Base.open(BspConstants.DB_DRIVER, BspConstants.DB_CONNECTION, BspConstants.DB_USER, BspConstants.DB_PASSWORD);
        mHomeLoanAccount = Account.findFirst(" username = ? AND account_type = 'LOAN' AND lockstatus = 'N' ", username);
        Loan homeLoan = Loan.findFirst(" account_id = ? ", mHomeLoanAccount.getAccountId());
        view.displayHomeLoan(homeLoan);
    }

    @Override
    public void back() {
        Base.close();
    }
}
