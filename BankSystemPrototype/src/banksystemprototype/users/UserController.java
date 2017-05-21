/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.users;

import banksystemprototype.TypeOfMessageDialog;
import banksystemprototype.Utils.BspConstants;
import org.javalite.activejdbc.Base;

/**
 *
 * @author caidong
 */
public class UserController implements UserContract.UserActionListener {
    private static final String CUSTOMER = "CUSTOMER";
    private static final String ADMIN = "ADMIN";
    private UserContract.View view;
    
    public UserController(UserContract.View v) {
        view = v;
    }
    
    @Override
    public void login(String username, String password, String userType) {
        boolean isVerified = verifyUser(username, password, userType);
        if(isVerified) {
            view.showLogin(TypeOfUser.valueOf(userType), username);
         } else {
            view.showMessageDialog("Sorry, your password or username is incorrect", TypeOfMessageDialog.WARNING);
        }
    }
    
    private boolean verifyUser(String username, String password, String userType) {
        try {
                Base.open(BspConstants.DB_DRIVER, BspConstants.DB_CONNECTION, BspConstants.DB_USER, BspConstants.DB_PASSWORD);
                boolean isVerified = false;
                switch(userType) {
                case CUSTOMER:
                    isVerified = Customer.findFirst(" username = ? AND password = ? ",  username, password) != null;
                    break;
                case ADMIN:
                     isVerified = Admin.findFirst(" username = ? AND password = ?", username, password) != null;
                     break;
                default:
            }
            Base.close();
            return isVerified;
        } catch (Exception ex) {
            view.showMessageDialog(ex.getMessage(), TypeOfMessageDialog.ERROR);
            return false;
        }      
    } 
}
