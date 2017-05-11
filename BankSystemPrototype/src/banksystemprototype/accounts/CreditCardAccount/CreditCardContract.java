package banksystemprototype.accounts.CreditCardAccount;


import banksystemprototype.accounts.Transaction.Transaction;


import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface CreditCardContract {
    interface UserActionListener {
        void depositMoney( double amount);
        double withdrawMoney( double amount);
        void transferMoney( double amount,  long toAccountId);
        List<Transaction> checkTransactions(Date startingDate,  Date endingDate);
        void openAccount( long accountId);
        void showAccount();
        void saveAccount();
    }
}
