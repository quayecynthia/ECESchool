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
public class Bulletin {
    private int id;
    private String appreciation;
    private String debut;
    private String fin;
    private int numero;
    ArrayList<Evaluation> evals;
    
    public Bulletin(){
        
    }
    
    public Bulletin(int id, String appreciation, int numero, String debut, String fin){
        this.id = id;
        this.appreciation = appreciation;
        this.debut = debut;
        this.fin = fin;
        this.numero = numero;
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
    
    public void ajouterEval(Evaluation ev){
        evals.add(ev);
    }
    
    public void afficher(){
        System.out.println("Bulletin N°"+numero);
        System.out.println("Début trimestre : "+debut+" Fin trimestre : "+fin);
        System.out.println("Appréciation : "+appreciation);
    }
}
