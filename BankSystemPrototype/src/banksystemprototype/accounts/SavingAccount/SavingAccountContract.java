package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.accounts.Transaction.Transaction;
import java.util.Date;
import java.util.List;

/**
 * Created by caidong on 10/05/2017.
 */
public interface SavingAccountContract {
    interface View {
        void refreshBalance(String amount);
        double getWithdrawAmount();
        double getDepositAmount();
        double getTransferAmount();
        long getTransferAccountId();
        void disposeActionDialog(TypeOfAccountAction action);
    }
    interface UserActionListener {
        double deposit();
        double withdraw() throws Exception;
        double transfer() throws Exception;
        List<Transaction> checkTransactions(Date startingDate,  Date endingDate);
        void openAccount( long accountId);
        void showAccount();
        void back();
        void newAction(TypeOfAccountAction action);
    }
}
