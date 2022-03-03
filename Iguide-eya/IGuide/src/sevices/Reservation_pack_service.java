/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Reservation_pack;
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
public class Reservation_pack_service implements IReservation_pack {
    
     Connection connexion;
    Statement stm;

    public Reservation_pack_service() {
        connexion = MyDB.getInstance().getConnexion();
    }

    //@Override
    public void ajouterReservationPack(Reservation_pack r) throws SQLException {
        String req = "INSERT INTO reservation_pack ( `date_pack`) VALUES ( '" + r.getDate_pack() + "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

   //@Override
    public void modifierReservationPack(Reservation_pack r) throws SQLException {
        String req = "UPDATE reservation_pack SET date_pack='" + r.getDate_pack() + "') ";
        try {
            stm = connexion.createStatement();
            stm.executeUpdate(req);
            System.out.println("reservation modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerReservationPack(int id_res_pack) throws SQLException {
        String req = "DELETE FROM reservation_pack WHERE id_res_pack=" + id_res_pack + "') ";
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
    public List<Reservation_pack>  afficherReservationPack() throws SQLException {
       List<Reservation_pack> reservations_pack = new ArrayList<>();
        String re = "select * from reservation_pack";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(re);

        while (rst.next()) {
            Reservation_pack r = new Reservation_pack(rst.getInt("id_res_pack"),rst.getDate("date_pack"),rst.getInt("id_client"),rst.getInt("id_accomp"),rst.getInt("id_pack"));
            reservations_pack.add(r);
        }
        return reservations_pack;
    }

    
    
    
    
    @Override
    public void ajouterReservationPack(Object r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierReservationPack(Object r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
  public boolean rechercherpaId(int id_res_pack) {
        boolean test = false;
        String req = "SELECT * from reservation_pack where id_res_service='" + id_res_pack + "'";

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
}
