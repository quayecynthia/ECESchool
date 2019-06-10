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
public class Enseignant extends Personne{
    private String discipline;
    
    public Enseignant(){
        
    }
    
    public Enseignant(int _id, String _nom, String _prenom, String _discipline){
        super(_id, _nom, _prenom);
        discipline = _discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    
    
}
