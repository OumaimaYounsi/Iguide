/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IClient <C>{
    public void ajouterUtilisateur(C u) throws SQLException;
    public List<C> AfficherUtlisateur() throws SQLException;
    public void modifierEtat(C u, boolean E) throws SQLException;
    public void modifierNom(C u, String nom) throws SQLException;
    public void modifierPrenom(C u, String prenom) throws SQLException;
    public void modifierLogin (C u, String login) throws SQLException;
    public void modifierMotDePasse(C u, String motdepasse) throws SQLException;
    public List<C> chercherUtilisateur(String a) throws SQLException;
    public List<C> loginUtilisateur(String login, String mdp) throws SQLException;
    
}
