/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Reservation_service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author user
 */
public class Reservation_service_service implements IReservation_service {

    Connection connexion;
    Statement stm;

    public Reservation_service_service() {
        connexion = MyDB.getInstance().getConnexion();
    }

    public void ajouterReservationService(Reservation_service r) throws SQLException {
        String req = "INSERT INTO reservation_pack ( `date_service`) VALUES ( '" + r.getDate_service() + "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    public void modifierReservationService(Reservation_service r) throws SQLException {
        String req = "UPDATE reservation_service SET date_service='" + r.getDate_service() + "') ";
        try {
            stm = connexion.createStatement();
            stm.executeUpdate(req);
            System.out.println("reservation modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    @Override
    public void supprimerReservationService(int id_res_service) throws SQLException {

        String req = "DELETE FROM reservation_pack WHERE id_res_service=" + id_res_service;
        stm = connexion.createStatement();
        stm.executeUpdate(req);

        System.out.println(req);
        Statement stm;

        try {
            stm = connexion.createStatement();
            stm.executeUpdate(req);
            System.out.println("Done");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List afficherReservationService() throws SQLException {
        List<Reservation_service> reservations_service = new ArrayList<>();
        String req = "select * from reservation_service";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Reservation_service r = new Reservation_service(rst.getInt("id_res_service"),
                    rst.getDate("date_service"),
                    rst.getInt("id_client"),
                    rst.getInt("id_accomp"),
                    rst.getInt("id_service"));
            reservations_service.add(r);
        }
        return reservations_service;
    }

    @Override
    public void ajouterReservationService(Object r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierReservationService(Object r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean rechercherpaId(int id_res_service) {
        boolean test = false;
        String req = "SELECT * from reservation_service where id_res_service='" + id_res_service + "'";

        try {

            ResultSet stp = stm.executeQuery(req);
            stp.last();
            if (stp.getRow() != 0) {
                test = true;
                System.out.println(test + "\n réservation trouver");
            } else {
                test = false;
                System.out.println(test + "\n réservation non trouver");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return test;
    }
    
    
    public List<Reservation_service> FindEventByIdClient(int id_client) throws SQLException {
        List<Reservation_service> list1 = new ArrayList<>();
        ResultSet res = stm.executeQuery("select * from reservation_service WHERE id_client='" + id_client + "'");
        Reservation_service com = null;
        while (res.next()) {
               

          /*  com = new Reservation_service
             (Reservation_service(res.getInt("id_res_service"),
                    res.getDate("date_service"),
                    res.getInt("id_client"),
                    res.getInt("id_accomp"),
                    res.getInt("id_service"));*/

            list1.add(com);
            
        }
        System.out.println(list1);
        return list1;
    }
    

    public List<Reservation_service> TrierParNbreclient(int id_client) throws SQLException {
        List<Reservation_service> list = new ArrayList<>();
        ResultSet res = stm.executeQuery("select * from reservation_service WHERE id_client=='" + id_client + "'");
        Reservation_service com = null;
        while (res.next()) {
            //com = new Reservation_service
            list.add(com);
            
        }
        System.out.println(list);
        return list;
    }
}
