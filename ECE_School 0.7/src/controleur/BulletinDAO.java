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
public class BulletinDAO extends DAO<Bulletin>{

    public BulletinDAO() throws SQLException {
        super();
    }

    @Override
    public boolean create(Bulletin a, int id) throws SQLException{
        EcoleDAO ecoleDao = new EcoleDAO();
        boolean success = false;
        int count = 0;
        int id_trim = createTrimestre(a.getNumero(), a.getDebut(), a.getFin(), a.getAnnee());
        int id_inscri = 0;
        
        int id_bulletin = a.getId();
        String appreciation = a.getAppreciation();
        
        Statement stmtt = connect.createStatement();
        Statement stmt2 = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM inscription WHERE inscription.personne_id LIKE "+id);
        
        
        while(rsett.next()){
            id_inscri = rsett.getInt(1);
        }
        
        ResultSet rset2 = stmt2.executeQuery("SELECT COUNT(*) FROM bulletin WHERE trimestre_id LIKE "+id_trim +" AND "
            + " inscription_id LIKE " + id_inscri);
        
        while(rset2.next()){
            count = rset2.getInt(1);
        }
        
        if(count == 0){
            int ligne = stmtt.executeUpdate("INSERT INTO bulletin (id, trimestre_id, inscription_id, appreciation) "
                + "VALUES (NULL,"+id_trim+","+id_inscri+",'"+appreciation+ "')");
        
            if(ligne == 1)success = true;
            
            ecoleDao.init();
        }
        else System.out.println("Bulletin déja existant");

        return success;
    }
    
    public int createTrimestre(int numero, String debut, String fin, int annee) throws SQLException{
        int cpt = 0;
        int id = 0;
        
        Statement stmtt = connect.createStatement();
        Statement stmt2 = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM trimestre WHERE numero LIKE "+numero+" "
                + "AND debut LIKE '"+debut+"' AND fin LIKE '"+fin+"' AND anneeScol_id LIKE "+annee);
        
        while(rsett.next()){
            cpt++;
            id = rsett.getInt(1);
        }
        if(cpt ==0){
            int ligne = stmtt.executeUpdate("INSERT INTO trimestre(id, numero, debut, fin, anneeScol_id) "
                + "VALUES (NULL,"+numero+",'"+debut+"','"+fin+"',"+annee+ ")");
                  
            ResultSet rset2 = stmt2.executeQuery("SELECT * FROM trimestre WHERE id = MAX(id)");
            while(rset2.next()){
                id = rset2.getInt(1);
            }
        }
        else System.out.println("Trimestre déja existant");
        return id;
    }

    @Override
    public boolean delete(Bulletin a) throws SQLException {
        DetailBulletinDAO dbDao = new DetailBulletinDAO();
        boolean success = false;
        boolean found = false;
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM bulletin WHERE id LIKE "+a.getId());
        
        while(rsett.next()){
            found = true;
            System.out.println("Id bulletin : "+rsett.getInt(1));
        }
        
        if(found){
            if(a.getDetails().isEmpty())success = true;
            for(int i=0; i<a.getDetails().size(); i++){
                System.out.println("Je suis la ");
                success = dbDao.delete(a.getDetails().get(i));
            }
            if(success){
                System.out.println("Suppression detail succeed");
                int ligne = stmtt.executeUpdate("DELETE FROM bulletin WHERE id LIKE "+a.getId());
            }
        }
        else System.out.println("Erreur BDD, Bulletin inexistant");
        
        return success;
    }

    @Override
    public boolean update(Bulletin a) throws SQLException{
        boolean success = false;
        
        
        return success;
    }
    
    public boolean updateAppre(int id, String appreciation) throws SQLException{
        EcoleDAO ecDao = new EcoleDAO();
        boolean success = false;
        boolean found = false;
        
        Statement stmtt = connect.createStatement();
        ResultSet rsett = stmtt.executeQuery("SELECT * FROM bulletin WHERE id LIKE "+id);
        
        while(rsett.next()){
            found = true;
        }
        
        if(found){
            int ligne = stmtt.executeUpdate("UPDATE bulletin SET appreciation = '"+appreciation+"' WHERE id LIKE "+ id);
            
            if(ligne == 1)success = true;
            
            ecDao.init();
            
        }
        
        return success;
    }

    @Override
    public Bulletin find(int id) {
        Bulletin b = new Bulletin();
        
        return b;
    }

    public void init(Eleve e) throws SQLException {
        DetailBulletinDAO detailBulletinDao = new DetailBulletinDAO();
        
        stmt = connect.createStatement();   
        Statement stmt2 = connect.createStatement();
        
        rset = stmt.executeQuery("SELECT * FROM bulletin WHERE inscription_id IN "
                + "(SELECT inscription.id FROM inscription WHERE inscription.personne_id LIKE "+e.getId()+")");
        
        while (rset.next()) {
            
            ResultSet rset2 = stmt2.executeQuery("SELECT * FROM trimestre WHERE trimestre.id LIKE "+rset.getInt(2));
            
            while(rset2.next()){
                Bulletin b = new Bulletin(rset.getInt(1), rset.getString(4), rset2.getInt(2), rset2.getString(3), rset2.getString(4), rset2.getInt(5));
                e.AjouterBulletin(b);
                detailBulletinDao.init(b);
            }
            
            
           // Bulletin b = new Bulletin(int id, String appreciation, String debut, String fin, int numero);
        }
    }
    
}
