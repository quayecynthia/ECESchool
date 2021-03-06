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
    public boolean create(Classe a, int id) throws SQLException{
        
        EcoleDAO ecoleDao = new EcoleDAO();
        boolean success = false;
        Statement stmtt = connect.createStatement();
        Statement stmt2 = connect.createStatement();
        
        String nom = a.getNom();
        int annee = a.getAnnee();
        int id_niveau = 0;
        int count = 0;
        
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM niveau WHERE nom LIKE '"+a.getNiveau()+"'");
        //ResultSet rset2 = stmt2.executeQuery("SELECT * FROM classe WHERE nom LIKE '"+a.getNom()+"'");
        ResultSet rset2 = stmt2.executeQuery("SELECT COUNT(*) FROM classe WHERE nom LIKE '"+a.getNom()+"'");
        

        while(rsett.next()){
            id_niveau = rsett.getInt(1);
            System.out.println("Id niveau : "+id_niveau);
        }
        while(rset2.next()){
            count = rset2.getInt(1);
            System.out.println("Count : "+count);
        }
        if(count == 0){
            System.out.println( "Nom "+nom+" Ecole Id : "+id+ " Id Niveau : "+id_niveau+" annee : "+annee);
            int ligne = stmtt.executeUpdate("INSERT INTO classe (id, nom, ecole_id, niveau_id, anneeScol_id) "
                + "VALUES (NULL,'"+nom+"',"+id+","+ id_niveau+","+annee+ ")");
        
            System.out.println("Ligne : "+ligne);
            if(ligne == 1)success = true;
            
            ecoleDao.init();
        }
        else System.out.println("Faux");
        
        
        return success;
    }

    @Override
    public boolean delete(Classe a) {
        return false;
        //A FAIRE 
    }

    @Override
    public boolean update(Classe a) {
        return false;
        //A FAIRE
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
