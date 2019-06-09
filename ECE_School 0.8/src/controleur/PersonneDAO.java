/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.*;
import modele.*;

/**
 * Connexion personne BDD
 * @author ramzi
 */
public class PersonneDAO extends DAO<Personne>{

    /**
     * Constructeur par défaut
     * @throws SQLException (genre execption)
     */
          
    public PersonneDAO() throws SQLException{
        super();
    }
    
    /**
     * Création d'une personne
     * @param a
     * @param id //id personne
     * @return booleen
     * @throws SQLException 
     */
    @Override
    public boolean create(Personne a, int id) throws SQLException{
        EcoleDAO ecoleDao = new EcoleDAO();
        boolean success = false;
        int id_eleve = 0;
        Statement stmtt = connect.createStatement();
        Statement stmt2 = connect.createStatement();
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
            
            if(a instanceof Eleve){
                ResultSet rset2 = stmt2.executeQuery("SELECT MAX(id) FROM personne ");
                
                while(rset2.next()){
                    id_eleve = rset2.getInt(1); 
                    System.out.println("Id : "+id_eleve);
                }
                
                createInscri(id_eleve, id);
            }
            
            ecoleDao.init();
        }
        else System.out.println(type+" déjà existant");
        
        
        return success;
    }
    
    /**
     * Methode création enseignant
     * @param id_prof //id prof
     * @param id_classe //id classe
     * @param discipline //matiere associé
     * @return boolean
     * @throws SQLException (genre execption)
     */
    
    public boolean createEnseig(int id_prof, int id_classe, String discipline) throws SQLException{
        EcoleDAO ecDao = new EcoleDAO();
        boolean success = false;
        int id_discipline = 0;
        int count = 0;
        
        
        Statement stmtt = connect.createStatement();
        Statement stmt2 = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM discipline WHERE nom LIKE '"+discipline+"'");
        
        while(rsett.next()){
            id_discipline = rsett.getInt(1);
        }
        
        ResultSet rset2 = stmt2.executeQuery("SELECT COUNT(*) FROM enseignement WHERE enseignement.classe_id LIKE " +id_classe
                                            + " AND enseignement.personne_id LIKE "+id_prof);
        
        while(rset2.next()){
            count = rset2.getInt(1);
        }
        
        if(count==0){
            int ligne = stmtt.executeUpdate("INSERT INTO enseignement (id, classe_id, discipline_id, personne_id)"
            + "VALUES (NULL,"+id_classe+","+id_discipline+","+id_prof+")");

            if(ligne == 1)success = true;

            ecDao.init();
        }
        else{
            System.out.println("Le prof enseigne déjà dans cette classe");
        } 
        
        
        
        return success;
    }
    
    /**
     * Methode création eleve
     * @param id_eleve //id eleve
     * @param id_classe //classe associée
     * @return booléan
     * @throws SQLException (genre execption)
     */
    public boolean createInscri(int id_eleve, int id_classe) throws SQLException{
        
        EcoleDAO ecoleDao = new EcoleDAO();
        boolean success = false;
        int count = 0;
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT COUNT(*) FROM inscription WHERE inscription.classe_id LIKE " +id_classe
                                            + " AND inscription.personne_id LIKE "+id_eleve);
        
        while(rsett.next()){
            count = rsett.getInt(1);
        }
        
        if(count==0){
            int ligne = stmtt.executeUpdate("INSERT INTO inscription (id, classe_id, personne_id)"
            + "VALUES (NULL,"+id_classe+","+id_eleve+")");

        if(ligne == 1)success = true;
        
        ecoleDao.init();
        }
        else{
            System.out.println("Eleve déja inscrit");
        } 
            
            
        return success;
    }
    
    /**
     * Suppression personne
     * @param a
     * @return booleen
     * @throws SQLException  (genre execption)
     */

    @Override
    public boolean delete(Personne a) throws SQLException{
        boolean success = false;
        boolean found = false;
        String table = "";
        int id_inscri = 0;
        int id_pers = 0;
        
        if(a instanceof Eleve)table = "inscription";
        else if(a instanceof Enseignant)table = "enseignement";
        
        Statement stmtt = connect.createStatement();
        Statement stmt2 = connect.createStatement();
        ResultSet rset2 = stmt2.executeQuery("SELECT * FROM personne WHERE id LIKE "+a.getId());
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM "+table+" WHERE personne_id LIKE "+a.getId());
        
        while(rset2.next()){
            found = true;
            id_pers = rset2.getInt(1);
 
            while(rsett.next()){
                id_inscri = rsett.getInt(1);
            }
        }
        
        if(found){
            int ligne = stmtt.executeUpdate("DELETE FROM "+table+" WHERE id LIKE "+id_inscri);
            int ligne2 = stmt2.executeUpdate("DELETE FROM personne WHERE id LIKE "+id_pers);

            if(ligne2 == 1 )success = true;
        }
                
            
               
        return success;
    }

    /**
     * Mise à jour personne
     * @param a
     * @return booléen
     */
    @Override
    public boolean update(Personne a) {
        boolean success = false;
        return success;
    }
    /**
     * Mise à jour d'une inscription
     * @param a
     * @param id //id personne 
     * @return booleen
     * @throws SQLException 
     */
    
    public boolean updateInscri(Personne a, int id) throws SQLException{    //Id de la classe
        EcoleDAO ecDao = new EcoleDAO();
        boolean success = false;
        boolean found = false;
        String type = "";
        
        if(a instanceof Eleve)type = "inscription";
        else if(a instanceof Enseignant)type = "enseignement";
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM personne WHERE id LIKE "+a.getId());
        
        while(rsett.next()){
            found = true;
        }
        if(found){
            int ligne = stmtt.executeUpdate("UPDATE "+type+" SET classe_id = "+id+" WHERE personne_id LIKE "+ a.getId());
            
            if(ligne == 1)success = true;
            
            ecDao.init();
        }
        else System.out.println("Erreur BDD personne inconnue");
        return success;
    }
    
    /**
     * Trouver personne dans bdd
     * @param id //id personne
     * @return personne trouvée
     * @throws SQLException (genre execption)
     */

    @Override
    public Personne find(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Initialise personne 
     * @param c
     * @throws SQLException  (genre execption)
     */

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