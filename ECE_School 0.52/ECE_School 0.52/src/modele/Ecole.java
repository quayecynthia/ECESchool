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
public class Ecole {
    private int id;
    private String nom; 
    private ArrayList<String> disciplines;
    private ArrayList<Classe> classes;
    private ArrayList<Enseignant> profs;
    private ArrayList<Eleve> eleves;

    
    
    public Ecole(){
        
    }
    
    public Ecole(int id, String nom){
        this.nom = nom;
        this.id = id;
        disciplines = new ArrayList<>();
        classes = new ArrayList<>();
        profs = new ArrayList<>();
        eleves = new ArrayList<>();
    }

    public ArrayList<Enseignant> getProfs() {
        return profs;
    }

    public void setProfs(ArrayList<Enseignant> profs) {
        this.profs = profs;
    }

    public ArrayList<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(ArrayList<Eleve> eleves) {
        this.eleves = eleves;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<String> disciplines) {
        this.disciplines = disciplines;
    }
    
    public void ajoutDiscipline(String discipline){
        disciplines.add(discipline);
    }
    
    public void ajoutClasse(Classe c){
        classes.add(c);
    }
    
    public void retireDiscipline(String discipline){
        disciplines.remove(discipline);
    }
    
    public void afficheDisciplines(){
        for(int i=0; i<disciplines.size(); i++){
            System.out.println("Matiere "+(i+1)+" : "+disciplines.get(i));
        }
    }
    
    public void afficherClasse(){
        for(int i=0; i<classes.size(); i++){
            System.out.println("Classe n°"+(i+1)+" : "+classes.get(i).getNom());
        }
    }
    
    public void ajouterProf(Enseignant e){
        profs.add(e);
    }
    
    public void ajouterEleve(Eleve e){
        eleves.add(e);
    }
    
    public void afficherProf(){
        System.out.println("Prof: ");
        for(int i=0; i<profs.size(); i++){
            System.out.println(i+". "+profs.get(i).getNom() +" "+profs.get(i).getPrenom());
        }
    }
    
    public void afficherEleve(){
        System.out.println("Eleve : ");
        for(int i=0; i<eleves.size(); i++){
            System.out.println(i+". "+eleves.get(i).getNom() +" "+eleves.get(i).getPrenom());
        }
    }
        
}
