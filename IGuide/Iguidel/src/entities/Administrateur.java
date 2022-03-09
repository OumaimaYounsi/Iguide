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
public class Administrateur extends Utilisateur{

    private String role_admin;

    public Administrateur() {
    }
    
    
    

    public Administrateur(String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        super(nom, prenom, datedenaissance, pays, gender, statut, role);
    }

    public Administrateur( String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role, String role_admin) {
        super(nom, prenom, datedenaissance, pays, gender, statut , role);
        this.role_admin = role_admin;
    }

    public Administrateur(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        super(login, motdepasse, nom, prenom, datedenaissance, pays, gender, statut, role);
    }

    public Administrateur( String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut,String role , String role_admin) {
        super(login, motdepasse, nom, prenom, datedenaissance, pays, gender, statut, role);
        this.role_admin = role_admin;
    }

    public Administrateur(String login, String motdepasse) {
        super(login, motdepasse);
    }

   

    public String getRole_admin() {
        return role_admin;
    }

    public void setRole_admin(String role_admin) {
        this.role_admin = role_admin;
    }

    @Override
    public String toString() {
        return "Administrateur{"+ super.toString() + "role_admin=" + role_admin + '}';
    }

    

    

  
    
    }
    
    

   
    
    
    
    
    

   
    


