/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;

/**
 * Classe eleve qui hérite de personne
 * @author ramzi
 */
public class Eleve extends Personne{
    private ArrayList<Bulletin> b;
    
    /**
     * Constructeur surchargé
     */
    public Eleve(){
        super();
    }
    /**
     * Constructeur par défaut
     * @param _id //id eleve
     * @param _nom //nom eleve
     * @param _prenom  // prenom elev
     */
    
    public Eleve(int _id, String _nom, String _prenom){
        super(_id, _nom, _prenom);
        b = new ArrayList<>();
    }
    
    /**
     * Getter bulletin associé à l'eleve
     * @return bulletin
     */

    public ArrayList<Bulletin> getBulletin() {
        return b;
    }
    
    /**
     * Setter bulletin
     * @param b 
     */

    public void setBulletin(ArrayList<Bulletin> b) {
        this.b = b;
    }
    /**
     * Méthode ajout bulletin
     * @param bu 
     */
    
    public void AjouterBulletin(Bulletin bu){
        b.add(bu);
    }
    
    /**
     * Méthode affichage bulletin
     */
    public void afficherBulletin(){
        System.out.println("Voici les bulletins de "+nom+" "+prenom);
        for(int i=0; i<b.size(); i++){
            b.get(i).afficher();
        }
    }

    
    
}
