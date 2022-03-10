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
public class Adresse {
    String pays, ville;

    public Adresse(String pays, String ville) {
        this.pays = pays;
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    
}


