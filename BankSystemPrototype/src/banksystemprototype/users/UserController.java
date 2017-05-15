/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.users;

import banksystemprototype.TypeOfMessageDialog;
import banksystemprototype.accounts.Database.DBConnection;
import banksystemprototype.accounts.Database.DBManager;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author caidong
 */
public class UserController implements UserContract.UserActionListener {
    private static final String CUSTOMER = "CUSTOMER";
    private static final String ADMINISTRATOR = "ADMINISTRATOR";
    private UserContract.View view;
    private Connection conn;

    
    public UserController(UserContract.View v) {
        view = v;
        conn = DBConnection.getConnection();
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
        String condition = " WHERE username = '" + username + "' AND password = '" + password + "'";
        String tableName = userType.equals(CUSTOMER) ? "S27624366.CUSTOMER" : "S27624366.ADMIN";
        List<Object[]> objList = DBManager.check(tableName, condition);
        return objList.size() == 1;
    } 
}
