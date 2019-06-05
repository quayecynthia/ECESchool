/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.*;
import java.util.*;
import modele.Ecole;

/**
 *
 * @author ramzi
 */
public class EcoleDAO extends DAO<Ecole>{

    public EcoleDAO() throws SQLException {
        super();
    }


    @Override
    public boolean create(Ecole e) {
        boolean success = false;
       
        
        return success;
    }

    @Override
    public boolean delete(Ecole a) {
        return false;
    }

    @Override
    public boolean update(Ecole a) {
        return false;
    }

    @Override
    public Ecole find(int id) throws SQLException{
        Ecole e = new Ecole();
        
        return e;
    }
    
    public void init() throws SQLException{
        
        ClasseDAO ClasseDao = new ClasseDAO();
        stmt = connect.createStatement();       //Premier statement pour créer l'école
        Statement stmt2 = connect.createStatement();        //Deuxieme statement pour les matières
        Statement stmt3 = connect.createStatement();        //Troisème statement pour les classes
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
            Ecole ec = new Ecole(Integer.parseInt(tab.get(0)), tab.get(1));
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
            
            
            
            
            
            
            
        }
        
    }
    
}
