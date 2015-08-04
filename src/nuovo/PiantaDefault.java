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
public class PiantaDefault implements Serializable {
   
    private String nome;
    private String tipologia;
    private String colore_fioritura;
    private String descrizione_acqua;
    private String foto;
    private String famiglia;
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final PiantaDefault other = (PiantaDefault) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
     public void leggiDatidaDB() throws SQLException, ClassNotFoundException, MyException {
        PiantaDefaultDAO.load(this);
    }
    
    public void inserisciDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        PiantaDefaultDAO.insert(this);
    }
    
    public void aggiornaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        PiantaDefaultDAO.update(this);
    }
    
    public void cancellaDatisuDB() throws SQLException, ClassNotFoundException, MyException {
        PiantaDefaultDAO.delete(this);
    }
    
    public PiantaDefault(String nome, String tipologia, String colore_fioritura, String descrizione_acqua, String foto, String famiglia) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.colore_fioritura = colore_fioritura;
        this.descrizione_acqua = descrizione_acqua;
        this.foto = foto;
        this.famiglia = famiglia;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getFoto() {
        return this.foto;
    }
    
    public String getTipologia() {
        return this.tipologia;
    }
    
    public String getColore_fioritura() {
        return colore_fioritura;
    }

    public String getDescrizione_acqua() {
        return descrizione_acqua;
    }

    public String getFamiglia() {
        return famiglia;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public void setColore_fioritura(String colore_fioritura) {
        this.colore_fioritura = colore_fioritura;
    }

    public void setDescrizione_acqua(String descrizione_acqua) {
        this.descrizione_acqua = descrizione_acqua;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setFamiglia(String famiglia) {
        this.famiglia = famiglia;
    }
}
