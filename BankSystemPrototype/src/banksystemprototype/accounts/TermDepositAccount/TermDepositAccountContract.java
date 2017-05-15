package banksystemprototype.accounts.TermDepositAccount;


import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.TypeOfMessageDialog;
import banksystemprototype.accounts.Transaction.Transaction;
import java.util.Date;
import java.util.List;

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
        void showTermDeposit(List<TermDeposit> terms);
    }
    interface UserActionListener {
        double withdraw();
        void createTermDeposit();
        double transfer();
        void viewAllTermDeposits();
        TermDeposit checkTermDeposit(long termId);
        List<TermDeposit> getAllTermDeposit();
        List<Transaction> checkTransactions(Date startingDate,  Date endingDate);
        void openAccount(String username);
        void showAccount();
        void saveAccount();
        void back();
        void newAction(TypeOfAccountAction action);
    }
}
