/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.*;
import modele.Eleve;

/**
 *
 * @author ramzi
 */
public class EleveDAO extends DAO<Eleve>{

    public EleveDAO() throws SQLException {
        super();
    }

    @Override
    public boolean create(Eleve a, int id) {
        return false;
    }

    @Override
    public boolean delete(Eleve a) {
        return false;
    }

    @Override
    public boolean update(Eleve a) {
        return false;
    }

    @Override
    public Eleve find(int id) {
        
        return new Eleve();
    }

    public void init() throws SQLException {
        stmt = connect.createStatement();       //Premier statement pour créer l'école
        Statement stmt2 = connect.createStatement();        //Deuxieme statement pour les matières
        rset = stmt.executeQuery("SELECT * FROM personne");
        
        rsetMeta = rset.getMetaData();
        
        int nbColonne = rsetMeta.getColumnCount();
        
        
    }
    
}
