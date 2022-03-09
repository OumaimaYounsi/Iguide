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
public class Proprietaire extends Utilisateur{
    private String role_pro;

    public Proprietaire(String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role, String role_pro) {
        super(nom, prenom, datedenaissance, pays, gender, statut, role);
        this.role_pro = role_pro;
    }

    public Proprietaire(String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut ,String role) {
        super(nom, prenom, datedenaissance, pays, gender, statut, role);
    }

    public Proprietaire(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut , String role) {
        super(login, motdepasse, nom, prenom, datedenaissance, pays, gender, statut ,role);
    }

    public Proprietaire(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut,  String role, String role_pro) {
        super(login, motdepasse, nom, prenom, datedenaissance, pays, gender, statut, role);
        this.role_pro = role_pro;
    }

    public Proprietaire(String login, String motdepasse) {
        super(login, motdepasse);
    }

   

    public String getRole_pro() {
        return role_pro;
    }

    public void setRole_pro(String role_pro) {
        this.role_pro = role_pro;
    }

    @Override
    public String toString() {
        return "Proprietaire{" + super.toString()+ "role_pro=" + role_pro + '}';
    }
    
    
}
