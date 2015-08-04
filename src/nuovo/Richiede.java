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
public class Richiede implements Serializable {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.fertilizzante);
        hash = 53 * hash + Objects.hashCode(this.pianta_default);
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
        final Richiede other = (Richiede) obj;
        if (!Objects.equals(this.fertilizzante, other.fertilizzante)) {
            return false;
        }
        if (!Objects.equals(this.pianta_default, other.pianta_default)) {
            return false;
        }
        return true;
    }

    public void setFertilizzante(String fertilizzante) {
        this.fertilizzante = fertilizzante;
    }

    public void setPianta_default(String pianta_default) {
        this.pianta_default = pianta_default;
    }

    public void setTempo_fertilizzante(String tempo_fertilizzante) {
        this.tempo_fertilizzante = tempo_fertilizzante;
    }

    public String getFertilizzante() {
        return fertilizzante;
    }

    public String getPianta_default() {
        return pianta_default;
    }

    public String getTempo_fertilizzante() {
        return tempo_fertilizzante;
    }

    public Richiede(String fertilizzante, String pianta_default, String tempo_fertilizzante) {
        this.fertilizzante = fertilizzante;
        this.pianta_default = pianta_default;
        this.tempo_fertilizzante = tempo_fertilizzante;
    }
    
    private String fertilizzante;
    private String pianta_default;
    private String tempo_fertilizzante;
    
    public void leggiDatidaDB() throws SQLException, ClassNotFoundException, MyException {
        RichiedeDAO.load(this);
    }
    
    public void inserisciDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        RichiedeDAO.insert(this);
    }
    
    public void aggiornaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        RichiedeDAO.update(this);
    }
    
    public void cancellaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        RichiedeDAO.delete(this);
    }
}
