package nuovo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PiantaDefaultDAO {
    
    private PiantaDefaultDAO() {}
    
    private static final String INSERT_SQL="INSERT INTO PIANTA_DEFAULT VALUES (?, ?, ?, ?, ?, ?)";
    
    public static void insert(PiantaDefault piantaDefault) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(INSERT_SQL);
            pstmt.setString(1, piantaDefault.getNome());
            pstmt.setString(2, piantaDefault.getTipologia());
            pstmt.setString(3, piantaDefault.getColore_fioritura());
            pstmt.setString(4, piantaDefault.getDescrizione_acqua());
            pstmt.setString(5, piantaDefault.getFoto);
            pstmt.setString(6, piantaDefault.getFamiglia());
            pstmt.executeUpdate();
        }
        
        catch(ClassNotFoundException ex){
            throw new MyException("Errore: DRIVER NON TROVATO");
        }
        catch(SQLException ex){
            if(con!=null){
                try{
                    con.rollback();
                }
                catch(SQLException excep){
                    throw new MyException("Errore: "+excep.getMessage());
                }
            }
        }
        finally{
            if(con!=null){
                try{
                   pstmt.close();
                   con.close(); 
                }
                catch(SQLException ex2){
                    throw new MyException("Errore: "+ex2.getMessage());
                }
            }
        }
    }
    
     private static final String FIND_BY_NAME ="SELECT * FROM PIANTA_DEFAULT WHERE NOME = ?";
    public static void load(PiantaDefault piantaDefault) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(FIND_BY_NAME);
            pstmt.setString(1, utente.getNome());
            rs=pstmt.executeQuery();
            rs.next();
            piantaDefault.setTipologia(rs.getString("TIPOLOGIA"));
            piantaDefault.setColore_fioritura(rs.getString("COLORE_FIORITURA"));
            piantaDefault.setDescrizione_acqua(rs.getString("DESCRIZIONE_ACQUA"));
            piantaDefault.setFoto(rs.getString("FOTO"));
            piantaDefault.setFamiglia(rs.getString("FAMIGLIA"));
        }
         catch(ClassNotFoundException ex){
            throw new MyException("Errore: DRIVER NON TROVATO");
        }
        catch(SQLException ex){
            if(con!=null){
                try{
                    con.rollback();
                }
                catch(SQLException excep){
                    throw new MyException("Errore: "+excep.getMessage());
                }
            }
        }
        finally{
            if(con!=null){
                try{
                    rs.close();
                    pstmt.close();
                    con.close(); 
                }
                catch(SQLException ex2){
                    throw new MyException("Errore: "+ex2.getMessage());
                }
            }
        }
    }
    
    private static final String UPDATE_BY_NAME = "UPDATE PIANTA_DEFAULT SET NOME=?,TIPOLOGIA=?,COLORE_FIORITURA=?,DESCRIZIONE_ACQUA=?,FOTO=?,FAMIGLIA=?";
    public static void update(PiantaDefault piantaDefault) throws MyException {
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    try {
        con = ConnectionManager.getConnection();
        pstmt = con.prepareStatement(UPDATE_BY_NAME);
        pstmt.setString(1, utente.getNome());
            pstmt.setString(2, piantaDefault.getTipologia());
            pstmt.setString(3, piantaDefault.getColore_fioritura());
            pstmt.setString(4, piantaDefault.getDescrizione_acqua());
            pstmt.setString(5, piantaDefault.getFoto);
            pstmt.setString(6, piantaDefault.getFamiglia());
        pstmt.executeUpdate();
    }
    
    catch(ClassNotFoundException ex){
            throw new MyException("Errore: DRIVER NON TROVATO");
        }
        catch(SQLException ex){
            if(con!=null){
                try{
                    con.rollback();
                }
                catch(SQLException excep){
                    throw new MyException("Errore: "+excep.getMessage());
                }
            }
        }
        finally{
            if(con!=null){
                try{
                   pstmt.close();
                   con.close(); 
                }
                catch(SQLException ex2){
                    throw new MyException("Errore: "+ex2.getMessage());
                }
            }
        }
    }
    
    private static final String DELETE_BY_NAME="DELETE * FROM PIANTA_DEFAULT WHERE NOME= ?";
    public static void delete(PiantaDefault piantaDefault) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        try {
            con=ConnectionManager.getConnection();
            pstmt = con.prepareStatement(DELETE_BY_NAME);
            pstmt.setString(1, piantaDefault.getNome());
            pstmt.executeUpdate();
        }
        
        catch(ClassNotFoundException ex){
            throw new MyException("Errore: DRIVER NON TROVATO");
        }
        catch(SQLException ex){
            if(con!=null){
                try{
                    con.rollback();
                }
                catch(SQLException excep){
                    throw new MyException("Errore: "+excep.getMessage());
                }
            }
        }
        finally{
            if(con!=null){
                try{
                   pstmt.close();
                   con.close(); 
                }
                catch(SQLException ex2){
                    throw new MyException("Errore: "+ex2.getMessage());
                }
            }
        }
    }
}
