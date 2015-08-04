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
public class PiantaPersonale implements Serializable {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.utente);
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
        final PiantaPersonale other = (PiantaPersonale) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.utente, other.utente)) {
            return false;
        }
        return true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public String getNome() {
        return nome;
    }

    public Utente getUtente() {
        return utente;
    }

    public String getFoto() {
        return foto;
    }

    public String getPosizione() {
        return posizione;
    }

    public PiantaPersonale(String nome, Utente utente, String foto, String posizione) {
        this.nome = nome;
        this.utente = utente;
        this.foto = foto;
        this.posizione = posizione;
    }
    
    private String nome;
    private Utente utente;
    private String foto;
    private String posizione;
    
    
    public void leggiDatidaDB() throws SQLException, ClassNotFoundException, MyException {
        PiantaPersonaleDAO.load(this);
    }
    
    public void inserisciDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        PiantaPersonaleDAO.insert(this);
    }
    
    public void aggiornaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        PiantaPersonaleDAO.update(this);
    }
    
    public void cancellaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        PiantaPersonaleDAO.delete(this);
    }
   
    
}
