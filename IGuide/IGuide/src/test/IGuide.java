/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import entities.Service;
import java.sql.SQLException;
import sevices.ServiceServices;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class IGuide {

    public static void main(String[] args) {

        
        LocalDate d = LocalDate.of(2022, 02, 26);
        LocalDate d1 = LocalDate.of(2022, 02, 27);
        System.out.println(d.toString());
        
        //Service s = new Service( "a", 10, Date.valueOf(d), Date.valueOf(d1), "cible", "Lieu", Categorie.c, (float) 50.5);
           
       // Service s = new Service("a", 10, Date.valueOf(d), Date.valueOf(d1), "cible", "Lieu", Categorie.a,10.9f);
        //Service s1 = new Service("b", 5, Date.valueOf(d), Date.valueOf(d), "cible1","lieu1", Categorie.b, 20.3f);
        
        //Service s2 = new Service( "cine", 50, Date.valueOf(d), Date.valueOf(d1), "cible1", "azur city", Categorie.c, (float) 13.5);
         //Service s3 = new Service( "cinema", 50, Date.valueOf(d), Date.valueOf(d1), "cible1", "azur city", Categorie.c, (float) 14.5);

        ServiceServices ss = new ServiceServices();

      /* try {
            ss.AjouterService(s3);
            System.out.println("service ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
 
         /*try {
         System.out.println(ss.AfficherService());
         } catch (SQLException ex) {
         System.out.println(ex.getMessage());
         }*/
 
         /*try {
         ss.ModifierService(s);
         System.out.println("service modifié avec succès");
         } catch (SQLException ex) {
         System.out.println(ex.getMessage());
         }*/
 /*
         try {
         System.out.println(ss.SupprimerService(s));
         System.out.println("service supprimé avec succès");
         } catch (SQLException ex) {
         System.out.println(ex.getMessage());
         }*/
        /*try {
        System.out.println(ss.TrierService("nom"));
        System.out.println("service trié avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
         
        /*try {
        System.out.println(ss.rechercherparnom("a"));
        System.out.println("liste service trouvée avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        
        
        /*try {
        System.out.println(ss.TrierServiceparprix("prix"));
        System.out.println("service trié avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
    }
}
