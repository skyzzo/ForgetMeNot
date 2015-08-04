/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;

import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author daniele
 */
public class Luogo implements Serializable {

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantita_acqua(String quantita_acqua) {
        this.quantita_acqua = quantita_acqua;
    }

    public void setUmidita(String umidita) {
        this.umidita = umidita;
    }

    public void setIntervallo_acqua(String intervallo_acqua) {
        this.intervallo_acqua = intervallo_acqua;
    }

    public String getNome() {
        return nome;
    }

    public String getQuantita_acqua() {
        return quantita_acqua;
    }

    public String getUmidita() {
        return umidita;
    }

    public String getIntervallo_acqua() {
        return intervallo_acqua;
    }

    public Luogo(String nome, String quantita_acqua, String umidita, String intervallo_acqua) {
        this.nome = nome;
        this.quantita_acqua = quantita_acqua;
        this.umidita = umidita;
        this.intervallo_acqua = intervallo_acqua;
    }
    
    
     public void leggiDatidaDB() throws SQLException, ClassNotFoundException, MyException {
        LuogoDAO.load(this);
    }
    
    public void inserisciDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        LuogoDAO.insert(this);
    }
    
    public void aggiornaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        LuogoDAO.update(this);
    }
    
    public void cancellaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        LuogoDAO.delete(this);
    }
    
    private String nome;
    private String quantita_acqua;
    private String umidita;
    private String intervallo_acqua;
}
