/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Accompagnant;
import entities.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author USER
 */
public class ServiceAccompagnant implements IAccompagnant<Accompagnant>{
    Connection connexion;
    Statement stm;
     public ServiceAccompagnant() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouterUtilisateur(Accompagnant u) throws SQLException {
        String req = "INSERT INTO `utilisateur` (`login`,`motdepasse`,`nom`,`prenom`,`datedenaissance`,`pays`,`gender`,`statut`, `role`,`resultattest`, `descreptif`,`tarifdujour`, `experence`) "
                + "VALUES ( ?, ?,?,?, ?,?,?,?,?,?,?,?,?) ";
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
        ps.setString(11, u.getDescreptif());
        ps.setInt(12, u.getTarifdujour());
        ps.setInt(13, u.getExperence());
        ps.executeUpdate(); 
    }

    @Override
    public List<Accompagnant> AfficherUtlisateur() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierEtat(Accompagnant u, boolean E) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierNom(Accompagnant u, String nom) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierPrenom(Accompagnant u, String prenom) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierLogin(Accompagnant u, String login) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierMotDePasse(Accompagnant u, String motdepasse) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Accompagnant> chercherUtilisateur(String a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Accompagnant> loginUtilisateur(String login, String mdp) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


  
    
    
    
    
    
