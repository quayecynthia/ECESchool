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
public class PersonneDAO extends DAO<Personne>{

    public PersonneDAO() throws SQLException{
        super();
    }
    
    @Override
    public boolean create(Personne a, int id) throws SQLException{
        boolean success = false;
        Statement stmtt = connect.createStatement();
        ResultSet rsett;
        
        String type = "";
        
        if(a instanceof Eleve)type = "eleve";
        else if(a instanceof Enseignant)type = "Enseignant";
        String nom = a.getNom();
        String prenom = a.getPrenom();
        int count = 0;

        rsett = stmtt.executeQuery("SELECT COUNT(*) FROM personne WHERE personne.nom LIKE '"+nom+"' AND personne.prenom LIKE '"+prenom+"'");

        while(rsett.next()){
            count = rsett.getInt(1);
        }
        if(count==0){
            int ligne = stmtt.executeUpdate("INSERT INTO personne (id, nom, prenom, type)"
            + "VALUES (NULL,'"+nom+"','"+prenom+"','"+type+"')");

        if(ligne == 1)success = true;
        }
        
        return false;
    }

    @Override
    public boolean delete(Personne a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Personne a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personne find(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void init(Classe c) throws SQLException {
        BulletinDAO bulletinDao = new BulletinDAO();
        
        stmt = connect.createStatement();   
        Statement stmt2 = connect.createStatement();
        Statement stmt3 = connect.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM personne WHERE personne.id IN "
                + "(SELECT inscription.personne_id FROM inscription WHERE inscription.classe_id LIKE "+c.getId()+")");
        
        ResultSet rset2 = stmt2.executeQuery("SELECT * FROM personne WHERE personne.id IN "
                + "(SELECT enseignement.personne_id FROM enseignement WHERE enseignement.classe_id LIKE "+c.getId()+")");
        
        
        
        while (rset.next()) {
            Eleve e = new Eleve(rset.getInt(1), rset.getString(2), rset.getString(3));
            c.ajouterEleve(e);
            bulletinDao.init(e);
            e.afficherBulletin();
            System.out.println();
        }
        
        while(rset2.next()){
            String discipline = "";
            ResultSet rset3 = stmt3.executeQuery("SELECT * FROM discipline WHERE discipline.id IN "
                    + "(SELECT enseignement.discipline_id FROM enseignement WHERE enseignement.personne_id LIKE "+rset2.getInt(1)+")");
            
            while(rset3.next()){
                discipline = rset3.getString(2);
            }
            
            Enseignant en = new Enseignant(rset2.getInt(1), rset2.getString(2), rset2.getString(3), discipline);
            c.ajouterProf(en);
        }
    }
}