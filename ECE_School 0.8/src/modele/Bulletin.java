/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;

/**
 * Bulletin d'éleves
 * @author ramzi
 */
public class Bulletin {
    private int id;
    private String appreciation;
    private String debut;
    private String fin;
    private int numero;
    private int annee;
    ArrayList<DetailBulletin> details;
    
    /**
     * Constructeur par défaut
     */
    
    public Bulletin(){
        
    }
    
     /**
      * Constructeur surchargé
      * @param id //id eleve
      * @param appreciation //commentaire sur l'éleves
      * @param numero
      * @param debut //debut trimestre
      * @param fin //fin trimestre
      * @param annee //année scolaire
      */
    
    public Bulletin(int id, String appreciation, int numero, String debut, String fin, int annee){
        this.id = id;
        this.appreciation = appreciation;
        this.debut = debut;
        this.fin = fin;
        this.numero = numero;
        this.annee = annee;
        details = new ArrayList<>();
    }
/**
 * Getter de l'année
 * @return année scolaire
 */
    public int getAnnee() {
        return annee;
    }
/**
 * Setter de l'année
 * @param annee  // année scolaire en cours
 */
    public void setAnnee(int annee) {
        this.annee = annee;
    }
/**
 * Getter date début trimestre
 * @return date début trimestre
 */
    
    public String getDebut() {
        return debut;
    }
    /**
     * Setter date début trimestre
     * @param debut //début trimestre
     */

    public void setDebut(String debut) {
        this.debut = debut;
    }
/**
 * Getter date fin trimestre
 * @return date fin trimestre
 */
    public String getFin() {
        return fin;
    }
    /**
     * Setter date fin trimestre
     * @param fin //date fin trimestre
     */

    public void setFin(String fin) {
        this.fin = fin;
    }

    /**
     * Getter du numéro
     * @return numero
     */
    public int getNumero() {
        return numero;
    }
    /**
     * Setter du numéro
     * @param numero 
     */

    public void setNumero(int numero) {
        this.numero = numero;
    }
/**
 * Getter détail bulletin
 * @return détails
 */
    public ArrayList<DetailBulletin> getDetails() {
        return details;
    }
/**
 * Setter détails
 * @param details 
 */
    public void setDetails(ArrayList<DetailBulletin> details) {
        this.details = details;
    }
    /**
     * Methoda d'ajout détail
     * @param db 
     */

    public void ajouterDetail(DetailBulletin db){
        details.add(db);
    }
    /**
     * Méthode retrait détail
     * @param db 
     */
    
    public void retirerDetail(DetailBulletin db){
        details.remove(db);
    }
    
    /**
     * Getter id
     * @return id
     */
    
    public int getId() {
        return id;
    }
    /**
     * Setter id
     * @param id 
     */

    public void setId(int id) {
        this.id = id;
    }
/**
 * Getter Appréciation eleve
 * @return l'appreciation
 */
    public String getAppreciation() {
        return appreciation;
    }

    /**
     * Setter apréciation
     * @param appreciation 
     */
    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
/**
 * Méthode d'affichage du bulletin
 */
    
    public void afficher(){
        System.out.println("Bulletin N°"+numero);
        System.out.println("Début trimestre : "+debut+" Fin trimestre : "+fin+"\n");
        for(int i=0; i<details.size(); i++){
            details.get(i).afficher();
        }
        System.out.println("Appréciation générale : "+appreciation);
        System.out.println("Moyenne Générale : "+moyenneG()+"\n");
    }
    /*
    Méthode de calcule de la moyenne générale
    */
    public double moyenneG(){
        double moynG = 0.0;
        
        for(int i=0; i<details.size(); i++){
            moynG += details.get(i).moyenneEval();
        }
        
        moynG = moynG / details.size();
        
        return moynG;
    }
}
