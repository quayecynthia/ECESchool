/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.*;

/**
 *
 * @author ramzi
 * @param <T>
 */
public abstract class DAO<T> {
    protected Connection connect = null;
    protected Statement stmt;
    protected ResultSet rset;
    protected ResultSetMetaData rsetMeta;
    
    public DAO() throws SQLException{
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        String urlDatabase = "jdbc:mysql://localhost/eceschool";
        String loginDatabase = "root";
        String passwordDatabase = "";

        //création d'une connexion JDBC à la base 
        connect = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
        stmt = connect.createStatement();
    }
    
    
   
  /**
  * Méthode de création d'un objet dans la BDD
  * @param a
     * @param id
  * @return boolean 
     * @throws java.sql.SQLException 
  */
  public abstract boolean create(T a, int id) throws SQLException;

  /**
  * Méthode pour effacer un objet dans la BDD
  * @param a
  * @return boolean 
  */
  public abstract boolean delete(T a) throws SQLException;

  /**
  * Méthode de mise à jour de la BDD
  * @param a
  * @return boolean
  */
  public abstract boolean update(T a) throws SQLException;

  /**
  * Méthode de recherche des informations dans la BDD
  * @param id
  * @return T la classe en question
     * @throws java.sql.SQLException
  */
  public abstract T find(int id) throws SQLException;
  
}
    
