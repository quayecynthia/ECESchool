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
public class Classe {
    private int id;
    private ArrayList<Eleve> eleves;
    private ArrayList<Enseignant> profs;
    private String niveau;
    private String nom;
    private int annee;

    
    
    public Classe(){
        
    }
    
    public Classe(int id, String nom, String niveau, int annee){
        this.id = id;
        this.nom = nom;
        this.niveau = niveau; 
        this.annee = annee;
        eleves = new ArrayList<Eleve>();
        profs = new ArrayList<Enseignant>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    public ArrayList<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(ArrayList<Eleve> eleves) {
        this.eleves = eleves;
    }

    public ArrayList<Enseignant> getProfs() {
        return profs;
    }

    public void setProfs(ArrayList<Enseignant> profs) {
        this.profs = profs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void ajouterEleve(Eleve e){
        eleves.add(e);
    }
    
    public void ajouterProf(Enseignant e){
        profs.add(e);
    }
    
    public void retirerEleve(int id){
        int i = 0;
        
        for(Eleve el : eleves){  
            
            if(el.getId() == id){
                
            }
            else i++;
        }
        eleves.remove(i);
    }
    
    public void retirerProf(int id){
        int i = 0;
        
        for(Enseignant en : profs){
            
            if(en.getId() == id){
                
            }
            i++;
        }
        profs.remove(i);
    }
    
    public void afficherEleve(){
        for(int i=0; i<eleves.size(); i++){
            Eleve e = eleves.get(i);
            System.out.println("ID : "+e.getId()+" Nom : "+e.getNom()+" Prenom : "+e.getPrenom());
        }
    }
    
    public void afficherProf(){
        for(int i=0; i<profs.size(); i++){
            Enseignant e = profs.get(i);
            System.out.println("ID : "+e.getId()+" Nom : "+e.getNom()+" Prenom : "+e.getPrenom()+" Matiere : "+e.getDiscipline());
        }
    }
    
    /*public ArrayList<String> recupererProfs(){
        ArrayList<String> nomProfs = null;
        for(int i = 0; i<profs.size(); i++){
            nomProfs.add(profs.get(i).getNom());
        }
        return nomProfs;
    }*/
    
    
}
