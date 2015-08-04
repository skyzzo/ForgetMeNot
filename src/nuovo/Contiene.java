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
public class Contiene {

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

    private String utente;
    private String pianta_default;
    private String pianta_personale;
    
}
