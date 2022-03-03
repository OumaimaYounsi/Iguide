/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Pack;
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
public class PackCRUD {

    private Connection con;
    private Statement ste;

    public PackCRUD() {
        con = DBConnection.getInstance().getConnection();
    }

    public void addPack(Pack p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO packs (name,description, id_service) VALUES (?,?,?);");

        pre.setString(1, p.getName());
        pre.setString(2, p.getDesc());
        pre.setInt(3, p.getIdService());

        pre.executeUpdate();
    }

    public boolean updatePack(String name, String desc, int id) {
        try {
            PreparedStatement pre = con.prepareStatement("update packs set name=?,  description=? where id=? ;");

            pre.setString(1, name);

            pre.setString(2, desc);

            pre.setInt(3, id);

            if (pre.executeUpdate() != 0) {
                System.out.println("pack updated");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("id not found!");
        return false;
    }
     public boolean updatePackService(int id_service, int id) {
        try {
            PreparedStatement pre = con.prepareStatement("update packs set id_service=? where id=? ;");

            pre.setInt(1, id_service);

            pre.setInt(2, id);

            if (pre.executeUpdate() != 0) {
                System.out.println("Service ajouté au Pack");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("id not found!");
        return false;
    }


    public boolean deletePack(int id) throws SQLException {

        PreparedStatement pre = con.prepareStatement("Delete from packs where id=? ;");
        pre.setInt(1, id);
        if (pre.executeUpdate() != 0) {
            System.out.println("Pack Deleted");
            return true;
        }
        System.out.println("id Product not found!");
        return false;

    }

    public List<Pack> showAllPacks() throws SQLException {

        List<Pack> listOfPacks = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select "
                + "packs.id as pack_id, "
                + "packs.name as pack_name, "
                + "packs.description as pack_desc, "
                + "packs.id_service as service_id, "
                + "services.name as service_name, "
                + "services.nbr_max as service_nbr_max, "
                + "services.date_debut as service_date_debut, "
                + "services.date_fin as service_date_fin, "
                + "services.cible as service_cible "
                + "from packs "
                + "join services "
                + "on services.id = packs.id_service;");
        while (rs.next()) {
            int id = rs.getInt("pack_id");
            String name = rs.getString("pack_name");
            String desc = rs.getString("pack_desc");
            int id_service = rs.getInt("service_id");
            String service_name = rs.getString("service_name");
            int service_nbr_max = rs.getInt("service_nbr_max");
            Date service_date_debut = rs.getDate("service_date_debut");
            Date service_date_fin = rs.getDate("service_date_fin");
            String service_cible = rs.getString("service_cible");

            Pack p = new Pack(id, name, desc, id_service, service_name, service_nbr_max, service_date_debut, service_date_fin, service_cible);
            listOfPacks.add(p);
        }
        return listOfPacks;
    }
}
