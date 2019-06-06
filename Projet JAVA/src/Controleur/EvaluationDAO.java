/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;
import java.sql.SQLException;
import modele.Evaluation;

/**
 *
 * @author ramzi
 */
public class EvaluationDAO extends DAO<Evaluation>{

    public EvaluationDAO() throws SQLException {
        super();
    }

    @Override
    public boolean create(Evaluation a) {
        return false;
    }

    @Override
    public boolean delete(Evaluation a) {
        return false;
    }

    @Override
    public boolean update(Evaluation a) {
        return false;
    }

    @Override
    public Evaluation find(int id) {
        Evaluation eval = new Evaluation();
        
        return eval;
    }

    public void init() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
