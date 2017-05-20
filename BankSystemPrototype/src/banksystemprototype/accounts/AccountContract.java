package banksystemprototype.accounts;

import banksystemprototype.HomeLoanApplication;
import banksystemprototype.accounts.CreditCardAccount.CreditCardAccount;
import banksystemprototype.accounts.HomeLoanAccount.HomeLoanAccount;
import banksystemprototype.accounts.SavingAccount.SavingAccount;
import banksystemprototype.accounts.TermDepositAccount.TermDepositAccount;
import banksystemprototype.users.Customer;
import banksystemprototype.users._Customer;


/**
 * Created by caidong on 9/05/2017.
 */
public interface AccountContract {

    public interface View {
        void showCustomerProfile(Customer profile);
        void showUserFullname(String fullname);
        void showLogout();
    }

    public interface CustomerActionListener {
/*        double checkBalance(long accountId);
        List<Transaction> checkTransactions(long accountId, Date startingDate,  Date endingDate);
        List<TermDeposit>  selectAllTermDeposits(long accountId);
        TermDeposit checkTermDeposit(long termId);
        void createTermDeposit(double amount, TypeOfTermDeposit type, Date startingDate);*/
        void initialize(String username);
        void viewCustomerProfile();
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
