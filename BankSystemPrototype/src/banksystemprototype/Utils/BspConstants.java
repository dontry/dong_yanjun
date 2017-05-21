/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.Utils;

/**
 *
 * @author caidong
 */
public class BspConstants {
    public static final String DATABASE_NAME = "S7624366";
    public static final String[] ACCOUNT_ATTR_NAME = {"account_id", "username", "account_type", "lock_status",
    "balance"};
    public static final String[] CUSTOMER_ATTR_NAME = {"username", "password", "fname", "lname", "email", "address", 
        "phone", "id_type", "id_no", "pin"};
    public static final String[] HOME_LOAN_APPLICATION_ATTR_NAME = {"application_no", "customer_username", "amount", "period",
    "start_date", "end_date", "approve_status"};
    public static final String[] TERM_DEPOSIT_ATTR_NAME = {"td_purchase_id", "account_id", "td_type", "start_date", "end_date",
    "interest_rate", "amount", "finish_status"};
    public static final String[] TRANSACTION_ATTR_NAME = {"transaction_no", "username", "date","current_balance", "amount",
    "account_id","account_type"};
    public static long MILLISECOND_PER_DAY = 60 * 60 * 24 * 1000;
    public static long MILLISECOND_PER_MONTH = MILLISECOND_PER_DAY * 30;
    public static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String DB_CONNECTION =  "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148a";
    public static final String DB_USER = "S27624366";
    public static final String DB_PASSWORD = "student";
    public static final String ACCOUNT_LOCKED_MSG = "Sorry your account is locked.\n Please call Admin for help.";
    public static final String ACCOUNT_NULL_MSG = "Sorry, your account doesn't exist or locked.";
}
