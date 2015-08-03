/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author daniele
 */
public class ConnectionManager implements Serializable{
    private ConnectionManager() {};
    private static boolean driverLoaded = false;
    private static Connection conn = null;
    private static final String MY_DRIVER = "org.postgresql.Driver";
    private static final String MY_URL = "jdbc:postgresql://localhost/ForgetMeNot";
    private static final String LOGIN = "postgres";
    private static final String PASSWD = "varicella";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null) {
            Class.forName(MY_DRIVER);
            conn = DriverManager.getConnection(MY_URL, LOGIN, PASSWD);
        } else if (conn.isClosed()) {
            conn = DriverManager.getConnection(MY_URL, LOGIN, PASSWD);
        } else // In questo caso si e’ verificato un comportamento
        // non atteso. Inserisco comandi che corrispondono
        // ad una politica da seguire in caso di errore
        {
            conn.rollback(); //si e’ scelto di disfare tutto il lavoro eseguito dall’ultimo commit.
        }
        return conn;
    }
}
