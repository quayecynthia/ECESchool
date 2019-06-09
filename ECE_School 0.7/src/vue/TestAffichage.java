/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.*;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.*;

/**
 *
 * @author ramzi
 */
public class TestAffichage {
    private static AffichageConsole a =  new AffichageConsole();
    private static Classe c;
    private static Ecole e;
    
    public static void main(String[] args) throws ClassNotFoundException {
//        String niveau, nom;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Niveau de votre classe ?");
//        niveau = sc.next();
//        System.out.println("Nom de votre classe ?");
//        nom = sc.next();
//        
//        Classe c = new Classe(niveau, nom);
//        Eleve el = new Eleve(12, "Agougile", "Ramzi");
//        c.ajouterEleve(el);
//        a.afficherClasse(c);
//        
//        System.out.println("On va maintenant retirer l'élève");
//        c.retirerEleve(el.getId());
//        a.afficherClasse(c);

        
        try{
            EcoleDAO ecoleDao = new EcoleDAO();
            e = ecoleDao.init();
        //    Ecole e = ecoleDao.find(1);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        try {
            Classe c = new Classe(0, "4eme2", "4eme", 2019);
            ClasseDAO classeDao = new ClasseDAO();
            classeDao.create(c, e.getId());
            
            Eleve eleve = new Eleve(0, "MITSUKO", "Rita");
            Enseignant prof = new Enseignant(0, "Zoug", "Boug", "");
            PersonneDAO personneDao = new PersonneDAO();
            personneDao.create(eleve, 0);
            personneDao.create(prof, 0);
            
            BulletinDAO bulletinDao = new BulletinDAO();
            bulletinDao.createTrimestre(3, "2019-08-08", "2019-08-09", 2019);
                    
                    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    } 
}
