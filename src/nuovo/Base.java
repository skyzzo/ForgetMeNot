/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nuovo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author daniele
 */
public class Base {

    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost/ForgetMeNot";
    private static final String user = "postgres";
    private static final String password = "varicella";
    
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        System.out.println("-------- PostgreSQL "
		+ "JDBC Connection Testing ------------");
        
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
		+ "Include in your library path!");
            e.printStackTrace();
            return;
        }
        
        System.out.println("PostgreSQL JDBC Driver Registered!");
        
        String url="jdbc:postgresql://localhost/ForgetMeNot";
        String login="postgres";
        String password="password";
        
        Connection connection = null;
        
        try {
            connection=DriverManager.getConnection(url,login,password);
        }
        catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        }
        else {
            System.out.println("Failed to make connection!");
	}
        
        Statement stmt=connection.createStatement();
        
        String utente="CREATE TABLE Utente (" +
                      "username VARCHAR(30) PRIMARY KEY, " +
                      "email VARCHAR(40) NOT NULL, " +
                      "password VARCHAR(30) NOT NULL)";
        stmt.executeUpdate(utente);
        
        /*
        PiantaPersonale ha una foreign key con Contiene, che non è stata ancora creata quindi
        dopo aver creato Contiene faccio un alter table su PiantaPersonale
        */
        
        String pianta_personale="CREATE TABLE PiantaPersonale (" +
                                "nome VARCHAR(30)," + 
                                "utente VARCHAR(30)" +
                                    "REFERENCES Utente(username) ON DELETE CASCADE," +  //se un utente cancella l'account, anche la pianta personale viene cancellata
                                "foto VARCHAR(30)," +
                                "posizione VARCHAR(80) NOT NULL," +
                                "PRIMARY KEY (nome, utente))";
        stmt.executeUpdate(pianta_personale);
        
        /*
        Contiene ha una foreign key con PiantaDefault, che non è stata ancora creata quindi
        dopo aver creato PiantaDefault faccio un alter table su Contiene
        */
        
        String contiene="CREATE TABLE Contiene (" +
                        "nome VARCHAR(30), " +
                        "utente VARCHAR(30), " +
                        "pianta_default VARCHAR(30) NOT NULL," +
                        "PRIMARY KEY (nome, utente)," +
                        "FOREIGN KEY (nome, utente)" +
                            "REFERENCES PiantaPersonale (nome, utente) " +
                            "ON UPDATE CASCADE ON DELETE CASCADE " + 
                            "DEFERRABLE INITIALLY DEFERRED)";
                            /*
                            se un utente cancella la pianta personale anche la tupla 
                            in Contiene viene cancellata (se aggiorna il nome anche la tupla
                            in Contiene viene aggiornata. DEFERRABLE perché contiene e pianta
                            personale si referenziano a vicenda
                            */
        
        stmt.executeUpdate(contiene);
        
        String alter_table_pp="ALTER TABLE PiantaPersonale " +
                              "ADD CONSTRAINT piantapersonale_nome_utente_fkey " +
                              "FOREIGN KEY (nome, utente) " +
                              "REFERENCES Contiene (nome, utente) " +
                              "DEFERRABLE INITIALLY DEFERRED";
                              /*
                              DEFERRABLE perché pianta personale e contiene si referenziano a vicenda
                              */
        
        stmt.executeUpdate(alter_table_pp);
        
        /*
        PiantaDefault ha una foreign key con Origine, che non è stata ancora creata quindi
        dopo aver creato Origine faccio un alter table su PiantaDefault
        */
        
        String pianta_default="CREATE TABLE PiantaDefault (" +
                              "nome VARCHAR(30) PRIMARY KEY, " +
                              "tipologia VARCHAR(30) NOT NULL, " +
                              "colore_fioritura VARCHAR (20) NOT NULL, " +
                              "descrizione_acqua VARCHAR(300) NOT NULL, " +
                              "foto VARCHAR(30) NOT NULL, " +
                              "famiglia VARCHAR(30) NOT NULL)";
        
        stmt.executeUpdate(pianta_default);
        
        String alter_table_c="ALTER TABLE Contiene " +
                             "ADD CONSTRAINT contiene_piantadefault_fkey " +
                             "FOREIGN KEY (pianta_default) " +
                             "REFERENCES PiantaDefault (nome) ON UPDATE CASCADE";
                             /*
                             se devo aggiornare il nome della pianta di default
                             vengono aggiornate anche le tuple in contiene
                             */
        stmt.executeUpdate(alter_table_c);
        
        /*
        Origine ha una foreign key con Luogo, che non è stata ancora creata quindi
        dopo aver creato luogo faccio un alter table su origine
        */
        
        String origine="CREATE TABLE Origine (" +
                       "pianta_default VARCHAR(30) PRIMARY KEY, " +
                       "luogo VARCHAR(30) NOT NULL, " +
                       "FOREIGN KEY (pianta_default) " +
                       "REFERENCES PiantaDefault (nome) ON UPDATE CASCADE " +
                       "DEFERRABLE INITIALLY DEFERRED)";
                       /*
                       se devo aggiornare il nome della pianta di default
                       vengono aggiornate anche le tuple in origine
                       */
        
        stmt.executeUpdate(origine);
        
        String alter_table_pd="ALTER TABLE PiantaDefault " +
                              "ADD CONSTRAINT piantadefault_nome_fkey " + 
                              "FOREIGN KEY (nome) " +
                              "REFERENCES Origine (pianta_default) " + 
                              "DEFERRABLE INITIALLY DEFERRED";
        
        stmt.executeUpdate(alter_table_pd);
        
        String luogo="CREATE TABLE Luogo (" +
                     "nome VARCHAR(30) PRIMARY KEY, " +
                     "quantita_acqua VARCHAR(30) NOT NULL, " +
                     "intervallo_acqua VARCHAR(30) NOT NULL, " +
                     "umidita VARCHAR(30) NOT NULL)";
        
        stmt.executeUpdate(luogo);
        
        String alter_table_o="ALTER TABLE Origine " +
                             "ADD CONSTRAINT origine_luogo_fkey " +
                             "FOREIGN KEY (luogo) " +
                             "REFERENCES Luogo (nome) ON UPDATE CASCADE";
                             /*
                             se aggiorno il nome del luogo, vengono aggiornate anche
                             le tuple in origine
                             */
        
        stmt.executeUpdate(alter_table_o);
                
        String fertilizzante="CREATE TABLE Fertilizzante (" +
                             "nome VARCHAR(30) PRIMARY KEY, " +
                             "descrizione VARCHAR(300) NOT NULL)";
        
        stmt.executeUpdate(fertilizzante);
        
        String richiede="CREATE TABLE Richiede (" +
                        "fertilizzante VARCHAR(30) " +
                            "REFERENCES Fertilizzante (nome) ON UPDATE CASCADE, " +
                        "pianta_default VARCHAR(30) " +
                            "REFERENCES PiantaDefault (nome) ON UPDATE CASCADE, " +
                        "tempo_fertilizzante VARCHAR(30) NOT NULL, " +
                        "PRIMARY KEY (fertilizzante, pianta_default))";
        
        stmt.executeUpdate(richiede);  
    }
    
}
