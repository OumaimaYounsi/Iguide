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
public class Utilisateur {
    private int id;
    private String login, motdepasse, nom, prenom;
    private String datedenaissance;
    private String pays;
    private String gender;
    private Boolean statut;
    private String role;
    private String image;
    
    public Utilisateur() {
    }

    public Utilisateur(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role, String image) {
        this.login = login;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.pays = pays;
        this.gender = gender;
        this.statut = statut;
        this.role = role;
        this.image = image;
    }

    public Utilisateur(String login, String motdepasse) {
        this.login = login;
        this.motdepasse = motdepasse;
    }

    public Utilisateur( String nom, String prenom,  String image) {
        
        this.nom = nom;
        this.prenom = prenom;
       
        this.image = image;
    }
    
   

    public Utilisateur(String login, String nom, String prenom, String gender, Boolean statut, String role) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.gender = gender;
        this.statut = statut;
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public Utilisateur(String nom, String prenom, String gender, Boolean statut, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.gender = gender;
        this.statut = statut;
        this.role = role;
    }
    

    public Utilisateur(String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.pays = pays;
        this.gender = gender;
        this.statut = statut;
        this.role= role;
    }
    
    

    public Utilisateur( String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        
        this.login = login;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.pays = pays;
        this.gender = gender;
        this.statut = statut;
        this.role= role;
    }

    public Utilisateur(String nom, String prenom, String datedenaissance, String pays, String gender, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.pays = pays;
        this.gender = gender;
        this.role= role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "login=" + login + ", motdepasse=" + motdepasse + ", nom=" + nom + ", prenom=" + prenom + ", datedenaissance=" + datedenaissance + ", pays=" + pays + ", gender=" + gender + ", statut=" + statut + ", role=" + role + ", image=" + image + '}';
    }

    

    public Utilisateur(int id, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.pays = pays;
        this.gender = gender;
        this.statut = statut;
        this.role = role;
    }

   
    
    
    

    
    
}
