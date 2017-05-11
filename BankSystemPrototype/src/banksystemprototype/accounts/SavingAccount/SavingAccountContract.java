package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.accounts.Transaction.Transaction;
import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface SavingAccountContract {
    interface View {
    }
    interface UserActionListener {
        void deposit(double amount);
        double withdraw(double amount);
        void transfer(double amount, long toAccountId);
        List<Transaction> checkTransactions(Date startingDate,  Date endingDate);
        void openAccount( long accountId);
        void showAccount();
        void saveAccount();
    }
}
