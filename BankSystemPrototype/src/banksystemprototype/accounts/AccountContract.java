package banksystemprototype.accounts;

import banksystemprototype.HomeLoanApplication;
import banksystemprototype.users.Customer;


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
        void deleteAccount(long accountId);
        void unlockAccount(long accountId);
        void createLoan(HomeLoanApplication application);
        void showLoanApplication(HomeLoanApplication application);
        long getAccountId(String username, TypeOfAccount type);
        void changeCustomerPIN(String username, long newPIN);
    }
}
