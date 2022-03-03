/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Administrateur
 */
public enum Categorie {
   a(1), b(2), c(3), d(4);
    
     private int Categorie;

    private Categorie (final int Categorie) {
        this.Categorie = Categorie;
    }

    public int getCategorie() {
        return Categorie;
    }
}
