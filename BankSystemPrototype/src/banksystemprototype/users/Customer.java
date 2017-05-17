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
public class Customer extends Model {
    String getUsername() {
        return this.getString("username");
    }
    String getPassword() {
        return this.getString("password");
    }
    String getFirstName() {
        return this.getString("fname");
    }
    String getLastName() {
        return this.getString("lname");
    }
    String getEmail() {
        return this.getString("email");
    }
    String getAddress() {
        return this.getString("address");
    }
    long getPhone() {
        return this.getLong("phone");
    }
    String getIdType() {
        return this.getString("id_type");
    }
    String getIdNubmer() {
        return this.getString("id_no");
    }
    String getPin() {
        return this.getString("pin");
    }
}
