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
public class Richiede {

    public void setFertilizzante(Fertilizzante fertilizzante) {
        this.fertilizzante = fertilizzante;
    }

    public void setPianta_default(PiantaDefault pianta_default) {
        this.pianta_default = pianta_default;
    }

    public void setTempo_fertilizzante(String tempo_fertilizzante) {
        this.tempo_fertilizzante = tempo_fertilizzante;
    }

    public Fertilizzante getFertilizzante() {
        return fertilizzante;
    }

    public PiantaDefault getPianta_default() {
        return pianta_default;
    }

    public String getTempo_fertilizzante() {
        return tempo_fertilizzante;
    }

    public Richiede(Fertilizzante fertilizzante, PiantaDefault pianta_default, String tempo_fertilizzante) {
        this.fertilizzante = fertilizzante;
        this.pianta_default = pianta_default;
        this.tempo_fertilizzante = tempo_fertilizzante;
    }
    
    private Fertilizzante fertilizzante;
    private PiantaDefault pianta_default;
    private String tempo_fertilizzante;
}
