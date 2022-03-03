/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Categorie;
import entities.Service;
import entities.Statut;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author Administrateur
 */
public class ServiceServices implements IService<Service> {

    Connection connexion;
    Statement stm;

    public ServiceServices() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void AjouterService(Service s) throws SQLException {
        String req = "INSERT INTO `service` (`nom`, `nombre_max`, `datedebut`, `datefin`, `cible`, `lieu`, `categorie`, `prix`) VALUES ( '"
                + s.getNom() + "', '" + s.getNombre_max() +"', '"+ s.getDatedebut()+  "', '" +s.getDatefin()+  "', '" + s.getCible()+  "','"+ s.getLieu()+ "', '"+ s.getCategorie()+ "', '"+ s.getPrix()+ "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

   public List<Service> AfficherService() throws SQLException{

List<Service> Services = new ArrayList<>();
        String req = "select * from service";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Service s = new Service(
                    rst.getInt("idservice"),
                    rst.getString("nom"),
                    rst.getInt("nombre_max"),
                    rst.getDate("datedebut"),
                    rst.getDate("datefin"),
                    rst.getString("cible"), 
                    rst.getString("lieu"),
                    Categorie.valueOf(rst.getString("categorie")),
                    rst.getFloat("prix"));
                    
                    
            Services.add(s);
        }
        return Services;
    }
    
   
    
    @Override
    public void ModifierService(Service s) throws SQLException {
        int id=4;
        String req = "UPDATE service set nom='" + s.getNom()+ "',nombre_max='" + s.getNombre_max()+ "',datedebut='" + s.getDatedebut()+ "',datefin='" + s.getDatefin()+ "',cible='" + s.getCible()+ "',lieu='" + s.getLieu()+ "',categorie='" + s.getCategorie()+ "',prix='" + s.getPrix()+ "' where idservice='"+id+ "'";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
      
    }
    
    
     @Override
    public void SupprimerService(Service s) throws SQLException {
        String req = "DELETE FROM service WHERE idservice='"+s.getIdservice()+ "'";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    public ObservableList<Service> rechercherparnom(String nom) throws SQLException{
         ObservableList<Service> Services = FXCollections.observableArrayList();
        String req = "SELECT idservice,nom,nombre_max,datedebut,datefin,cible,categorie,lieu,prix FROM service where nom= '" + nom+ "'  ";
       

        ObservableList<Service> list=FXCollections.observableArrayList();
        try {
           Statement st = connexion.createStatement();
            ResultSet rst = st.executeQuery(req);
           while(rst.next()){
               
              Service s=new Service(
                rst.getInt(1),
                rst.getString(2),
                rst.getInt(3),
                rst.getDate(4),
                rst.getDate(5),
                rst.getString(6),
                rst.getString(7),
                Categorie.valueOf(rst.getString("categorie")),
                rst.getFloat(9));
               list.add(s);
           }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return list;
    }
    
    
    @Override
    public List<Service> TrierService(String nom) throws SQLException {
        
        List<Service> Services = new ArrayList<>();
        
       /* if (nom.equals("nom"))
        {req="select * from materiel order by " +value ;}
        else
       {req="select * from materiel order by " +value+ " DESC ";}*/
       
        String req="select * from service order by " +nom ;
        
        PreparedStatement pst = connexion.prepareStatement(req); 
           
        ResultSet rst = pst.executeQuery();
             while (rst.next()) {
                  Service  s = new Service(
                    rst.getInt("idservice"),
                    rst.getString("nom"),
                    rst.getInt("nombre_max"),
                    rst.getDate("datedebut"),
                    rst.getDate("datefin"),
                    rst.getString("cible"),
                    rst.getString("lieu"),
                    Categorie.valueOf(rst.getString("categorie")),
                    rst.getFloat("prix"));
                    
                    
            Services.add(s);
    }
             return Services;
    
}

  @Override
    public List<Service> TrierServiceparprix(String prix) throws SQLException {
        Service s;
        List<Service> Services = new ArrayList<>();
        
        String req="select * from service order by " +prix+ " DESC ";
        
        PreparedStatement pst = connexion.prepareStatement(req); 
           
        ResultSet rst = pst.executeQuery();
            while(rst.next()){
               
                      s = new Service(
                    rst.getInt("idservice"),
                    rst.getString("nom"),
                    rst.getInt("nombre_max"),
                    rst.getDate("datedebut"),
                    rst.getDate("datefin"),
                    rst.getString("cible"),
                    rst.getString("lieu"),
                    Categorie.valueOf(rst.getString("categorie")),
                    rst.getFloat("prix"));
                     Services.add(s);
            }
        return Services;
    } 

   
    

}
