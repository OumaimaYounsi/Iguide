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
public interface IUtilisateur <U>{
    

    public List<U> AfficherUtlisateur() throws SQLException;

    
    
}
