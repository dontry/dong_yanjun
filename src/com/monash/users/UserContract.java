package com.monash.users;

import com.monash.users.Customer;
import com.monash.users.User;

/**
 * Created by caidong on 9/05/2017.
 */
public interface UserContract {
    boolean login(String username, String password);
    User getUser(String username, String password);
//
//    interface CustomerActionListener {
//        Customer getCustomer();
//        void saveCustomer();
//    }
//
//    interface AdministratorActionListner{

//    }
}
