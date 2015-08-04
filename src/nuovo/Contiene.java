/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;

import java.util.Objects;

/**
 *
 * @author daniele
 */
public class Contiene {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.utente);
        hash = 79 * hash + Objects.hashCode(this.nome);
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
        if (!Objects.equals(this.utente, other.utente)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public String getUtente() {
        return utente;
    }
    
    public String getNome() {
        return nome;
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
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contiene(String utente, String pianta_default, String nome) {
        this.utente = utente;
        this.pianta_default = pianta_default;
        this.nome=nome;
    }

    private String utente;
    private String pianta_default;
    private String nome;
    
}
