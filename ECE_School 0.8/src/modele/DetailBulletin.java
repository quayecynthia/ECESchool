/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;

/**
 * Classe détail bulletin
 * @author ramzi
 */

public class DetailBulletin {
    private int id;
    private String appreciation;
    private String prof;
    private String discipline;
    private ArrayList<Evaluation> evals;
    /**
     * Constructeur par défaut
     */
    public DetailBulletin(){
        
    }
    /**
     * Constructeur surchargé
     * @param id //id de l'eves
     * @param appreciation //commentaire sur l'eleves
     * @param prof //prof qui fait le bulletin
     * @param discipline //matiere concernée
     */
    
    public DetailBulletin(int id, String appreciation, String prof, String discipline){
        this.id = id;
        this.appreciation = appreciation;
        this.prof = prof;
        this.discipline = discipline;
        evals = new ArrayList<>();
    }
    
    /**
     * Ajout d'une note au bulletin
     * @param eval 
     */

    
    public void ajouterEval(Evaluation eval){
        evals.add(eval);
    }
    /**
     * Retrait d'une note
     * @param eval 
     */
    
    public void retirerEval(Evaluation eval){
        evals.remove(eval);
    }

    /**
     * Getter discipline
     * @return discipline
     */
    public String getDiscipline() {
        return discipline;
    }
    
    /**
     * Setter discipline
     * @param discipline 
     */

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    /**
     * Getter prof
     * @return prof
     */
    
    public String getProf() {
        return prof;
    }

    /**
     * Setter prof
     * @param prof 
     */
    public void setProf(String prof) {
        this.prof = prof;
    }
    
    /**
     * Getter id
     * @return id
     */
    
    public int getId() {
        return id;
    }
    
    /**
     * Setteur id
     * @param id 
     */

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter appreciation
     * @return appreciation
     */

    public String getAppreciation() {
        return appreciation;
    }
    
    /**
     * Setter appreciation
     * @param appreciation 
     */

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
    
    /**
     * Getter evaluation
     * @return evals
     */

    public ArrayList<Evaluation> getEvals() {
        return evals;
    }
    
    /**
     * Setter evaluation
     * @param evals 
     */

    public void setEvals(ArrayList<Evaluation> evals) {
        this.evals = evals;
    }
    /**
     * Méthode affichage des détails du bulletin
     */
    public void afficher(){
        System.out.println("Prof : "+prof +" matiere "+discipline+"\nMoyenne : "+moyenneEval()+"\nAppréciation : "+appreciation+"\n");
    }
    /**
     * Calcul de la moyenne
     * @return la moyenne
     */
    public double moyenneEval(){
        double moyenne = 0.0;
        
        for(int i=0; i<evals.size(); i++){
            moyenne += evals.get(i).getNote();
        }
        moyenne = moyenne / evals.size();
         return moyenne;
    }
}
