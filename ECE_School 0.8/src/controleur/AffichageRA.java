/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import java.util.*;
import modele.*;

/**
 *Classe d'affichage données BDD
 * @author ramzi
 */
public class AffichageRA {
    
    /**
     * Constructeur par défaut
     */
    public AffichageRA(){
        
    }
    
    /**
     * Menu du main
     * @return choix user
     */
    public char menu() {

        String choix;
        System.out.println("1 Afficher La classe");
        System.out.println("2 Ajouter Eleve");
        System.out.println("0 Retirer Eleve");

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre choix :");
        choix = sc.next();

        return choix.charAt(0);
    }
    
    /**
     * Méthode d'affichage d'une classe
     * @param c 
     */
    
    public void afficherClasse(Classe c){
        
        ArrayList<Eleve> eleves = c.getEleves();
        ArrayList<Enseignant> profs = c.getProfs();
        
        Iterator<Eleve> it = eleves.iterator();
        Iterator<Enseignant> it2 = profs.iterator();
        
        System.out.println("Les enseignants de la classe "+ c.getNom()+" sont : ");
        while(it2.hasNext()){
            Enseignant en = it2.next();
            System.out.println("ID : "+en.getId()+" Nom : "+en.getNom()+" Prenom : "+ en.getPrenom());
        }
        
        System.out.println("Les eleves de la classe "+ c.getNom()+" sont : ");
        while(it.hasNext()){
            Eleve el = it.next();
            System.out.println("ID : "+el.getId()+" Nom : "+el.getNom()+" Prenom : "+ el.getPrenom());
        }
    }
}
