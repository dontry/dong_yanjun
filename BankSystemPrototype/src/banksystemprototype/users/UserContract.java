package banksystemprototype.users;

import banksystemprototype.TypeOfMessageDialog;

/**
 * Created by caidong on 9/05/2017.
 */
public interface UserContract {
//    User getUser(String username, String password);
    interface View {
        void showLogin(TypeOfUser userType, String username);
        void showMessageDialog(String msg, TypeOfMessageDialog type);
    }
    
    interface UserActionListener {
        void login(String username, String password, String userType);
    }
}
