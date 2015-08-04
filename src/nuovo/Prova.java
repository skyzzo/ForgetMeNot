/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuovo;

import java.sql.SQLException;

/**
 *
 * @author daniele
 */
public class Prova {
    
    public static void main(String[]args) throws SQLException, ClassNotFoundException, MyException {
        Utente utente=new Utente("ciccio", "ciccio@gmail.com", "password");
        utente.inserisciDatisuDB();
    }
}
