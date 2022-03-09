/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Resultattest;

import entities.Client;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.MyDB;

/**
 *
 * @author USER
 */
public class ServiceClient implements IClient<Client>{

    Connection connexion;
    Statement stm;

    public ServiceClient() {
        connexion = MyDB.getInstance().getConnexion();
    }
    @Override
    public void ajouterUtilisateur(Client u) throws SQLException{
        
        String req = "INSERT INTO `utilisateur` (`login`,`motdepasse`,`nom`,`prenom`,`datedenaissance`,`pays`,`gender`,`statut`, `role`,`resultattest`) "
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
        ps.setObject(10, u.getResultattest().getResultattest());
        ps.executeUpdate(); 
    }
    
   

    @Override
    public List<Client> AfficherUtlisateur() throws SQLException{

List<Client> Utilisateur = new ArrayList<>();
        String req = "select * from utilisateur";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
    
            Client p;
            p = new Client(
            
            
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
    public List<Client> loginUtilisateur(String login, String mdp) throws SQLException {
        List<Client> Utilisateur = new ArrayList<>();
        // and descreptif is null and role_pro is null and role_admin is null
       String req = "select * from utilisateur WHERE login = ? and motdepasse = ?";
       PreparedStatement ps = connexion.prepareStatement(req);
       stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
                    ps.setString(1, login);
                    ps.setString(2, mdp);
                    
         while (rst.next()) {
    
            Client p;
            p = new Client(
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("datedenaissance"),
            rst.getString("pays"),
            rst.getString("gender"),
            rst.getBoolean("statut"),
            rst.getString("role"),
            Resultattest.valueOf(rst.getString("resultattest"))
            );
    
            Utilisateur.add(p);        
            
        }            
            
        return Utilisateur;
                    
        
        
    }
    public Client loginClient(String login, String mdp) throws SQLException {
       Client c = new Client("","","","","",true,""); 
        // and descreptif is null and role_pro is null and role_admin is null
       String req = "SELECT * FROM `utilisateur` WHERE `login` LIKE  '"+login+"'  AND `motdepasse` LIKE '"+mdp+"'";
       stm = connexion.createStatement();
       ResultSet rst = stm.executeQuery(req);
       if (rst.next()) {
            Client p = new Client(
            
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("datedenaissance"),
            rst.getString("pays"),
            rst.getString("gender"),
            rst.getBoolean("statut"),
            rst.getString("role"),
            Resultattest.valueOf(rst.getString("resultattest"))
            );
            return p;
       }else {
           return c;
       }
        
         
        
        
    }

    @Override
    public void modifierNom(Client u, String nom) throws SQLException {
        
        
        String req = "UPDATE utilisateur SET nom = ', '"+nom+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
        
        
    }

    @Override
    public void modifierPrenom(Client u, String prenom) throws SQLException {
          String req = "UPDATE utilisateur SET nom = ', '"+prenom+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void modifierLogin(Client u, String login) throws SQLException {
           String req = "UPDATE utilisateur SET login = ', '"+login+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
        
    }

    @Override
    public void modifierMotDePasse(Client u, String motdepasse) throws SQLException {
    String req = "UPDATE utilisateur SET motdepasse = ', '"+motdepasse+"', WHERE id= '"+u.getId()+"'";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
    
    }

    @Override
    public List<Client> chercherUtilisateur(String a) throws SQLException {
    
        List<Client> Utilisateur = new ArrayList<>();
        //SELECT * FROM `utilisateur` WHERE `nom` LIKE '%O%' OR `prenom` LIKE '%O%'
        String req = "SELECT * FROM `utilisateur` WHERE `nom` LIKE  '"+a+"'  OR `prenom` LIKE '"+a+"'";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Client u = new Client(
                    
                    rst.getString("nom"),
                    rst.getString("prenom"),
                    rst.getString("datedenaissance"),
                    rst.getString("pays"),
                    rst.getString("gender"),
                    rst.getString("role")
            );
                    
            Utilisateur.add(u);
        }
        return Utilisateur;
       

    
    }

    @Override
    public void modifierEtat(Client u, boolean E) throws SQLException {
       String req = "UPDATE Utilisateur SET statut = ', '"+E+"'," + "WHERE id= '"+u.getId()+"',";
         stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

   
    
    
    
    }
    
    

