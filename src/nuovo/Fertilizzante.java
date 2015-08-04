/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Objects;



/**
 *
 * @author daniele
 */
public class Fertilizzante implements Serializable {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final Fertilizzante other = (Fertilizzante) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }
    

    public Fertilizzante(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }
    
    public void leggiDatidaDB() throws SQLException, ClassNotFoundException, MyException {
        FertilizzanteDAO.load(this);
    }
    
    public void inserisciDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        FertilizzanteDAO.insert(this);
    }
    
    public void aggiornaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        FertilizzanteDAO.update(this);
    }
    
    public void cancellaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        FertilizzanteDAO.delete(this);
    }
    
    private String nome;
    private String descrizione;
}
