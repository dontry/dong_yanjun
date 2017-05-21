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
import org.javalite.activejdbc.Model;

public class Admin extends Model{
    public String getUsername() {
        return this.getString("username");
    }
    public String getPassword() {
        return this.getString("password");
    }
}
