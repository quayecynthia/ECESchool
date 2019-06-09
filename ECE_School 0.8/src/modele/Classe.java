/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;

/**
 * Classe d'éleves
 * @author ramzi
 */
public class Classe {
    private int id;
    private ArrayList<Eleve> eleves;
    private ArrayList<Enseignant> profs;
    private String niveau;
    private String nom;
    private int annee;

    /**
     * Constructeur par défaut
     */
    
    public Classe(){
        
    }
    
    /**
     * Constructeur surchargée
     * @param id //id classe
     * @param nom // nom classe
     * @param niveau // niveau classe
     * @param annee //annee en cours
     */
    
    public Classe(int id, String nom, String niveau, int annee){
        this.id = id;
        this.nom = nom;
        this.niveau = niveau; 
        this.annee = annee;
        eleves = new ArrayList<Eleve>();
        profs = new ArrayList<Enseignant>();
    }
    
    /**
     * Getter id classe
     * @return id
     */

    public int getId() {
        return id;
    }
    /**
     * Setter id classe
     * @param id 
     */

    /**
     * Setter id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter année en cours
     * @return année
     */

    public int getAnnee() {
        return annee;
    }

    /**
     * Setter id
     * @param annee 
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    /**
     * Getter niveau
     * @return niveau
     */

    public String getNiveau() {
        return niveau;
    }
    
    /**
     * Setter niveau
     * @param niveau 
     */

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    /**
     * Getter eleves
     * @return eleves
     */
    
    public ArrayList<Eleve> getEleves() {
        return eleves;
    }

    /**
     * Setter eleves
     * @param eleves 
     */
    public void setEleves(ArrayList<Eleve> eleves) {
        this.eleves = eleves;
    }

    /**
     * Getter professeurs
     * @return profs
     */
    public ArrayList<Enseignant> getProfs() {
        return profs;
    }

    public void setProfs(ArrayList<Enseignant> profs) {
        this.profs = profs;
    }
    
    /**
     * Getter nom
     * @return nom
     */

    public String getNom() {
        return nom;
    }
    /**
     * Setter nom
     * @param nom 
     */

    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Methode ajout eleve à la classe
     * @param e 
     */
    
    public void ajouterEleve(Eleve e){
        eleves.add(e);
    }
    /**
     * Methode ajout prof à la classe
     * @param e 
     */
    
    public void ajouterProf(Enseignant e){
        profs.add(e);
    }
    
    /**
     * Methode retrait eleve à la classe
     * @param id 
     */
    
    public void retirerEleve(int id){
        int i = 0;
        
        for(Eleve el : eleves){  
            
            if(el.getId() == id){
                
            }
            else i++;
        }
        eleves.remove(i);
    }
    /**
     * Methode retrait prof de la classe
     * @param id 
     */
    
    public void retirerProf(int id){
        int i = 0;
        
        for(Enseignant en : profs){
            
            if(en.getId() == id){
                
            }
            i++;
        }
        profs.remove(i);
    }
    /**
     * Méthode de display des eleves d'une classe
     */
    public void afficherEleve(){
        for(int i=0; i<eleves.size(); i++){
            Eleve e = eleves.get(i);
            System.out.println("ID : "+e.getId()+" Nom : "+e.getNom()+" Prenom : "+e.getPrenom());
        }
    }
    /**
     * Méthode de display des professeurs d'une classe
     */
    public void afficherProf(){
        for(int i=0; i<profs.size(); i++){
            Enseignant e = profs.get(i);
            System.out.println("ID : "+e.getId()+" Nom : "+e.getNom()+" Prenom : "+e.getPrenom()+" Matiere : "+e.getDiscipline());
        }
    }
    
    
}
