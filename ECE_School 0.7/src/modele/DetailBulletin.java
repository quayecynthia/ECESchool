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
public class DetailBulletin {
    private int id;
    private String appreciation;
    private String prof;
    private String discipline;
    private ArrayList<Evaluation> evals;
    
    public DetailBulletin(){
        
    }
    
    public DetailBulletin(int id, String appreciation, String prof, String discipline){
        this.id = id;
        this.appreciation = appreciation;
        this.prof = prof;
        this.discipline = discipline;
        evals = new ArrayList<>();
    }

    public void ajouterEval(Evaluation eval){
        evals.add(eval);
    }
    
    public void retirerEval(Evaluation eval){
        evals.remove(eval);
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public ArrayList<Evaluation> getEvals() {
        return evals;
    }

    public void setEvals(ArrayList<Evaluation> evals) {
        this.evals = evals;
    }
    
    public void afficher(){
        System.out.println("Prof : "+prof +" matiere "+discipline+"\nMoyenne : "+moyenneEval()+"\nAppréciation : "+appreciation+"\n");
    }
    
    public double moyenneEval(){
        double moyenne = 0.0;
        
        for(int i=0; i<evals.size(); i++){
            moyenne += evals.get(i).getNote();
        }
        moyenne = moyenne / evals.size();
         return moyenne;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    
    
}
