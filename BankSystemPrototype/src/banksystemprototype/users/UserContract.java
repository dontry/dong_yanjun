package banksystemprototype.users;

/**
 * Created by caidong on 9/05/2017.
 */
public interface UserContract {
    User getUser(String username, String password);
    interface View {
        void login();
    }
    
    interface UserActionListener {
        boolean verifyUser(String username, String password, String userType);
    }
}
