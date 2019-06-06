/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ramzi
 */
public class Evaluation {
    private int id;
    Enseignant prof;
    float note;
    String appreciation;
    
    public Evaluation(){
        
    }
    
    public Evaluation(Enseignant _prof, float _note, String _appreciation){
        prof = _prof;
        note = _note;
        appreciation = _appreciation;
    }

    public Enseignant getProf() {
        return prof;
    }

    public void setProf(Enseignant prof) {
        this.prof = prof;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
    
}
