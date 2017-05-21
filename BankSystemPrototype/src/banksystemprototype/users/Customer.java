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
import org.javalite.activejdbc.annotations.IdName;

@IdName("account_id")
public class Customer extends Model {
    public String getUsername() {
        return this.getString("username");
    }
    public String getPassword() {
        return this.getString("password");
    }
    public String getFirstName() {
        return this.getString("fname");
    }
    public String getLastName() {
        return this.getString("lname");
    }
    public String getEmail() {
        return this.getString("email");
    }
    public String getAddress() {
        return this.getString("address");
    }
    public long getPhone() {
        return this.getLong("phone");
    }
    public TypeOfId getIdType() {
        String type = this.getString("id_type");
        switch(type) {
            case "Passport":
                return TypeOfId.PASSPORT;
            case "Driver License":
                return TypeOfId.DRIVER_LICENSE;
            case "ID card":
                return TypeOfId.ID_CARD;
            default:
                return TypeOfId.CITIZENSHIP_CERTIFICATE;      
        }
    }
    public String getIdNubmer() {
        return this.getString("id_no");
    }
    public String getPin() {
        return this.getString("pin");
    }
}
