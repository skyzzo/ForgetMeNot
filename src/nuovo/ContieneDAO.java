package nuovo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContieneDAO {
    
    private ContieneDAO() {}
    
    private static final String INSERT_SQL="INSERT INTO CONTIENE VALUES (?, ?, ?)";
    
        public static void insert(Contiene contiene) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(INSERT_SQL);
            pstmt.setString(1, contiene.getNome());
            pstmt.setString(2, contiene.getUtente());
            pstmt.setString(3, contiene.getPianta_default());
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
    
    private static final String FIND_BY_NAME ="SELECT * FROM CONTIENE WHERE NOME = ? AND UTENTE=? ";   
    public static void load(Contiene contiene) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(FIND_BY_NAME);
            pstmt.setString(1, contiene.getNome());
            pstmt.setString(2, contiene.getUtente());
            rs=pstmt.executeQuery();
            rs.next();
            contiene.setPianta_default(rs.getString("PIANTA_DEFAULT"));
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
    
     private static final String UPDATE_BY_NAME = "UPDATE CONTIENE SET NOME=?,UTENTE=?,PIANTA_DEFAULT=?";
    public static void update(Contiene contiene) throws MyException {
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    try {
        con = ConnectionManager.getConnection();
        pstmt = con.prepareStatement(UPDATE_BY_NAME);
        pstmt.setString(1, contiene.getNome());
        pstmt.setString(2, contiene.getUtente());
        pstmt.setString(3, contiene.getPianta_default());
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
    
    private static final String DELETE_BY_NAME="DELETE * FROM CONTIENE WHERE NOME= ? AND UTENTE=? "; 
    public static void delete(Contiene contiene) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
         try {
            con=ConnectionManager.getConnection();
            pstmt = con.prepareStatement(DELETE_BY_NAME);
            pstmt.setString(1, contiene.getNome());
            pstmt.setString(2, contiene.getUtente());
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
