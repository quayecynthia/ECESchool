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
    private ArrayList<Evaluation> evals;
    
    public DetailBulletin(){
        
    }
    
    public DetailBulletin(int id, String appreciation){
        this.id = id;
        this.appreciation = appreciation;
    }

    public void ajouterEval(Evaluation eval){
        evals.add(eval);
    }
    
    public void retirerEval(Evaluation eval){
        evals.remove(eval);
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
    
    
}
