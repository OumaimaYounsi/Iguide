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
public enum Statut {
    active(1), suspendu(2), désactive(3);
    
     private int Statut;

    private Statut (final int Statut) {
        this.Statut = Statut;
    }

    public int getStatut() {
        return Statut;
    }
}
