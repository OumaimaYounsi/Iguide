/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Service {
      private int id ;
      private String name;
      private int nbr_max ;
      private Date date_debut ;
      private Date date_fin ;
      private String cible;

    public Service(int id, String name, int nbr_max, Date date_debut, Date date_fin, String cible) {
        this.id = id;
        this.name = name;
        this.nbr_max = nbr_max;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.cible = cible;
    }

    public Service(String name, int nbr_max, Date date_debut, Date date_fin, String cible) {
        this.name = name;
        this.nbr_max = nbr_max;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.cible = cible;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNbr_max() {
        return nbr_max;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getCible() {
        return cible;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNbr_max(int nbr_max) {
        this.nbr_max = nbr_max;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }

   



    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", name=" + name + ", nbr_max=" + nbr_max + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", cible=" + cible + '}';
    }
      
      
}
