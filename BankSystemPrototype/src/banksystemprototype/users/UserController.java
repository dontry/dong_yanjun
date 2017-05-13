/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.users;

/**
 *
 * @author caidong
 */
public class UserController implements UserContract.UserActionListener {
    private static final String CUSTOMER = "Customer";
    private static final String ADMINISTRATOR = "Administrator";
    private UserContract.View view;
    
    public UserController(UserContract.View v) {
        view = v;
    }
    
    @Override
    public boolean verifyUser(String username, String password, String userType) {
        boolean isVerified = true;
        switch(userType) {
            case CUSTOMER:
                break;
            case ADMINISTRATOR:
                break;
            default:
                break;
        }
        return isVerified;
    }
}
