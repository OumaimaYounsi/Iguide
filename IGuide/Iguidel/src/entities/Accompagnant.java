/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



/**
 *
 * @author USER
 */
public class Accompagnant extends Utilisateur{
    
    private Resultattest resultattest;
    private String descreptif;
    private int tarifdujour;
    private int experence;

    public Accompagnant(String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        super(nom, prenom, datedenaissance, pays, gender, statut, role);
    }

    public Accompagnant(Resultattest resultattest, String descreptif, int tarifdujour, int experence, int id, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        super(id, nom, prenom, datedenaissance, pays, gender, statut, role);
        this.resultattest = resultattest;
        this.descreptif = descreptif;
        this.tarifdujour = tarifdujour;
        this.experence = experence;
    }

    public Accompagnant(String nom, String prenom, String image,  int tarifdujour, int experence) {
        super(nom, prenom, image);
        
        this.tarifdujour = tarifdujour;
        this.experence = experence;
    }

    public Accompagnant() {
    }

    public Accompagnant(String login, String motdepasse) {
        super(login, motdepasse);
    }
    

    public Accompagnant( String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role, String descreptif, int tarifdujour, int experence) {
        super(nom, prenom, datedenaissance, pays, gender, statut, role);
        this.descreptif = descreptif;
        this.tarifdujour = tarifdujour;
        this.experence = experence;
    }

    public Accompagnant( String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut,String role, String descreptif, int tarifdujour, int experence) {
        super(login, motdepasse, nom, prenom, datedenaissance, pays, gender, statut, role);
        this.descreptif = descreptif;
        this.tarifdujour = tarifdujour;
        this.experence = experence;
    }

    public Accompagnant(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        super(login, motdepasse, nom, prenom, datedenaissance, pays, gender, statut, role);
    }

    public Accompagnant(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut,String role, Resultattest resultattest, String descreptif, int tarifdujour, int experence) {
        super(login, motdepasse, nom, prenom, datedenaissance, pays, gender, statut, role);
        this.resultattest = resultattest;
        this.descreptif = descreptif;
        this.tarifdujour = tarifdujour;
        this.experence = experence;
    }

   

    public Resultattest getResultattest() {
        return resultattest;
    }

    public void setResultattest(Resultattest resultattest) {
        this.resultattest = resultattest;
    }

    public String getDescreptif() {
        return descreptif;
    }

    public void setDescreptif(String descreptif) {
        this.descreptif = descreptif;
    }

    public int getTarifdujour() {
        return tarifdujour;
    }

    public void setTarifdujour(int tarifdujour) {
        this.tarifdujour = tarifdujour;
    }

    public int getExperence() {
        return experence;
    }

    public void setExperence(int experence) {
        this.experence = experence;
    }

    @Override
    public String toString() {
        return "Accompagnant{" + super.toString()+ "resultattest=" + resultattest + ", descreptif=" + descreptif + ", tarifdujour=" + tarifdujour + ", experence=" + experence + '}';
    }


   
    
    
    
    
    
}
