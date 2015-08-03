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
public class Fertilizzante {

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
    
    private String nome;
    private String descrizione;
}
