package banksystemprototype.accounts.CreditCardAccount;


import banksystemprototype.Exceptions.BalanceLimitException;
import banksystemprototype.TypeOfAccountAction;
import banksystemprototype.TypeOfMessageDialog;
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
        void refreshBalance(double balance);
        void refreshDailyPayment(double payment);
        void showDailyPaymentLimit(double limit);
        void showLoanLimit(double limit);
        void disposeActionDialog(TypeOfAccountAction action);
        void showMessageDialog(String msg, TypeOfMessageDialog type);
        void close();
    }
    interface UserActionListener {
        double deposit() throws BalanceLimitException;
        double withdraw() throws BalanceLimitException;
        double transfer() throws BalanceLimitException;
        void initialize();
        void openAccount(String username) throws Exception;
        void closeAccount();
        void back();
        void newAction(TypeOfAccountAction action);
    }
}
