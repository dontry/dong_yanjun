package banksystemprototype.accounts.SavingAccount;

import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.TypeOfMessageDialog;
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
        String getUsername();
        void showMessageDialog(String msg, TypeOfMessageDialog type);
    }
    interface UserActionListener {
        double deposit() throws Exception;
        double withdraw() throws Exception;
        double transfer() throws Exception;
        void openAccount(String username);
        void showAccount();
        void back();
        void newAction(TypeOfAccountAction action);
    }
}
