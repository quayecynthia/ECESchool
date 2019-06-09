/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.*;
import modele.*;

/**
 * Connexion Evaluation BDD
 * @author ramzi
 */
public class EvaluationDAO extends DAO<Evaluation>{

    /**
     * Constructeur par défaut
     * @throws SQLException  (genre execption)
     */
    public EvaluationDAO() throws SQLException {
        super();
    }
    
    /**
     * Création evaluation
     * @param a
     * @param id //id eval
     * @return booléen 
     * @throws SQLException (genre execption)
     */

    @Override
    public boolean create(Evaluation a, int id) throws SQLException{
        EcoleDAO ecoleDao = new EcoleDAO();
        
        boolean success = false;
        String appreciation = a.getAppreciation();
        float note = a.getNote();
        int Note = 0;
        int count = 1;
        
        System.out.println("note : "+note);
        System.out.println("Appreciation : "+appreciation);
        System.out.println("id : "+id);
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM evaluation");
        
        if(note / (int) note == 1){
            Note = (int) note;
            rsett = stmtt.executeQuery("SELECT COUNT(*) FROM evaluation WHERE detailbulletin_id LIKE "+id
                + " AND note LIKE "+Note+" AND appreciation LIKE '"+appreciation+"'");
        }
        else {
            rsett = stmtt.executeQuery("SELECT COUNT(*) FROM evaluation WHERE detailbulletin_id LIKE 4"
                + " AND note LIKE "+note+" AND appreciation LIKE '"+appreciation+"'");
        }
            
        
        
        while(rsett.next()){
            count = rsett.getInt(1);
            System.out.println("Count : "+rsett.getInt(1));
        }
        
        if(count == 0){
            
            int ligne = stmtt.executeUpdate("INSERT INTO evaluation (id, detailbulletin_id, note, appreciation) "
                + "VALUES (NULL,"+id+","+note+",'"+appreciation+ "')");
        
            if(ligne == 1)success = true;
            
            ecoleDao.init();
        }
        else System.out.println("Evaluation existante");
        
        return success;
    }
    
    /**
     * Suppression evalustion
     * @param a
     * @return booléen
     * @throws SQLException (genre execption)
     */

    @Override
    public boolean delete(Evaluation a) throws SQLException {
        
        EcoleDAO ecoleDao = new EcoleDAO();
        boolean success = false;
        boolean found = false;
        int id_eval = 0;
        
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM evaluation WHERE id LIKE "+a.getId());
        while(rsett.next()){
            found = true;
            id_eval = rsett.getInt(1);
            
        }
        
        if(found){
            int ligne = stmtt.executeUpdate("DELETE FROM evaluation WHERE id LIKE "+id_eval);

            if(ligne == 1 )success = true;  
        }
            
        
        return success;
    }

    /**
     * Mise à jour evaluation
     * @param a
     * @return faux
     */
    @Override
    public boolean update(Evaluation a) {
        return false;
    }
    
    /**
     *  Mise jour évaluation avec param
     * @param id //id evaluation
     * @param note //note eleve
     * @param appreciation //commentaire sur l'eleve
     * @return booléen
     * @throws SQLException 
     */
    public boolean updateEval(int id, float note, String appreciation) throws SQLException{
        EcoleDAO ecDao = new EcoleDAO();
        boolean success = false;
        boolean found = false;
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM evaluation WHERE id LIKE "+id);
        
        while(rsett.next()){
            found = true;
        }
        if(found){
            int ligne = stmtt.executeUpdate("UPDATE evaluation SET appreciation = '"+appreciation+"', note = "+note+" WHERE id LIKE "+ id);
            
            if(ligne == 1)success = true;
            
            ecDao.init();
        }
        else System.out.println("Erreur BDD evaluation inconnu");
        
        return success;
    }

    /**
     * Trouver evaluation
     * @param id
     * @return eval trouvée
     */
    @Override
    public Evaluation find(int id) {
        Evaluation eval = new Evaluation();
        
        return eval;
    }
    /**
     * Initialise evaluation
     * @param db
     * @throws SQLException (genre execption)
     */
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
