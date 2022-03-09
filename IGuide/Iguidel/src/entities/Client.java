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
 * @author USER
 */
public class Client extends Utilisateur{
    
     private Resultattest resultattest;

    public Client() {
    }

    public Client(String login, String motdepasse) {
        super(login, motdepasse);
    }
    
    
    public Client(String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role) {
        super(nom, prenom, datedenaissance, pays, gender, statut , role);
    }

    public Client( String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut, String role,Resultattest resultattest) {
        super(nom, prenom, datedenaissance, pays, gender, statut, role);
        this.resultattest = resultattest;
    }

    public Client(String login, String motdepasse, String nom, String prenom, String datedenaissance, String pays, String gender, Boolean statut,String role, Resultattest resultattest) {
        super(login, motdepasse, nom, prenom, datedenaissance, pays, gender, statut, role);
        this.resultattest = resultattest;
    }

    public Client(String nom, String prenom, String datedenaissance, String pays, String gender, String role) {
        super(nom, prenom, datedenaissance, pays, gender, role);
    }

  
    
    


    public Resultattest getResultattest() {
        return resultattest;
    }

    public void setResultattest(Resultattest resultattest) {
        this.resultattest = resultattest;
    }

    @Override
    public String toString() {
        return "Client{" + super.toString()+"resultattest=" + resultattest + '}';
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
