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
    ArrayList<DetailBulletin> details;
    
    public Bulletin(){
        
    }
    
    public Bulletin(int id, String appreciation, int numero, String debut, String fin){
        this.id = id;
        this.appreciation = appreciation;
        this.debut = debut;
        this.fin = fin;
        this.numero = numero;
        details = new ArrayList<>();
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<DetailBulletin> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<DetailBulletin> details) {
        this.details = details;
    }

    public void ajouterDetail(DetailBulletin db){
        details.add(db);
    }
    
    public void retirerDetail(DetailBulletin db){
        details.remove(db);
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

    
    public void afficher(){
        System.out.println("Bulletin N°"+numero);
        System.out.println("Début trimestre : "+debut+" Fin trimestre : "+fin+"\n");
        for(int i=0; i<details.size(); i++){
            details.get(i).afficher();
        }
        System.out.println("Appréciation générale : "+appreciation+"\n");
    }
}
