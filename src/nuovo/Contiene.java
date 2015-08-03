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

    public Utente getUtente() {
        return utente;
    }

    public PiantaDefault getPianta_default() {
        return pianta_default;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setPianta_default(PiantaDefault pianta_default) {
        this.pianta_default = pianta_default;
    }

    public Contiene(Utente utente, PiantaDefault pianta_default) {
        this.utente = utente;
        this.pianta_default = pianta_default;
    }

    private Utente utente;
    private PiantaDefault pianta_default;
    
    
}
