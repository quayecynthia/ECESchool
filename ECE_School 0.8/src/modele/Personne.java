/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe personne dont eleve et enseignant héritent
 * @author ramzi
 */
public class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    
    /**
     * Constructeur par défaut
     */
    public Personne(){
        
    }
    
    /**
     * Constructeur surchargée
     * @param _id //id personne
     * @param _nom ///nom personne
     * @param _prenom //prenom personne
     */
    
    public Personne(int _id, String _nom, String _prenom){
        id = _id;
        nom = _nom;
        prenom = _prenom;
    }
    
    /**
     * Getter id personne
     * @return id personne
     */

    public int getId() {
        return id;
    }
    
    /**
     * Setter id personne
     * @param id personne
     */

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter nom personne
     * @return nom personne
     */

    public String getNom() {
        return nom;
    }
    
    /**
     * Setter nom personne
     * @param nom personne
     */

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Getter prenom personne
     * @return prenom personne
     */

    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter prenom personne
     * @param prenom perosonne
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
