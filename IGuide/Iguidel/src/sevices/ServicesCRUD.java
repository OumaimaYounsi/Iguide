/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class ServicesCRUD {
     private Connection con;
    private Statement ste;

    public ServicesCRUD() {
        con = MyDB.getInstance().getConnexion();
    }

   

    public boolean updateService( int id ,String name, int nbr_max,Date date_debut ,Date date_fin, String cible) {
        try {
            PreparedStatement pre = con.prepareStatement("update Services set name=?, nbr_max=?, date_debut=?, date_fin=?, cible=? where id=? ;");

            pre.setString(1, name);
            pre.setInt(2, nbr_max);
            pre.setDate(3, date_debut);
            pre.setDate(4, date_fin);
            pre.setString(5, cible);
            pre.setInt(6, id);
 
            if (pre.executeUpdate() != 0) {
                System.out.println("Service updated");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("id not found!");
        return false;
    }

    public boolean deleteService(int id) throws SQLException {

        PreparedStatement pre = con.prepareStatement("Delete from services where id=? ;");
        pre.setInt(1, id);
        if (pre.executeUpdate() != 0) {
            System.out.println("Service Deleted");
            return true;
        }
        System.out.println("id Service not found!");
        return false;

    }

   /* public List<Service> showAllServices() throws SQLException {

        List<Service> listOfServices = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id,name,nbr_max,date_debut,date_fin,cible from services");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("name");
            int nbr_max = rs.getInt("nbr_max");
            Date date_debut= rs.getDate("date_debut");
            Date date_fin= rs.getDate("date_fin");

            String cible = rs.getString("cible");
            
            Service p = new Service(id, nom, nbr_max, date_debut, date_fin, cible);
            listOfServices.add(p);
        }
        return listOfServices;*/
    
}

