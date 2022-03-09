/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Proprietaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ServicePropietaire implements IProprietaire<Proprietaire>{
     Connection connexion;
    Statement stm;

    public ServicePropietaire() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouterUtilisateur(Proprietaire u) throws SQLException {
        String req = "INSERT INTO `utilisateur` (`login`,`motdepasse`,`nom`,`prenom`,`datedenaissance`,`pays`,`gender`,`statut`, `role`, `role_pro`) "
                + "VALUES ( ?, ?,?,?, ?,?,?,?,?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, u.getLogin());
        ps.setString(2, u.getMotdepasse());     
        ps.setString(3, u.getNom());
        ps.setString(4, u.getPrenom());
        ps.setString(5, u.getDatedenaissance());
        ps.setString(6, u.getPays());
        ps.setString(7, u.getGender());
        ps.setBoolean(8,u.getStatut());
        ps.setString(9, u.getRole());
        ps.setString(10, u.getRole_pro());
        
        ps.executeUpdate(); 
    }

    @Override
    public List<Proprietaire> AfficherUtlisateur() throws SQLException {
       List<Proprietaire> Utilisateur = new ArrayList<>();
        String req = "select * from utilisateur";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
    
            Proprietaire p;
            p = new Proprietaire(
            
            
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("datedenaissance"),
            rst.getString("pays"),
            rst.getString("gender"),
            rst.getBoolean("statut"),
            rst.getString("role")
    );
    
                    
            Utilisateur.add(p);
        }
        return Utilisateur;
    }

    @Override
    public void modifierEtat(Proprietaire u, boolean E) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierNom(Proprietaire u, String nom) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierPrenom(Proprietaire u, String prenom) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierLogin(Proprietaire u, String login) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierMotDePasse(Proprietaire u, String motdepasse) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proprietaire> chercherUtilisateur(String a) throws SQLException {
        List<Proprietaire> Utilisateur = new ArrayList<>();
        //SELECT * FROM `utilisateur` WHERE `nom` LIKE '%O%' OR `prenom` LIKE '%O%'
        String req = "SELECT * FROM `utilisateur` WHERE `nom` LIKE  '"+a+"'  OR `prenom` LIKE '"+a+"'";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Proprietaire u = new Proprietaire(
                    
                    rst.getString("nom"),
                    rst.getString("prenom"),
                    rst.getString("datedenaissance"),
                    rst.getString("pays"),
                    rst.getString("gender"),
                    rst.getBoolean("statut"),
                    rst.getString("role")
            );
                    
            Utilisateur.add(u);
        }
        return Utilisateur;
    }

    @Override
    public List<Proprietaire> loginUtilisateur(String login, String mdp) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
