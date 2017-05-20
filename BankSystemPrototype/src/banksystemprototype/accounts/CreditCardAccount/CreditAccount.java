/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.CreditCardAccount;

import java.util.Date;
import org.javalite.activejdbc.annotations.*;
import org.javalite.activejdbc.Model;

/**
 *
 * @author caidong
 */
@Table("credit_accounts")
@IdName("account_id")
public class CreditAccount extends Model{
    //add attribute current_date, today_payment;
    public double getDailyLimit() {
        return this.getDouble("daily_payment_limit");
    }
    public double getLoanLimit() {
        return this.getDouble("loan_limit");
    }
    public double getTodayPayment() {
        return this.getDouble("daily_payment");
    }
    public Date getCurrentDate() {
        return this.getDate("current_date");
    }
    public void setTodayPayment(double amount) {
        this.setDouble("today_payment", amount);
    }
    
    
}
