package banksystemprototype.accounts;



import banksystemprototype.Utils.BspConstants;
import banksystemprototype.users.Customer;
import org.javalite.activejdbc.Base;
/**
 * Created by caidong on 9/05/2017.
 */
public class CustomerAccountController implements AccountContract.CustomerActionListener{

    private final AccountContract.View view;
    private Customer mCustomer;

    public CustomerAccountController(AccountContract.View mHomeView) {
        this.view = mHomeView;
    }

    @Override
    public void initialize(String username) {
        Base.open(BspConstants.DB_DRIVER, BspConstants.DB_CONNECTION, BspConstants.DB_USER, BspConstants.DB_PASSWORD);
        mCustomer = Customer.findFirst(" username = ? ",  username);
        String fullname = mCustomer.getFirstName() + " " + mCustomer.getLastName();
        view.showUserFullname(fullname);
        Base.close();
    }
    
    @Override
    public void viewCustomerProfile() {
        view.showCustomerProfile(mCustomer);
    }

    @Override
    public void logout() {
        view.showLogout();
    }

}
