package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.accounts.Transaction.Transaction;
import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface SavingAccountContract {
    interface View {
        void refreshBalance(String amount);
    }
    interface UserActionListener {
        double deposit(double amount);
        double withdraw(double amount) throws Exception;
        double transfer(double amount, long toAccountId) throws Exception;
        List<Transaction> checkTransactions(Date startingDate,  Date endingDate);
        void openAccount( long accountId);
        void showAccount();
        void saveAccount();
    }
}
