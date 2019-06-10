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
            personneDao.create(eleve, 10);
            personneDao.create(prof, 0);
            prof.setId(23);
            personneDao.delete(prof);
            
            BulletinDAO bulletinDao = new BulletinDAO();
            Bulletin bu = new Bulletin(0, "Bulletin fort marrant", 3, "2019-01-01", "2019-01-02", 2019);
            bulletinDao.create(bu, 3);
            
//            

            DetailBulletinDAO detailBulletinDao = new DetailBulletinDAO();
            DetailBulletin db = new DetailBulletin(0, "TEERRIBLE", "GOUJAT Loic", "");
            detailBulletinDao.create(db, 3);
            
            EvaluationDAO evaluationDao = new EvaluationDAO();
            Evaluation eval = new Evaluation(0, 0, 15.0f, "Khapta");
            evaluationDao.create(eval, 16);
            eval.setId(31);
//            evaluationDao.delete(eval);
            
            db.setId(16);
            db.ajouterEval(eval);
            detailBulletinDao.delete(db);

            Enseignant ens = new Enseignant(1, "", "", "");
            Eleve el = new Eleve(24, "", "");
            personneDao.updateInscri(ens, 2);
            personneDao.updateInscri(el, 4);
            personneDao.createEnseig(5, 4, "Francais");
            
            bulletinDao.updateAppre(1, "Pas que les fesses hihi");
            detailBulletinDao.updateAppre(16, "Pas si claquée au sol");
            evaluationDao.updateEval(33, 1.25f, "Gros échec !");
            
            EcoleDAO ecDao = new EcoleDAO();
            ecDao.createDis("Technologie");
            
            for(int i=0; i<e.getDisciplines().size(); i++){
                System.out.println("Matiere : "+e.getDisciplines().get(i));
            }
//            bu.setId(5);
//            bu.ajouterDetail(db);
//            bulletinDao.delete(bu);
            
            
                    
                    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    } 
}
