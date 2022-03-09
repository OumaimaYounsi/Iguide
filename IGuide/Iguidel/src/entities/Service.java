/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Service {
    private int idservice;
    private String nom;
    private int nombre_max;
    private String datedebut;
    private String datefin;
    private String cible;

    public Service(int id, String nom, int nbr_max, Date date_debut, Date date_fin, String cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
