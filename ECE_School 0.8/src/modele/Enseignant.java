/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe enseignnt qui hérite de personne
 * @author ramzi
 */
public class Enseignant extends Personne{
    String discipline;
    
    /**
     * Constructeur par défaut
     */
    public Enseignant(){
        
    }
    /**
     * Constructeur surchargé
     * @param _id
     * @param _nom
     * @param _prenom
     * @param _discipline 
     */
    
    public Enseignant(int _id, String _nom, String _prenom, String _discipline){
        super(_id, _nom, _prenom);
        discipline = _discipline;
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
    
    
}
