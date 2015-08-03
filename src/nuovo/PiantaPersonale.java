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
public class PiantaPersonale {

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
    
    
    
   
    
}
