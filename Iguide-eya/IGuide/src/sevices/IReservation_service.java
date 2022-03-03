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
public interface IReservation_service <T> {
    
    public void ajouterReservationService(T r) throws SQLException;
    public void modifierReservationService(T r) throws SQLException;
    public void supprimerReservationService(int id) throws SQLException;
    public List<T> afficherReservationService() throws SQLException;
    
    
}
