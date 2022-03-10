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
    private String nom;
    private int tarifdujour;
    private String descriptif;
    private String role_pro;
    private int experience;
    private String image;

    public Utilisateur(int id, String nom, int tarifdujour, String descriptif, String role_pro, int experience, String image) {
        this.id = id;
        this.nom = nom;
        this.tarifdujour = tarifdujour;
        this.descriptif = descriptif;
        this.role_pro = role_pro;
        this.experience = experience;
        this.image = image;
    }

    public Utilisateur(String nom, int tarifdujour, String descriptif, String role_pro, int experience, String image) {
        this.nom = nom;
        this.tarifdujour = tarifdujour;
        this.descriptif = descriptif;
        this.role_pro = role_pro;
        this.experience = experience;
        this.image = image;
    }

    

    public Utilisateur() {
      
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTarifdujour(int tarifdujour) {
        this.tarifdujour = tarifdujour;
    }

    public void setRole_pro(String role_pro) {
        this.role_pro = role_pro;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getTarifdujour() {
        return tarifdujour;
    }

    public String getRole_pro() {
        return role_pro;
    }

    public int getExperience() {
        return experience;
    }

    public String getImage() {
        return image;
 }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", tarifdujour=" + tarifdujour + ", descriptif=" + descriptif + ", role_pro=" + role_pro + ", experience=" + experience + ", image=" + image + '}';
    }
    
    
}
