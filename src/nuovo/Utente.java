/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;      /*COMMENTO ALL'INIZIO*/

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author daniele
 */
public class Utente implements Serializable{

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
    private String username;
    private String email;
    private String password;
    
    public Utente(String username,String email, String password) {
        this.username=username;
        this.email=email;
        this.password=password;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void SetUsername(String username) {
        this.username=username;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email=email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void SetPassword(String password) {
        this.password=password;
    }
    
    public void leggiDatidaDB() throws SQLException, ClassNotFoundException, MyException {
        UtenteDAO.load(this);
    }
    
    public void inserisciDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        UtenteDAO.insert(this);
    }
    
    public void aggiornaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        UtenteDAO.update(this);
    }
    
    public void cancellaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        UtenteDAO.delete(this);
    }
}
