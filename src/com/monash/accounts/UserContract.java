package com.monash.accounts;

import com.monash.users.Customer;
import com.monash.users.User;

/**
 * Created by caidong on 9/05/2017.
 */
public interface UserContract {
    boolean login(String username, String password);
    void logout();
    User getUser(String username, String password);

    interface CustomerActionListener {
        Customer getCustomer();
        void saveCustomer();
    }

    interface AdministratorActionListner{
        Customer getCustomer(String username);
        void changeCustomerPIN(String username, long newPIN);
    }
}
