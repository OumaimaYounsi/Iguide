/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import sevices.IClient;

/**
 *
 * @author Oumaima
 */
public class Client {
    private int id;
    private String login, motdepasse, nom, prenom;
    private String datedenaissance;
    private String pays;
    private String ville;
  //  private Gender gender;
    private Resultattest resultattest ;
    private Statut statut;

    public Client() {
    }

 

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String ville, Resultattest resultattest, Statut statut) {
        this.login = login;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.pays = pays;
        this.ville = ville;
       // this.gender = gender;
        this.resultattest = resultattest;
        this.statut = statut;
    }



   
    

  
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

   

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public void setPays(String pays) {
        this.pays = pays;
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

    /*  public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }*/

    public Client(String nom, String prenom, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        
    }
    
    

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", login=" + login + ", motdepasse=" + motdepasse + ", nom=" + nom + ", prenom=" + prenom + ", datedenaissance=" + datedenaissance + ", pays=" + pays + ", ville=" + ville + ", resultattest=" + resultattest + ", statut=" + statut + '}';
    }
    
    

     



}
