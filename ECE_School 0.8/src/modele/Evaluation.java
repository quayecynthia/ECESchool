/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe évaluation
 * @author ramzi
 */
public class Evaluation {
    private int id;
    private int id_prof;
    float note;
    String appreciation;
    
    /**
     * Constructeur par défaut
     */
    
    public Evaluation(){
        
    }
    /**
     * Constructeur surchargé
     * @param id //id de l'evaluation
     * @param id_prof //id du prof
     * @param note //note mise par le prof
     * @param appreciation //appréciation donnée par le prof
     */
    
    public Evaluation(int id, int id_prof, float note, String appreciation){
        this.id = id;
        this.id_prof = id_prof;
        this.note = note;
        this.appreciation = appreciation;
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
     * Getter id du prof
     * @return id du prof
     */
    public int getId_prof() {
        return id_prof;
    }
    
    /**
     * Setter id du prof
     * @param id_prof 
     */

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    /**
     * Getter de la note
     * @return note
     */
    
    public float getNote() {
        return note;
    }
    /**
     * Setter note
     * @param note 
     */

    public void setNote(float note) {
        this.note = note;
    }
    /**
     * Getter appréciation
     * @return appréciation
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
    
}
