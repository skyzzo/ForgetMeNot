/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author daniele
 */
public class RichiedeDAO {
    
    private RichiedeDAO() {}
    
    private static final String INSERT_SQL="INSERT INTO RICHIEDE VALUES (?, ?, ?)";
    
    public static void insert(Richiede richiede) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(INSERT_SQL);
            pstmt.setString(1, richiede.getFertilizzante());
            pstmt.setString(2, richiede.getPianta_default());
            pstmt.setString(3, richiede.getTempo_fertilizzante());
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
    
    //Comando SQL per l’ottenimento di una nuova istanza
    private static final String FIND_BY_NAME ="SELECT * FROM RICHIEDE WHERE FERTILIZZANTE = ? AND PIANTA_DEFAULT=?";
    public static void load(Richiede richiede) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(FIND_BY_NAME);
            pstmt.setString(1, richiede.getFertilizzante());
            pstmt.setString(2, richiede.getPianta_default());
            rs=pstmt.executeQuery();
            rs.next();
            richiede.setTempo_fertilizzante(rs.getString("TEMPO_FERTILIZZANTE"));
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
    
    //Comando SQL per l’aggiornamento di una nuova istanza
    private static final String UPDATE_BY_NAME = "UPDATE RICHIEDE SET FERTILIZZANTE=?,PIANTA_DEFAULT=?,TEMPO_FERTILIZZANTE=?";
    public static void update(Richiede richiede) throws MyException {
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    try {
        con = ConnectionManager.getConnection();
        pstmt = con.prepareStatement(UPDATE_BY_NAME);
        pstmt.setString(1, richiede.getFertilizzante());
        pstmt.setString(2, richiede.getPianta_default());
        pstmt.setString(3, richiede.getTempo_fertilizzante());
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
    
    private static final String DELETE_BY_NAME="DELETE * FROM RICHIEDE WHERE FERTILIZZANTE= ? AND PIANTA_DEFAULT=?";
    public static void delete(Richiede richiede) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        try {
            con=ConnectionManager.getConnection();
            pstmt = con.prepareStatement(DELETE_BY_NAME);
            pstmt.setString(1, richiede.getFertilizzante());
            pstmt.setString(2, richiede.getPianta_default());
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
