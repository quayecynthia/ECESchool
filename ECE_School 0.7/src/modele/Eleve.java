/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;

/**
 *
 * @author ramzi
 */
public class Eleve extends Personne{
    private ArrayList<Bulletin> b;
    
    public Eleve(){
        super();
    }
    
    public Eleve(int _id, String _nom, String _prenom){
        super(_id, _nom, _prenom);
        b = new ArrayList<>();
    }

    public ArrayList<Bulletin> getBulletin() {
        return b;
    }

    public void setBulletin(ArrayList<Bulletin> b) {
        this.b = b;
    }
    
    public void AjouterBulletin(Bulletin bu){
        b.add(bu);
    }
    
    public void afficherBulletin(){
        System.out.println("Voici les bulletins de "+nom+" "+prenom);
        for(int i=0; i<b.size(); i++){
            b.get(i).afficher();
        }
    }

    
    
}
