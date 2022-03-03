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
 * @author user
 */
public interface IReservation_pack  <T> {
    
  public void ajouterReservationPack(T r) throws SQLException;
    public void modifierReservationPack(T r) throws SQLException;
    public void supprimerReservationPack(int id) throws SQLException;
    public List<T> afficherReservationPack() throws SQLException;
}
