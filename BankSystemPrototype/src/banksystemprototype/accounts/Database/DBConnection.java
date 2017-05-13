/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author caidong
 */
public final class DBConnection {
    // TODO  DBConnection 
    public static final String DB_DRIVER = "oracle.jdbc,driver.OracleDriver";
    public static final String DB_CONNECTION =  "jdbc:oracle:thins:@hippo.its.monash.edu.au:1521:FIT5148A";
    public static final String DB_USER = "S27624366";
    public static final String DB_PASSWORD = "student";
    
    public static Connection conn = null;
    public static Connection getConnection(){
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148a", "Student60", "student");
            System.out.println("Connected to Oracle");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static Connection getConnectionB(){
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148b", "Student60", "student");
            System.out.println("Connected to Oracle");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void closeConnection(){
        try {
            conn.close();
            System.out.println("Connection is closed.");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
