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
public class ClasseDAO extends DAO<Classe>{

    public ClasseDAO() throws SQLException {
        super();
    }

    @Override
    public boolean create(Classe a) {
        return false;
    }

    @Override
    public boolean delete(Classe a) {
        return false;
    }

    @Override
    public boolean update(Classe a) {
        return false;
    }

    @Override
    public Classe find(int id) {
        Classe c = new Classe();
        
        return c;
    }

    public void init(Ecole ec) throws SQLException {
        PersonneDAO personneDao = new PersonneDAO();
        stmt = connect.createStatement();   
        Statement stmt2 = connect.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM classe WHERE classe.ecole_id LIKE "+ec.getId());
        
        
        rsetMeta = rset.getMetaData();
        
        int nbColonne = rsetMeta.getColumnCount();
        
        
        while (rset.next()) {
            String niveau="";
            ResultSet rset2 = stmt2.executeQuery("SELECT * FROM niveau WHERE niveau.id LIKE "+ rset.getString(4));
            
            while(rset2.next()){
                niveau = rset2.getString(2);
            }
           
            Classe c = new Classe(rset.getInt(1), rset.getString(2), niveau, rset.getInt(5));
            ec.ajoutClasse(c);
            personneDao.init(c);
            System.out.println("Eleve de la classe "+c.getNom()+" :");
            c.afficherEleve();
            System.out.println("Prof de la classe "+c.getNom()+" :");
            c.afficherProf();
            
        }
    }
        

}
