/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;
import java.sql.SQLException;
import modele.Enseignant;

/**
 *
 * @author ramzi
 */
public class EnseignantDAO extends DAO<Enseignant>{

    public EnseignantDAO() throws SQLException {
        super();
    }

    @Override
    public boolean create(Enseignant a, int id) {
        return false;
    }

    @Override
    public boolean delete(Enseignant a) {
        return false;
    }

    @Override
    public boolean update(Enseignant a) {
        return false;
    }

    @Override
    public Enseignant find(int id) {
        Enseignant prof = new Enseignant();
        
        return prof;
    }

    public void init() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
