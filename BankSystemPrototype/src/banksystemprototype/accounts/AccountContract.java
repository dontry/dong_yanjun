package banksystemprototype.accounts;

import banksystemprototype.HomeLoanApplication;
import banksystemprototype.accounts.CreditCardAccount.CreditCardAccount;
import banksystemprototype.accounts.HomeLoanAccount.HomeLoanAccount;
import banksystemprototype.accounts.SavingAccount.SavingAccount;
import banksystemprototype.accounts.TermDepositAccount.TermDepositAccount;
import banksystemprototype.users._Customer;


/**
 * Created by caidong on 9/05/2017.
 */
public interface AccountContract {

    public interface View {
        void showSavingAccount(long accountId);
        void showTermDepositAccount(long accountId);
        void showCreditCardAccount(long accountId);
        void showHomeLoanAccount(long accountId);
        void showCustomerProfile(_Customer profile);
        void showLogout();
    }

    public interface CustomerActionListener {
/*        double checkBalance(long accountId);
        List<Transaction> checkTransactions(long accountId, Date startingDate,  Date endingDate);
        List<TermDeposit>  selectAllTermDeposits(long accountId);
        TermDeposit checkTermDeposit(long termId);
        void createTermDeposit(double amount, TypeOfTermDeposit type, Date startingDate);*/
        void viewCustomerProfile(_Customer customer);
        _Account selectAccount(String username, TypeOfAccount typeOfAccount);
        void openSavingAccount(SavingAccount account);
        void openTermDepositAccount(TermDepositAccount account);
        void openCreditCardAccount(CreditCardAccount account);
        void openHomeLoanAccount(HomeLoanAccount account);
        void logout();

    }

    public interface  AdministratorListener {
        _Customer getCustomer(String username);
        _Account selectAccount(long accountId);
        void deleteAccount(long accountId);
        void unlockAccount(long accountId);
        void createLoan(HomeLoanApplication application);
        void showLoanApplication(HomeLoanApplication application);
        long getAccountId(String username, TypeOfAccount type);
        void changeCustomerPIN(String username, long newPIN);
    }
}
