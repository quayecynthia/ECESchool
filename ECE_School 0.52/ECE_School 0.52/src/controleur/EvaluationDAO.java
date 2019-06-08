/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.*;
import modele.*;

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

    public void init(DetailBulletin db) throws SQLException {
        int id_prof = 0;
        
        stmt = connect.createStatement();   
        Statement stmt2 = connect.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM evaluation WHERE evaluation.detailbulletin_id LIKE "+db.getId());
        
        ResultSet rset2 = stmt2.executeQuery("SELECT * from personne WHERE personne.id LIKE "
                + "(SELECT enseignement.personne_id FROM enseignement WHERE enseignement.id LIKE "
                + "(SELECT detailbulletin.enseignement_id FROM detailbulletin WHERE detailbulletin.id LIKE "+db.getId()+"))");
        
        while(rset2.next()){
            id_prof = rset2.getInt(1);
        }

        while (rset.next()) {
            Evaluation ev = new Evaluation(rset.getInt(1), id_prof, rset.getFloat(3), rset.getString(4));
            db.ajouterEval(ev);
        }
    }
    
}
