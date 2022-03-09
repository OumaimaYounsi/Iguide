/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author Administrateur
 */
public class UtilisateurServices {
     private Connection con;
    private Statement ste;

    public UtilisateurServices() {
         con = MyDB.getInstance().getConnexion();
    }
     public List<Utilisateur> showAllAccomp() throws SQLException {

        List<Utilisateur> listOfAccomp = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from utilisateur");
        while (rs.next()) {
      
            String name = rs.getString("nom");
            int tarifdujour = rs.getInt("tarifdujour");
            String descriptif= rs.getString("descriptif");
            String role_pro= rs.getString("role_pro");
            int experience= rs.getInt("experience");

            String image = rs.getString("image");
            
            Utilisateur p = new Utilisateur( name, tarifdujour, descriptif,role_pro, experience, image);
            listOfAccomp.add(p);
        }
        return listOfAccomp;
    }
    
}
