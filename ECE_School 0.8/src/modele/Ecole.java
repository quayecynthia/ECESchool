/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Dimension;
import java.util.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Classe école
 * @author ramzi
 */
public class Ecole {
    private int id;
    private String nom; 
    private ArrayList<String> disciplines;
    private ArrayList<Classe> classes;
    private ArrayList<Enseignant> profs;
    private ArrayList<Eleve> eleves;
    private ArrayList<String> niveau;

    
    /**
     * Constructeur par défaut
     */
    public Ecole(){
        
    }
    
    /**
     * Constructeur surchargé
     * @param id //id de l'école
     * @param nom //nom de l'école
     */
    
    public Ecole(int id, String nom){
        this.nom = nom;
        this.id = id;
        disciplines = new ArrayList<>();
        classes = new ArrayList<>();
        profs = new ArrayList<>();
        eleves = new ArrayList<>();
        niveau = new ArrayList<>();
    }
    
    /**
     * Getter niveau
     * @return niveau
     */

    public ArrayList<String> getNiveau() {
        return niveau;
    }

    /**
     * Setter niveau
     * @param niveau 
     */
    public void setNiveau(ArrayList<String> niveau) {
        this.niveau = niveau;
    }
    
    /**
     * Getter liste professeurs
     * @return liste professeurs
     */

    
    public ArrayList<Enseignant> getProfs() {
        return profs;
    }

    /**
     * Setter liste professeurs
     * @param profs 
     */
    public void setProfs(ArrayList<Enseignant> profs) {
        this.profs = profs;
    }
    /**
     * Getter liste eleves
     * @return liste eleves
     */

    public ArrayList<Eleve> getEleves() {
        return eleves;
    }
    
    /**
     * Setter liste eleves
     * @param eleves 
     */

    public void setEleves(ArrayList<Eleve> eleves) {
        this.eleves = eleves;
    }
/**
 * Getter id de l'école
 * @return id de l'école
 */
    
    public int getId() {
        return id;
    }
    
    /**
     * Setter id de l'école
     * @param id 
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter liste classe de l'école
     * @return liste classe de l'école
     */
    public ArrayList<Classe> getClasses() {
        return classes;
    }
    
    /**
     * Setter liste classe de l'école
     * @param classes 
     */

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }
    
    /**
     * Getter nom de l'ecole
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter nom de l'école
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Getter liste disciplines
     * @return liste disciplines
     */

    public ArrayList<String> getDisciplines() {
        return disciplines;
    }
    /**
     * Setter liste disciplines
     * @param disciplines 
     */

    public void setDisciplines(ArrayList<String> disciplines) {
        this.disciplines = disciplines;
    }
    
    /**
     * Méthode ajout discipline
     * @param discipline 
     */
    public void ajoutDiscipline(String discipline){
        disciplines.add(discipline);
    }
    /**
     * Méthode ajout d'une classe
     * @param c 
     */
    public void ajoutClasse(Classe c){
        classes.add(c);
    }
    
    /**
     * Méthode retrait discipline
     * @param discipline 
     */
    
    public void retireDiscipline(String discipline){
        disciplines.remove(discipline);
    }
    
    /**
     * Méthode de display des disciplines
     */
    
    public void afficheDisciplines(){
        for(int i=0; i<disciplines.size(); i++){
            System.out.println("Matiere "+(i+1)+" : "+disciplines.get(i));
        }
    }
    
    /**
     * Méthode display classe
     */
    
    public void afficherClasse(){
        for(int i=0; i<classes.size(); i++){
            System.out.println("Classe n°"+(i+1)+" : "+classes.get(i).getNom());
        }
    }
    
    /**
     * Méthode ajout prof
     * @param e 
     */
    
    public void ajouterProf(Enseignant e){
        profs.add(e);
    }
    
    /**
     * Méthode ajout eleve
     * @param e 
     */
    
    public void ajouterEleve(Eleve e){
        eleves.add(e);
    }
    
    /**
     * Méthode ajout niveau
     * @param niveau 
     */
    
    public void ajouterNiveau(String niveau){
        this.niveau.add(niveau);
    }
    
    /**
     * Méthode display liste de professeurs
     */
    
    public void afficherProf(){
        System.out.println("Prof: ");
        for(int i=0; i<profs.size(); i++){
            System.out.println(i+". "+profs.get(i).getNom() +" "+profs.get(i).getPrenom());
        }
    }
    
    /**
     * Methode display liste eleve
     */
    
    public void afficherEleve(){
        System.out.println("Eleve : ");
        for(int i=0; i<eleves.size(); i++){
            System.out.println(i+". "+eleves.get(i).getNom() +" "+eleves.get(i).getPrenom());
        }
    }
    
    /**
     * Methode affichage niveau
     */
    public void afficherNiveau(){
        System.out.println("Les Niveaux disponibles dans l'école sont : ");
        for(int i=0; i<niveau.size(); i++){
            System.out.println(i+". "+niveau.get(i));
        }
    }
        
    /**
     * Recuperation données camembert
     * @return données camembert
     */
     public DefaultPieDataset creerDataset(){
       
        Classe c = new Classe() ;
        DefaultPieDataset dataset = new DefaultPieDataset();
        
    for(int i = 0 ; i <  classes.size() ; i++)
    {
        c = classes.get(i) ;
        String nom = "classe " + c.getNom(); 
        
        dataset.setValue(nom , c.getEleves().size());
    }
    return dataset ; 
    }
     /**
      * Display du camembert
      */
    
    public void afficherCamembert(){
        
        DefaultPieDataset dataset = creerDataset() ;

        JFreeChart chart = ChartFactory.createPieChart3D("Nb d'éleves par classe",dataset,true, true, false );
// create and display a frame...
       ChartFrame frame = new ChartFrame("Diagramme", chart);
       frame.pack();
       frame.setVisible(true);
    }
    /**
     * Recuperation données histogramme
     * @return données histogramme
     */
    
    public DefaultCategoryDataset creerDataset1(){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String discipline = "" ; 
        HashMap <String, Integer> asso;
        
        asso = new HashMap <>();
        for(int i = 0 ; i <  disciplines.size() ; i++){
            int cpt=0 ;
            discipline = disciplines.get(i); 
            for(int g = 0 ; g < profs.size() ; g++){
                if(profs.get(g).getDiscipline().equals(discipline)){
                    cpt++ ; 
                }
            }
               
        asso.put(discipline, new Integer(cpt)) ; 
      
        }
     for(Map.Entry<String, Integer> entry : asso.entrySet()){
         System.out.println("Discipline : " + entry.getKey() + " Nb : " + entry.getValue()) ; 
         dataset.addValue(entry.getValue(), entry.getKey(), "");
     }
            
      return dataset ; 
    }

  /**
   * Affichage histogramme
   * @return histogramme
   */

public ChartPanel afficherHistogram(){
        
         DefaultCategoryDataset dataset = creerDataset1() ;
         JFreeChart chart = ChartFactory.createBarChart(
        "Nb de profs/matière", // chart title
        "Matière", // domain axis label
        "Nb de profs", // range axis label
        dataset, // data
        PlotOrientation.VERTICAL, // orientation
        true, // include legend
        true, // tooltips?
        false // URLs?
        );
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(500, 270));
//        setContentPane(chartPanel);

        return chartPanel;
    }
 
    
}
