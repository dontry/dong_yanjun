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
import org.javalite.activejdbc.annotations.*;


@IdName("account_id")
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
        return status.equals("Y");
    }
    
    public double getBalance() {
        return this.getDouble("balance");
    }
    
    public void setBalance(double balance) {
        this.set("balance", balance).save();
    }
    
    public void freezAccount() {
        this.set("lockstatus","Y").saveIt();
    }
}
