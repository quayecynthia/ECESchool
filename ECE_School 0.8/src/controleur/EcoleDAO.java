/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.*;
import java.util.*;
import modele.*;

/**
 *Connexion école BDD
 * @author ramzi
 */
public class EcoleDAO extends DAO<Ecole>{

    public EcoleDAO() throws SQLException {
        super();
    }
/**
 * Création école
 * @param e
 * @param id
 * @return booleen
 */

    @Override
    public boolean create(Ecole e, int id){
        boolean success = false;
        
        
        
        return success;
    }
    
    /**
     * Création discipline
     * @param nom //nom de la discipline
     * @return boolean
     * @throws SQLException 
     */
    
    public boolean createDis(String nom) throws SQLException{
        EcoleDAO ecDao = new EcoleDAO();
        boolean success = false;
        boolean found = false;
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM discipline WHERE nom LIKE '"+nom+"'");
        
        while(rsett.next()){
            found = true;
        }
        if(!found){
            int ligne = stmtt.executeUpdate("INSERT INTO discipline (id, nom) VALUES (NULL, '"+nom+"')");
            
            if(ligne == 1)success = true;
            
            ecDao.init();
        }
        else System.out.println("La discipline existe déjà");
        
        return success;
    }
    
    /**
     * Suppression école de la BDD
     * @param a
     * @return faux
     */

    @Override
    public boolean delete(Ecole a) {
        return false;
    }

    /*$
    Mise à jour école
    */
    @Override
    public boolean update(Ecole a) {
        return false;
    }
    /**
     * Trouver ecole 
     * @param id
     * @return école trouvée
     * @throws SQLException 
     */

    @Override
    public Ecole find(int id) throws SQLException{
        Ecole e = new Ecole();
        
        return e;
    }
    
    /**
     * Initialisation école
     * @return l"cole
     * @throws SQLException 
     */
    public Ecole init() throws SQLException{
        
        Ecole ec = new Ecole();
        ClasseDAO ClasseDao = new ClasseDAO();
        stmt = connect.createStatement();       //Premier statement pour créer l'école
        Statement stmt2 = connect.createStatement();        //Deuxieme statement pour les matières
        Statement stmt3 = connect.createStatement();        //Troisème statement pour les eleves et profs
        Statement stmt4 = connect.createStatement();
        Statement stmt5 = connect.createStatement();
        rset = stmt.executeQuery("SELECT * FROM ecole");
        
        rsetMeta = rset.getMetaData();
        
        int nbColonne = rsetMeta.getColumnCount();
        
        while (rset.next()) {
            ArrayList<String> tab = new ArrayList<>();
            
            String champs = "";
            champs = rset.getString(1);
            tab.add(rset.getString(1));
            
            for(int i=1; i<nbColonne; i++){
                champs = champs + "," + rset.getString(i + 1);
                tab.add(rset.getString(i+1));
            }
            System.out.println(champs);
            ec = new Ecole(Integer.parseInt(tab.get(0)), tab.get(1));
            System.out.println("Id de l'école : "+ec.getId()+" Nom de l'école : "+ec.getNom());
            
            ResultSet rset2 = stmt2.executeQuery("SELECT nom FROM `discipline` WHERE discipline.id IN "
                + "(SELECT enseignement.discipline_id FROM enseignement WHERE enseignement.classe_id IN "
                + "(SELECT classe.id FROM classe WHERE classe.ecole_id LIKE "+ ec.getId()+ " ) )");
            
            while(rset2.next()){
                ec.ajoutDiscipline(rset2.getString(1));
            }
            ec.afficheDisciplines();
            System.out.println();
            
            ClasseDao.init(ec);
            
            ResultSet rset3 = stmt3.executeQuery("SELECT * FROM personne");
            
            
            while(rset3.next()){
                String discipline = "Pas encore de cours";
                if("Enseignant".equals(rset3.getString(4))){
                    ResultSet rset4 = stmt4.executeQuery("SELECT * FROM discipline WHERE discipline.id IN "
                    + "(SELECT enseignement.discipline_id FROM enseignement WHERE enseignement.personne_id LIKE "+rset3.getInt(1)+")");
                    
                    while(rset4.next()){
                        discipline = rset4.getString(2);
                    }
                    ec.ajouterProf(new Enseignant(rset3.getInt(1), rset3.getString(2), rset3.getString(3), discipline));
                }
                else if("eleve".equals(rset3.getString(4))){
                    ec.ajouterEleve(new Eleve(rset3.getInt(1), rset3.getString(2), rset3.getString(3)));
                }
            }
            
            ec.afficherProf();
            ec.afficherEleve();
            
            ResultSet rset5 = stmt5.executeQuery("SELECT * FROM niveau");
            
            while(rset5.next()){
                ec.ajouterNiveau(rset5.getString(2));
            }
            ec.afficherNiveau();
    
        }
        return ec;
    }
    
}
