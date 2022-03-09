/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author USER
 */
public class Administrateur {

    public static void add(Administrateur u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int id;
    private String login, motdepasse, nom, prenom;
    private String datedenaissance;
    private String pays;
    private String ville;
    private Statut statut;
    private String role;

    public Administrateur( String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String ville, Statut statut, String role) {
        
        this.login = login;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.pays = pays;
        this.ville = ville;
        this.statut = statut;
        this.role = role;
    }

    public Administrateur() {
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

    

    

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Administrateur{" + "id=" + id + ", login=" + login + ", motdepasse=" + motdepasse + ", nom=" + nom + ", prenom=" + prenom + ", datedenaissance=" + datedenaissance + ", pays=" + pays + ", ville=" + ville + ", statut=" + statut + ", role=" + role + '}';
    }
    
    
    
    
}
