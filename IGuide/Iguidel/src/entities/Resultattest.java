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
public enum Resultattest {
    a(1),b(2),c(3),d(4);
    
    private int Resultattest;

    private Resultattest (final int Resultattest) {
        this.Resultattest = Resultattest;
    }

    public int getResultattest() {
        return Resultattest;
    }
}
