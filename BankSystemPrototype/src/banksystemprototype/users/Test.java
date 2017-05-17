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
import org.javalite.activejdbc.Base;

public class Test extends Model{
    public static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String DB_CONNECTION =  "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148a";
    public static final String DB_USER = "S27624366";
    public static final String DB_PASSWORD = "student";
    
    public static void main(String args[]) {
       Base.open(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
       Test t = Test.findFirst("test_id = ?", "1");
       System.out.println(t);
       System.out.println(t.get("test_id"));
       Admin admin = Admin.findFirst("admin_id = ?", "123");
       HomeLoan homeLoan = HomeLoan.findFirst("loan_id = ?", "111");
       System.out.println(admin);
       System.out.println(homeLoan);
    }
}
