/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Categorie;
import entities.Service;
import java.sql.SQLException;
import sevices.ServiceServices;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import sevices.Reservation_service_service;

/**
 *
 * @author USER
 */
public class IGuide {

    public static void main(String[] args) {

        
     //   LocalDate d = LocalDate.of(2022, 02, 26);
       // LocalDate d1 = LocalDate.of(2022, 02, 27);
       // System.out.println(d.toString());
        
        //Service s = new Service( "a", 10, Date.valueOf(d), Date.valueOf(d1), "cible", "Lieu", Categorie.c, (float) 50.5);
           
       // Service s = new Service("a", 10, Date.valueOf(d), Date.valueOf(d1), "cible", "Lieu", Categorie.a,10.9f);
        //Service s1 = new Service("b", 5, Date.valueOf(d), Date.valueOf(d), "cible1","lieu1", Categorie.b, 20.3f);
        
       // Service s2 = new Service( "cine", 50, Date.valueOf(d), Date.valueOf(d1), "cible1", "azur city", Categorie.c, (float) 13.5);

        Reservation_service_service ss = new Reservation_service_service();

       try {
            System.out.println(ss.afficherReservationService());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 
       
    }
}
