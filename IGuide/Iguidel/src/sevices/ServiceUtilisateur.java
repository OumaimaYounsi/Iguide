/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;


import entities.Utilisateur;
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
public class ServiceUtilisateur implements IUtilisateur<Utilisateur>{
  
    Connection connexion;
    Statement stm;
    
        public ServiceUtilisateur() {
        connexion = MyDB.getInstance().getConnexion();
    }
         

    
    public Utilisateur loginUtilisateur(String login, String mdp) throws SQLException {
        Utilisateur c = new Utilisateur("","","","","",true,""); 
        // and descreptif is null and role_pro is null and role_admin is null     AND `statut` LIKE '"+true+"'
       String req = "SELECT * FROM `utilisateur` WHERE `login` LIKE  '"+login+"'  AND `motdepasse` LIKE '"+mdp+"' AND `statut` LIKE '"+1+"'";
       stm = connexion.createStatement();
       ResultSet rst = stm.executeQuery(req);
       if (rst.next()) {
            Utilisateur p = new Utilisateur(
            rst.getInt("id"),
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("datedenaissance"),
            rst.getString("pays"),
            rst.getString("gender"),
            rst.getBoolean("statut"),
            rst.getString("role")
            );
            return p;
       }else {
           return c;
       }
    }

    

    @Override
    public List<Utilisateur> AfficherUtlisateur() throws SQLException {
        List<Utilisateur> Utilisateur = new ArrayList<>();
       String req = "select * from utilisateur";
        stm = connexion.createStatement();
        
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
    
            Utilisateur p = new Utilisateur(
            
            rst.getString("login"),
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("gender"),
            rst.getBoolean("statut"),
            rst.getString("role"));
    
                    
            Utilisateur.add(p);
        }
        return Utilisateur;
    }
    
    public Utilisateur modifierEtat(Utilisateur u, boolean E) throws SQLException {
       
       String req = "UPDATE Utilisateur SET statut = '"+false+"'WHERE id LIKE '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
        ResultSet rst = stm.executeQuery(req);
       
            Utilisateur p = new Utilisateur(
            
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("datedenaissance"),
            rst.getString("pays"),
            rst.getString("gender"),
            rst.getBoolean("statut"),
            rst.getString("role")
            );
            return p;
    }

    
/*
    @Override
    public void modifierEtat(Utilisateur u, boolean E) throws SQLException {
         String req = "UPDATE Utilisateur SET statut = ', '"+E+"'," + "WHERE id= '"+u.getId()+"',";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void modifierNom(Utilisateur u, String nom) throws SQLException {
              String req = "UPDATE utilisateur SET nom = ', '"+nom+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
        
        
    }

    @Override
    public void modifierPrenom(Utilisateur u, String prenom) throws SQLException {
        String req = "UPDATE utilisateur SET nom = ', '"+prenom+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void modifierLogin(Utilisateur u, String login) throws SQLException {
         String req = "UPDATE utilisateur SET login = ', '"+login+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void modifierMotDePasse(Utilisateur u, String motdepasse) throws SQLException {
        String req = "UPDATE utilisateur SET motdepasse = ', '"+motdepasse+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

   */ 
    
        

    
}
