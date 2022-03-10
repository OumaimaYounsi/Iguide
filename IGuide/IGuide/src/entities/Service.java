/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.sql.Date;
/**
 *
 * @author Administrateur
 */
public class Service {
    private int idservice;
    private String nom;
    private int nombre_max;
    private Date datedebut;
    private Date datefin;
    private String cible;
    private String lieu;
    private String categorie;
    private float prix;
    private String image;
    
   public Service(){}
   
   public Service( String nom, int nombre_max, Date datedebut, Date datefin, String cible,String lieu, String categorie, float prix) {
        this.idservice = idservice;
        this.nom = nom;
        this.nombre_max = nombre_max;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.cible = cible;
        this.lieu=lieu;
        this.categorie = categorie;
        this.prix=prix;
    }
   
   public Service(int idservice, String nom, int nombre_max, Date datedebut, Date datefin, String cible, String lieu, String categorie, float prix ) {
        this.idservice = idservice;
        this.nom = nom;
        this.nombre_max = nombre_max;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.cible = cible;
        this.lieu=lieu;
        this.categorie = categorie;
        this.prix=prix;
    }

    public Service(int idservice, String nom, int nombre_max, Date datedebut, Date datefin, String cible, String lieu, String categorie, float prix, String image) {
        this.idservice = idservice;
        this.nom = nom;
        this.nombre_max = nombre_max;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.cible = cible;
        this.lieu = lieu;
        this.categorie = categorie;
        this.prix = prix;
        this.image = image;
    }

    

   

   
    public int getIdservice() {
        return idservice;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombre_max() {
        return nombre_max;
    }

    public void setNombre_max(int nombre_max) {
        this.nombre_max = nombre_max;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getCible() {
        return cible;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Service{" + "idservice=" + idservice + ", nom=" + nom + ", nombre_max=" + nombre_max + ", datedebut=" + datedebut + ", datefin=" + datefin + ", cible=" + cible + ", lieu=" + lieu + ", categorie=" + categorie + ", prix=" + prix + ", image=" + image + '}';
    }

    
    
   
    

       

    
}
