package banksystemprototype.accounts.HomeLoanAccount;

import banksystemprototype.TypeOfAccountAction;


/**
 * Created by caidong on 10/05/2017.
 */
public interface HomeLoanAccountContract {
    interface View {
        double getTransferAmount();
        double getDepositAmount();
    }
    interface UserActionListener {
        void depositMoney( double amount);
        void repayMoney( double amount);
        void openAccount( long accountId);
        void showAccount();
        void saveAccount();
        void back();
        void newAction(TypeOfAccountAction action);
    }
}
