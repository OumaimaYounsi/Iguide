/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Service;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Administrateur
 */
public interface IService<T> {
    public void AjouterService(T s) throws SQLException;
    public List<T> AfficherService() throws SQLException;
    public void ModifierService(T s) throws SQLException;
    public void SupprimerService(T s) throws SQLException;
    public  ObservableList<T> rechercherparnom(String nom) throws SQLException;
    List<T> TrierService(String nom) throws SQLException;
    public List<Service> TrierServiceparprix(String prix) throws SQLException;
}
