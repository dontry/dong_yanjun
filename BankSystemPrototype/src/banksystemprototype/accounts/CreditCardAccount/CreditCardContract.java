package banksystemprototype.accounts.CreditCardAccount;


import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.accounts.Transaction.Transaction;


import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface CreditCardContract {
    interface View {
        void refreshBalance(String amount);
        double getTransferAmount();
        double getWithdrawAmount();
        double getDepositAmount();
        long getTransferId();
        void disposeActionDialog(TypeOfAccountAction action);
    }
    interface UserActionListener {
        void deposit();
        double withdraw() throws BalanceLimitException;
        void transfer() throws BalanceLimitException;
        List<Transaction> checkTransactions(Date startingDate,  Date endingDate);
        void openAccount( long accountId);
        void showAccount();
        void saveAccount();
        void back();
        void newAction(TypeOfAccountAction action);
    }
}
