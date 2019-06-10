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
    public boolean create(DetailBulletin a, int id) throws SQLException {   //Id du bulletin
        EcoleDAO ecoleDao = new EcoleDAO();
        boolean success = false;
        String nomPrenom = "";
        int id_enseignement = 0;
        int count = 1;
        
        Statement stmtt = connect.createStatement();
        Statement stmt2 = connect.createStatement();
        
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM enseignement WHERE personne_id IN "
                + "(SELECT id FROM personne WHERE CONCAT(nom,' ',prenom) LIKE '"+a.getProf()+"' ) ");
        
        System.out.println("Je suis ici");
        while(rsett.next()){
            id_enseignement = rsett.getInt(1);
            System.out.println("Id enseigne : "+id_enseignement);
            
            ResultSet rset2 = stmt2.executeQuery("SELECT COUNT(*) FROM detailbulletin WHERE bulletin_id LIKE "+id
            + " AND enseignement_id LIKE "+id_enseignement);
            
            
            while(rset2.next()){
                System.out.println("Je suis la");
                count = rset2.getInt(1);
                System.out.println("Count : "+count);
            } 
        }
        if(count == 0){
                int ligne = stmtt.executeUpdate("INSERT INTO detailbulletin (id, bulletin_id, enseignement_id, appreciation) "
                + "VALUES (NULL,"+id+","+id_enseignement+",'"+a.getAppreciation()+ "')");
        
            if(ligne == 1)success = true;
            
            ecoleDao.init();
        }
        
        else System.out.println("Detail déja existant");
        
        
        
        return success;
    }

    @Override
    public boolean delete(DetailBulletin a) throws SQLException {
        EvaluationDAO evalDao = new EvaluationDAO();
        
        boolean success = false;
        boolean found = false;
        int id_dbu = 0;
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM detailbulletin WHERE id LIKE "+a.getId());
        
        while(rsett.next()){
            found = true;
            id_dbu = rsett.getInt(1);
        }
        
        if(found){
            if(a.getEvals().isEmpty())success = true;
            for(int i=0; i<a.getEvals().size(); i++){
                success = evalDao.delete(a.getEvals().get(i));
            }
            if(success){
                
                int ligne = stmtt.executeUpdate("DELETE FROM detailbulletin WHERE id LIKE "+a.getId());
            } 
        }
        else System.out.println("Erreur BDD, detail inexistant");
        
        return success;
    }

    @Override
    public boolean update(DetailBulletin a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean updateAppre(int id, String appreciation) throws SQLException{
        EcoleDAO ecDao = new EcoleDAO();
        boolean success = false;
        boolean found = false;
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM detailbulletin WHERE id LIKE "+id);
        
        while(rsett.next()){
            found = true;
        }
        if(found){
            int ligne = stmtt.executeUpdate("UPDATE detailbulletin SET appreciation = '"+appreciation+"' WHERE id LIKE "+ id);
            
            if(ligne == 1)success = true;
            
            ecDao.init();
        }
        else System.out.println("Erreur BDD detail inconnu");
        
        return success;
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
