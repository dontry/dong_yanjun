/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.accounts.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author caidong
 */
public class DBManager {
    
    public static ArrayList<Object[]> check(String tableName, String condition) {
        Connection conn = DBConnection.getConnection();
        Statement stmt = null;
        ResultSetMetaData mdata;
        ArrayList<Object[]> resultList = new ArrayList<>();
        Object[] rowData = {};
        
        try {
            stmt = conn.createStatement();
            String query =  "SELECT * FROM " + tableName  + condition;
            ResultSet rset = stmt.executeQuery(query); // get all records from the student table 
            mdata = rset.getMetaData();

            int numberOfColumns = mdata.getColumnCount(); // get number of columns from metadata of the Resultset object
            while (rset.next()) {
                rowData = new Object[numberOfColumns]; // create a row of an array of Objects with the number of columns          
                for (int i = 0; i < rowData.length; i++) {
                    /* put an Object to the row using the value of the designated column in the current row of this ResultSet object */
                    rowData[i] = rset.getObject(i + 1); 
                }
                resultList.add(rowData);
            }
            rset.close();

        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
                DBConnection.closeConnection();  //which conn does it point to?
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultList;
    }
  
    public static void update(String tableName, HashMap<String, Object> attributes, String condition) {
        Connection conn = DBConnection.getConnection();
        Statement stmt = null;
        String stringAttributes = concatenateAttributes(attributes);
        try {
            stmt = conn.createStatement();
            /* update a membership record using the values from JTextField txtID1 and txtName1 */
            String sql = "UPDATE " + tableName + " SET  " + stringAttributes  + condition;
            stmt.executeUpdate(sql);
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
                DBConnection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public static void insert(String tableName, String[] values) {
        Connection conn = DBConnection.getConnection();
        Statement stmt = null;
        String joinValues = String.join(",", values);
        
        try {
            stmt = conn.createStatement();
            /* insert a student record using the values from JTextField txtID and txtName */
            String sql = "INSERT INTO " + tableName + " VALUES ("  + joinValues + "')";
            stmt.executeUpdate(sql);

        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
                DBConnection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
        
    public static void delete(String tableName, String condition) {
        Connection conn = DBConnection.getConnection();
        Statement stmt = null;
         try {
            stmt = conn.createStatement();
            
            String sql = "DELETE" + tableName + " WHERE " + condition;
            stmt.executeUpdate(sql);

        } catch (SQLException f) {
            System.out.println(f.getMessage());
        } finally {
            try {
                stmt.close();
                DBConnection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    private static String concatenateAttributes(HashMap<String, Object> attributes) {
        //HOW TO DEAL WITH DATE TYPE?
        ArrayList<String> attributesList = new ArrayList<>();
        for(Map.Entry attr: attributes.entrySet()) {
              String attrString = "";
            if(attr.getValue() instanceof Number) {
                   attrString = attr.getKey() + "=" + attr.getValue();
             } else if(attr.getValue() instanceof String) {
                   attrString = attr.getKey() + "= '" + attr.getValue() + "'";
             }
            attributesList.add(attrString);
        }
        return String.join(",", attributesList);
    }
}
