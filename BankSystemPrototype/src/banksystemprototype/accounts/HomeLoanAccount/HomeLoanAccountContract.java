package banksystemprototype.accounts.HomeLoanAccount;

import banksystemprototype.TypeOfAccountAction;


/**
 * Created by caidong on 10/05/2017.
 */
public interface HomeLoanAccountContract {
    interface View {
        void displayHomeLoan(Loan homeLoan);
    }
    interface UserActionListener {
        void openAccount(String username) throws Exception;
        void back();
    }
}
