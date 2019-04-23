/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author Bartek
 * @version 5.0
 */
public class dbController {
    
    /**
     * 
     * @param limit count of results
     * @return results (From top) limited by limit variable
     */
    public Vector<Double> getHistory( int limit ) {
        Vector<Double> maclaurinHistoryContainer = new Vector<Double>();
        String Query = "SELECT VALUE FROM BORO.RESULTS FETCH FIRST " + limit + " ROWS ONLY";
        Connection connection = null;
        
        try {   
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Maclaurin", "boro", "java");
            Statement statement = connection.createStatement();
            
            ResultSet rsOut = statement.executeQuery(Query);
            while (rsOut.next()){
                maclaurinHistoryContainer.add( Double.parseDouble(rsOut.getString("value")) );
            }
            connection.close();
            return maclaurinHistoryContainer;
        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("ClassNotFound exception: " + cnfe.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqle) {
                System.err.println("SQL exception: " + sqle.getMessage());
            }            
        }
        return maclaurinHistoryContainer;
    }
    
    /**
     * 
     * @param query query to execute
     * @throws Exception if there any problem with add results
     */
     public void executeUpdate(String query) throws Exception {
        Connection connection = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Maclaurin", "boro", "java");
            Statement statement = connection.createStatement();
            
            int result = statement.executeUpdate(query);
            connection.close();
        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("ClassNotFound exception: " + cnfe.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqle) {
                System.err.println("SQL exception: " + sqle.getMessage());
                throw new Exception("DB ERROR");
            }            
        }
    }
}
