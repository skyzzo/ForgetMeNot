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
public class FertilizzanteDAO {
    
    private FertilizzanteDAO() {}
    
    private static final String INSERT_SQL="INSERT INTO FERTILIZZANTE VALUES (?, ?)";
    
    public static void insert(Fertilizzante fertilizzante) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(INSERT_SQL);
            pstmt.setString(1,fertilizzante.getNome());
            pstmt.setString(2, fertilizzante.getDescrizione());
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
    private static final String FIND_BY_NAME ="SELECT * FROM FERTILIZZANTE WHERE NOME = ?";
    public static void load(Fertilizzante fertilizzante) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(FIND_BY_NAME);
            pstmt.setString(1, fertilizzante.getNome());
            rs=pstmt.executeQuery();
            rs.next();
            fertilizzante.setDescrizione(rs.getString("DESCRIZIONE"));
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
    private static final String UPDATE_BY_NAME = "UPDATE FERTILIZZANTE SET NOME=?,DESCRIZIONE=?";
    public static void update(Fertilizzante fertilizzante) throws MyException {
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    try {
        con = ConnectionManager.getConnection();
        pstmt = con.prepareStatement(UPDATE_BY_NAME);
        pstmt.setString(1, fertilizzante.getNome());
        pstmt.setString(2, fertilizzante.getDescrizione());
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
    
    private static final String DELETE_BY_NAME="DELETE * FROM FERTILIZZANTE WHERE NOME= ?";
    public static void delete(Fertilizzante fertilizzante) throws MyException {
        Connection con=null;
        PreparedStatement pstmt=null;
        try {
            con=ConnectionManager.getConnection();
            pstmt = con.prepareStatement(DELETE_BY_NAME);
            pstmt.setString(1, fertilizzante.getNome());
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
