/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.*;
import java.sql.*;
import java.util.Scanner;
import modele.*;

/**
 *
 * @author ramzi
 */
public class TestAffichage {
    private static AffichageConsole a =  new AffichageConsole();
    private static Classe c;
    
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
            ecoleDao.init();
        //    Ecole e = ecoleDao.find(1);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    } 
}
