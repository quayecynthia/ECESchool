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
public class DetailBulletinDAO extends DAO<DetailBulletin>{

    public DetailBulletinDAO() throws SQLException{
        super();
    }
    
    @Override
    public boolean create(DetailBulletin a, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(DetailBulletin a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DetailBulletin a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetailBulletin find(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void init(Bulletin b) throws SQLException{
        EvaluationDAO evaluationDao = new EvaluationDAO();
        
        stmt = connect.createStatement();   
        Statement stmt2 = connect.createStatement();
        Statement stmt3 = connect.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM detailbulletin WHERE detailbulletin.bulletin_id LIKE "+b.getId());
        
        while (rset.next()) {
            String discipline = "";
            String prof = "";
            
            ResultSet rset2 = stmt2.executeQuery("SELECT * FROM discipline WHERE discipline.id LIKE "
                    + "(SELECT enseignement.discipline_id FROM enseignement WHERE enseignement.id LIKE "+rset.getInt(3)+")");
            
            ResultSet rset3 = stmt3.executeQuery("SELECT * FROM personne WHERE personne.id LIKE "
                    + "(SELECT enseignement.personne_id FROM enseignement WHERE enseignement.id LIKE "+rset.getInt(3)+")");
            
            while(rset2.next()){
                discipline = rset2.getString(2);
            }
            
            while(rset3.next()){
                prof = rset3.getString(2) + " " + rset3.getString(3);
            }
            
            DetailBulletin db = new DetailBulletin(rset.getInt(1), rset.getString(4), prof, discipline);
            b.ajouterDetail(db);
            evaluationDao.init(db);
        }
    }
    
}
