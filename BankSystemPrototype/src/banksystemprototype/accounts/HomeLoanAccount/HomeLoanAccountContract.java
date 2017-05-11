package banksystemprototype.accounts.HomeLoanAccount;


/**
 * Created by caidong on 10/05/2017.
 */
public interface HomeLoanAccountContract {
    interface UserActionListener {
        void depositMoney( double amount);
        void repayMoney( double amount);
        void openAccount( long accountId);
        void showAccount();
        void saveAccount();
    }
}
