/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Dimension;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.util.HashMap;
import java.util.Map.Entry;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
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

    
    
    public Ecole(){
        
    }
    
    public Ecole(int id, String nom){
        this.nom = nom;
        this.id = id;
        disciplines = new ArrayList<>();
        classes = new ArrayList<>();
        profs = new ArrayList<>();
        eleves = new ArrayList<>();
        niveau = new ArrayList<>();
    }

    public ArrayList<String> getNiveau() {
        return niveau;
    }

    public void setNiveau(ArrayList<String> niveau) {
        this.niveau = niveau;
    }

    
    public ArrayList<Enseignant> getProfs() {
        return profs;
    }

    public void setProfs(ArrayList<Enseignant> profs) {
        this.profs = profs;
    }

    public ArrayList<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(ArrayList<Eleve> eleves) {
        this.eleves = eleves;
    }
    
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
    
    public void afficherCamembert(){
        
        DefaultPieDataset dataset = creerDataset() ;

        JFreeChart chart = ChartFactory.createPieChart3D("Nb d'éleves par classe",dataset,true, true, false );
// create and display a frame...
       ChartFrame frame = new ChartFrame("Diagramme", chart);
       frame.pack();
       frame.setVisible(true);
    }
    
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
     for(Entry<String, Integer> entry : asso.entrySet()){
         System.out.println("Discipline : " + entry.getKey() + " Nb : " + entry.getValue()) ; 
         dataset.addValue(entry.getValue(), entry.getKey(), "");
     }
            
      return dataset ; 
    }

  

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
 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<String> disciplines) {
        this.disciplines = disciplines;
    }
    
    public void ajoutDiscipline(String discipline){
        disciplines.add(discipline);
    }
    
    public void ajoutClasse(Classe c){
        classes.add(c);
    }
    
    public void retireDiscipline(String discipline){
        disciplines.remove(discipline);
    }
    
    public void afficheDisciplines(){
        for(int i=0; i<disciplines.size(); i++){
            System.out.println("Matiere "+(i+1)+" : "+disciplines.get(i));
        }
    }
    
    public void afficherClasse(){
        for(int i=0; i<classes.size(); i++){
            System.out.println("Classe n°"+(i+1)+" : "+classes.get(i).getNom());
        }
    }
    
    public void ajouterProf(Enseignant e){
        profs.add(e);
    }
    
    public void ajouterEleve(Eleve e){
        eleves.add(e);
    }
    
    public void ajouterNiveau(String niveau){
        this.niveau.add(niveau);
    }
    
    public void afficherProf(){
        System.out.println("Prof: ");
        for(int i=0; i<profs.size(); i++){
            System.out.println(i+". "+profs.get(i).getNom() +" "+profs.get(i).getPrenom());
        }
    }
    
    public void afficherEleve(){
        System.out.println("Eleve : ");
        for(int i=0; i<eleves.size(); i++){
            System.out.println(i+". "+eleves.get(i).getNom() +" "+eleves.get(i).getPrenom());
        }
    }
    
    public void afficherNiveau(){
        System.out.println("Les Niveaux disponibles dans l'école sont : ");
        for(int i=0; i<niveau.size(); i++){
            System.out.println(i+". "+niveau.get(i));
        }
    }

//    private void setContentPane(ChartPanel chartPanel) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
        
}
