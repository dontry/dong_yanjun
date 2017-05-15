package banksystemprototype.accounts;



import banksystemprototype.accounts.CreditCardAccount.CreditCardAccount;
import banksystemprototype.accounts.HomeLoanAccount.HomeLoanAccount;
import banksystemprototype.accounts.SavingAccount.SavingAccount;
import banksystemprototype.accounts.TermDepositAccount.TermDepositAccount;
import banksystemprototype.users.Customer;

/**
 * Created by caidong on 9/05/2017.
 */
public class CustomerAccountController implements AccountContract.CustomerActionListener{

    private final AccountContract.View mHomeView;

    public CustomerAccountController(AccountContract.View mHomeView) {
        this.mHomeView = mHomeView;
    }


    @Override
    public void viewCustomerProfile( Customer customer) {
        mHomeView.showCustomerProfile(customer);
    }

    @Override
    public Account selectAccount(String username, TypeOfAccount typeOfAccount) {
        return null;
    }

    @Override
    public void openSavingAccount( SavingAccount account) {
        mHomeView.showSavingAccount(account.getmAccountId());
    }

    @Override
    public void openTermDepositAccount( TermDepositAccount account) {
        mHomeView.showTermDepositAccount(account.getmAccountId());
    }

    @Override
    public void openCreditCardAccount( CreditCardAccount account) {
        mHomeView.showSavingAccount(account.getmAccountId());
    }

    @Override
    public void openHomeLoanAccount(HomeLoanAccount account) {
        mHomeView.showHomeLoanAccount(account.getmAccountId());
    }

    @Override
    public void logout() {
        mHomeView.showLogout();
    }
}
