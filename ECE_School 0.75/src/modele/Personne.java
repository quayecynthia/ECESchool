/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ramzi
 */
public class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    
    public Personne(){
        
    }
    
    public Personne(int _id, String _nom, String _prenom){
        id = _id;
        nom = _nom;
        prenom = _prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
