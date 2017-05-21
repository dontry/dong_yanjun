package banksystemprototype.accounts.TermDepositAccount;


import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.TypeOfMessageDialog;
import banksystemprototype.accounts.Transaction.Transaction;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

/**
 * Created by caidong on 10/05/2017.
 */
public interface TermDepositAccountContract {
    interface View {
        double getTransferAmount();
        long getTransferAccountId();
        double getWithdrawAmount();
        double getCreateDepositAmount();
        TypeOfTermDeposit getTypeOfTermDeposit();
        Date getTermDepositStartingDate();
        long getTransferTermDepositId();
        long getWithdrawTermDepositId();
        void disposeActionDialog(TypeOfAccountAction action);
        void showMessageDialog(String msg, TypeOfMessageDialog type);
        void refreshBalance(String balance);
        void showTermDeposit(HashMap<Long, TermDeposit> terms, TypeOfAccountAction action);
        void close();
    }
    interface UserActionListener {
        void withdraw();
        void createTermDeposit() throws Exception;
        double transfer();
        void showTermDeposits(TypeOfAccountAction action);
//        List<Object[]> getTermDeposits();
        long getAccountId();
        void openAccount(String username) throws Exception;
        void closeAccount();
        void back();
        void newAction(TypeOfAccountAction action);
    }
}
