/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;

/**
 *
 * @author daniele
 */
public class Contiene implements Serializable {

    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.utente);
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
        final Contiene other = (Contiene) obj;
        if (!Objects.equals(this.utente, other.utente)) {  // qui non si dovrebbe mettere anche pianta personale??
            return false;
        }
        return true;
    }
    
    public String getUtente() {
        return utente;
    }
    
    public String getPianta_personale() {
        return pianta_personale;
    }

    public String getPianta_default() {
        return pianta_default;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public void setPianta_default(String pianta_default) {
        this.pianta_default = pianta_default;
    }
    
    public void setPianta_personale(String pianta_personale) {
        this.pianta_personale = pianta_personale;
    }

    public Contiene(String utente, String pianta_default, String pianta_personale) {
        this.utente = utente;
        this.pianta_default = pianta_default;
        this.pianta_personale=pianta_personale;
    }
    
    public void leggiDatidaDB() throws SQLException, ClassNotFoundException, MyException {
        ContieneDAO.load(this);
    }
    
    public void inserisciDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        ContieneDAO.insert(this);
    }
    
    public void aggiornaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        ContieneDAO.update(this);
    }
    
    public void cancellaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        ContieneDAO.delete(this);
    }

    private String utente;
    private String pianta_default;
    private String pianta_personale;
    
}
