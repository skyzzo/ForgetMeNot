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
public class Origine {

    public void setPianta_default(PiantaDefault pianta_default) {
        this.pianta_default = pianta_default;
    }

    public void setLuogo(Luogo luogo) {
        this.luogo = luogo;
    }

    public PiantaDefault getPianta_default() {
        return pianta_default;
    }

    public Luogo getLuogo() {
        return luogo;
    }
    

    public Origine(PiantaDefault pianta_default, Luogo luogo) {
        this.pianta_default = pianta_default;
        this.luogo = luogo;
    }
    
    private PiantaDefault pianta_default;
    private Luogo luogo;
    
           
}
