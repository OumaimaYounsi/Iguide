/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Administrateur;
import entities.Resultattest;
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
public class ServiceAdministrateur implements IAdministrateur<Administrateur>{
    
    
    
    
        Connection connexion;
        Statement stm;
    
        public ServiceAdministrateur() {
         connexion = MyDB.getInstance().getConnexion();
    }
    public void ajouterAdmin(Administrateur a) throws SQLException {
    String req = "INSERT INTO `utilisateur` (`login`,`motdepasse`,`nom`,`prenom`,`datedenaissance`,`pays`,`gender`,`statut`,`role`, `role_admin`)  VALUES ( '"
                + a.getLogin() + "', '" + a.getMotdepasse()+ "', '" + a.getNom() + "', '" + a.getDatedenaissance() + "', '" + a.getPays() + "', '" + a.getGender() + "', '" + a.getStatut() + "', '" + a.getRole() + "', '" + a.getRole_admin()+ "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
    }
    public void ajouterAdministrateur(Administrateur a) throws SQLException {
       String req = "INSERT INTO `utilisateur` (`login`,`motdepasse`,`nom`,`prenom`,`datedenaissance`,`pays`,`gender`,`statut`,`role`, `role_admin`) "
                + "VALUES ( ?, ?,?,?, ?,?,?,?,?,?) ";
        
          PreparedStatement ps = connexion.prepareStatement(req);
        
        ps.setString(1, a.getLogin());
        ps.setString(2, a.getMotdepasse());     
        ps.setString(3, a.getNom());
        ps.setString(4, a.getPrenom());
        ps.setString(5, a.getDatedenaissance());
        ps.setString(6, a.getPays());
        ps.setString(7, a.getGender());
        ps.setBoolean(8, a.getStatut());
        ps.setString(9, a.getRole());
        ps.setString(10, a.getRole_admin());
        ps.executeUpdate(); 
    }

  /*

    @Override
    public void modifierEtat(Administrateur u, Statut E) throws SQLException {
        String req = "UPDATE Administrateur SET statut = ', '"+E+"'," + "WHERE id= '"+u.getId()+"',";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
        
    }

    @Override
    public Administrateur loginAdministrateur(String login, String mdp) throws SQLException {
Administrateur u=new Administrateur();
        
        String req = "select * from Administrateur WHERE login= '"+u.getLogin()+"' and motdepasse= '"+u.getMotdepasse()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
        
        return u;    }

    @Override
    public void modifierNom(Administrateur u, String nom) throws SQLException {
String req = "UPDATE Administrateur SET nom = ', '"+nom+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);    }

    @Override
    public void modifierPrenom(Administrateur u, String prenom) throws SQLException {
String req = "UPDATE Administrateur SET nom = ', '"+prenom+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);    }

    @Override
    public void modifierLogin(Administrateur u, String login) throws SQLException {
String req = "UPDATE Administrateur SET login = ', '"+login+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);    }

    @Override
    public void modifierMotDePasse(Administrateur u, String motdepasse) throws SQLException {
String req = "UPDATE Administrateur SET motdepasse = ', '"+motdepasse+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);    }

    @Override
    public List<Administrateur> chercherAdministrateur(String a) throws SQLException {
        List<Administrateur> Administrateur = new ArrayList<>();
        String req = "SELECT * FROM `Administrateur` WHERE `nom` LIKE  '"+a+"'  OR `prenom` LIKE '"+a+"'";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Administrateur u = new Administrateur(
                    
            rst.getString("login"),
            rst.getString("motdepasse"),
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("datedenaissance"),
            rst.getString("pays"),
            rst.getString("ville"), 
            Statut.valueOf(rst.getString("statut")),
            rst.getString("role")
            );
                    
            Administrateur.add(u);
        }
            
        return Administrateur;     
    }

    @Override
    public List<Administrateur> AfficherAdministrateur() throws SQLException {
        List<Administrateur> Administrateur = new ArrayList<>();
        String req = "select * from client";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
    
            Administrateur p;
    p = new Administrateur(
            
            rst.getString("login"),
            rst.getString("motdepasse"),
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("datedenaissance"),
            rst.getString("pays"),
            rst.getString("ville"), 
            Statut.valueOf(rst.getString("statut")),
            rst.getString("role")
    );
    
                    
            Administrateur.add(p);
        }
        return Administrateur;
    }

*/
    
}
