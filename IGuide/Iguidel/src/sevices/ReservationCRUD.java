/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;


import entites.ReservationPack;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnection;

/**
 *
 * @author user
 */
public class ReservationCRUD {
       private Connection mc;
       private Statement ste;

    public ReservationCRUD() {
        mc = DBConnection.getInstance().getConnection();
    }
   /*  public List<ReservationPack> showAllReservation() throws SQLException {

        List<ReservationPack> listOfPacks = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select "
                + "utilisateur.nom as nom, "
                + "packs.name as pack_name, "
                + "reservationpack.date_pack as datereservation, "
               
                + "from reservationpack "
                + "join utilisateur "
                + "on reservationpack.id_client= utilisateur.id;");
        while (rs.next()) {
            String nameclient = rs.getString("nom");
            String namepack = rs.getString("pack_name");
            Date dater = rs.getDate("datereservation");
            

            ReservationPack res = new ReservationPack(nameclient, namepack, dater);
            listOfPacks.add(p);
        }
        return listOfPacks;
    }*/
   
    public List<ReservationPack>  afficherReservationPack() throws SQLException {
       List<ReservationPack> reservations_pack = new ArrayList<>();
        String re = "select * from reservationpack";
         ste = mc.createStatement();
         ResultSet rs = ste.executeQuery(re);

        while (rs.next()) {
           ReservationPack n = new ReservationPack();
                n.setId_res_pack(rs.getInt("id"));
                n.setId_pack(rs.getInt("id_pack"));
                n.setDate_pack(rs.getDate("date_pack"));
                n.setId_client(rs.getInt("id_client"));
                n.setId_accomp(rs.getInt("id_accomp"));
                
              
      
                reservations_pack.add(n);
        }
        return reservations_pack;
    }
    
    
    
    public List<ReservationPack> suprimerReservation(int id_res_pack){
        List<ReservationPack> Reservation = new ArrayList<>();
        String sql="DELETE FROM reservationpack  WHERE id= "+id_res_pack;
        try {
             ste=mc.createStatement();
             ste.executeUpdate(sql);
             System.out.println("Reservation modifié");
          
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return Reservation;
    }
    
    
    
    public List<ReservationPack> updateReservation (int id_res_pack ,Date date_pack ){

List<ReservationPack> reservation = new ArrayList<>();
        try {
  
            String req = "UPDATE reservationpack SET date_pack ='" + date_pack
                    
                    + "' WHERE id =" + id_res_pack;

            PreparedStatement pre = mc.prepareStatement(req);
            pre.executeUpdate();
            System.out.println("Reservation Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservation;
      }
}
