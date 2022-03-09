/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Accompagnant;
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
 * @author USER
 */

    public class UtilisateurCRUD {
      private Connection con;
    private Statement ste;

    public UtilisateurCRUD() {
        con = MyDB.getInstance().getConnexion();
    }
     public List<Accompagnant> showAllAccomp() throws SQLException {

        List<Accompagnant> listOfAccomp = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from utilisateur");
        while (rs.next()) {
      
            String name = rs.getString("nom");
            int tarifdujour = rs.getInt("tarifdujour");
            String role_pro= rs.getString("role_pro");
            int experience= rs.getInt("experience");
            String prenom = rs.getString("prenom");
            String image = rs.getString("image");
            
            Accompagnant p = new Accompagnant( name, prenom, image,tarifdujour, experience);
            listOfAccomp.add(p);
        }
        return listOfAccomp;
    }
    }
    
