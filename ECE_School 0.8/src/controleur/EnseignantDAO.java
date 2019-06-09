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
 *Connexion enseignant BDD
 * @author ramzi
 */
public class EnseignantDAO extends DAO<Enseignant>{

    /**
     * Constructeur par défaut
     * @throws SQLException (genre execption)
     */
           
    public EnseignantDAO() throws SQLException {
        super();
    }
    /**
     * Création enseignant
     * @param a
     * @param id //id enseignant
     * @return faux
     */

    @Override
    public boolean create(Enseignant a, int id) {
        return false;
    }
    
    /**
     * Suppression enseignant
     * @param a
     * @return faux
     */

    @Override
    public boolean delete(Enseignant a) {
        return false;
    }
    
    /**
     * Mise à jour enseignant
     * @param a
     * @return faux
     */

    @Override
    public boolean update(Enseignant a) {
        return false;
    }
    
    /**
     * Trouver enseignant dans bdd
     * @param id
     * @return enseignant trouvée
     */

    @Override
    public Enseignant find(int id) {
        Enseignant prof = new Enseignant();
        
        return prof;
    }
    
    /**
     * Initialise
     * @throws SQLException (genre execption)
     */

    public void init() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
