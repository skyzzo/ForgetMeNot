package nuovo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PiantaPersonaleDao {
  
  private PiantaPersonale() {}
  
  private static final String INSERT_SQL="INSERT INTO PIANTAPERSONALE VALUES (?, ?, ?, ?)";
  
  public static void insert(PiantaPersonale piantaPersonale) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        
         try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(INSERT_SQL);
            pstmt.setString(1, PiantaPersonale.getNome());
            pstmt.setString(2, PiantaPersonale.getUtente().getUsername());
            pstmt.setString(3, PiantaPersonale.getFoto());
            pstmt.setString(4, PiantaPersonale.getPosizione());
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
    
     private static final String FIND_BY_NAME ="SELECT * FROM PIANTAPERSONA WHERE NOME = ?";
    public static void load(Utente utente) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(FIND_BY_NAME);
            pstmt.setString(1, utente.getNome());
            rs=pstmt.executeQuery();
            rs.next();
            piantaPersonale.SetUtente(rs.getString("qui che ci va?")); //cosa ci va in questo campo?
            piantaPersonale.setFoto(rs.getString("FOTO"));
            piantaPersonale.setPosizione(rs.getString("POSIZIONE"));
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
    
     private static final String UPDATE_BY_NAME = "UPDATE PIANTAPERSONALE SET NOME=?,UTENTE=?,FOTO=?,POSIZIONE=?";
    public static void update(PiantaPersonale piantaPersonale) throws MyException {
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
     try {
        con = ConnectionManager.getConnection();
        pstmt = con.prepareStatement(UPDATE_BY_NAME);
        pstmt.setString(1,piantaPersonale.getNome());
        pstmt.setString(2, piantaPersonale.getUtente.getUsername());
        pstmt.setString(3, piantaPersonale.getFoto());
        pstmt.setString(4, piantaPersonale.getPosizione());
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
    
    private static final String DELETE_BY_NAME="DELETE * FROM PIANTAOERSINALE WHERE NOME= ?";
    public static void delete(PiantaPersonale piantaPersonale) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
         try {
            con=ConnectionManager.getConnection();
            pstmt = con.prepareStatement(DELETE_BY_NAME);
            pstmt.setString(1, piantaPersonale.getNome());
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
