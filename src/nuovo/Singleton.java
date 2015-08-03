/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;


import java.sql.*;
import java.sql.DriverManager;



public class Singleton {
    
    public Connection conn;
    private Statement statement;
    private volatile static Singleton db;
    private Singleton() {
        
        String url= "jdbc:postgresql://localhost/ForgetMeNot";
        String driver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "varicella";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    
    public static synchronized Singleton getDbCon() {
        if ( db == null ) {
            db = new Singleton();
        }
        return db;
 
    }
    
    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    
    public int operazione(String operazione) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(operazione);
        return result;
 
    }
    
    
}
