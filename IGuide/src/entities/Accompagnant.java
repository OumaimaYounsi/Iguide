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
public class Accompagnant{
     private int id;
    private String login, motdepasse, nom, prenom;
    private String datedenaissance;
    private String pays;
    private String ville;
    private Resultattest resultattest ;
    private Statut statut;
    private String descreptif;
    private int tarifdujour;
    private int experence;

    public Accompagnant(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String ville, Resultattest resultattest, Statut statut, String descreptif, int tarifdujour, int experence) {
        
        this.login = login;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.pays = pays;
        this.ville = ville;
        this.resultattest = resultattest;
        this.statut = statut;
        this.descreptif = descreptif;
        this.tarifdujour = tarifdujour;
        this.experence = experence;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Resultattest getResultattest() {
        return resultattest;
    }

    public void setResultattest(Resultattest resultattest) {
        this.resultattest = resultattest;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
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

    
    

    
}
