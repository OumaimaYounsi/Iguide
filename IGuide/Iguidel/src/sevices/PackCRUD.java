/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Pack;
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
public class PackCRUD {

    private Connection con;
    private Statement ste;

    public PackCRUD() {
        con =MyDB.getInstance().getConnexion();
    }

    public void addPack(Pack p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO packs (name,description, id_service , image) VALUES (?,?,?,?);");

        pre.setString(1, p.getName());
        pre.setString(2, p.getDesc());
        pre.setInt(3, p.getIdService());
        pre.setString(4, p.getImage());
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
        public boolean updatePackrating(int rating, int id) {
        try {
            PreparedStatement pre = con.prepareStatement("update packs set rating=? where id=? ;");

            pre.setInt(1, rating);
            pre.setInt(2, id);

            if (pre.executeUpdate() != 0) {
                System.out.println("rating updated");
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
        ResultSet rs = ste.executeQuery("select * from pack");
        while (rs.next()) {
            Pack p = new Pack(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getInt("id_service"),
            rs.getString("image"),
            rs.getInt("rating")
            
            );
           
            listOfPacks.add(p);
            System.out.println(listOfPacks);
        }
        return listOfPacks;
    }
}
