/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts;

/**
 *
 * @author caidong
 */
import org.javalite.activejdbc.Model;
public class Account extends Model{
    public long getAccountId() {
        return  this.getLong("account_id");
    }
    
    public String getUsername() {
        return this.getString("username");
    }
    
    public TypeOfAccount getTypeOfAccount() {
        String type = this.getString("account_type");
        return TypeOfAccount.valueOf(type);
    }
    
    public boolean getLockStatus() {
        String status = this.getString("lockstatus");
        if(status.equals("N")) {
            return false;
        } else {
            return true;
        }
    }
    
    public double getBalance() {
        return this.getDouble("balance");
    }
}
