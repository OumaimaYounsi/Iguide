/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class RatingController implements Initializable {
Connection connexion;
        Statement stm;
    @FXML
    private ComboBox<String> cbrate;
    @FXML
    private Rating rating;
    @FXML
    private Button envoyer;
    @FXML
    private Button accueil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    @FXML
    private void envoyer(MouseEvent event) {
         PreparedStatement ste;
                   Statement st;
                   Connection cnx;
                   
                   cnx = MyDB.getInstance().getConnexion();
                   
                   int rate=(int) rating.getRating();
                     System.out.println("rating is :"+rating.getRating());
                   
                   String nom =  cbrate.getValue();
                   String sql1="select idservice from service where nom='"+nom+"'";
                   
                   int idservice=0;
                   try {
                       
                       cnx =  MyDB.getInstance().getConnexion();
                       ste = cnx.prepareStatement(sql1);
                       ResultSet rs = ste.executeQuery(sql1);
                       
                       
                       
                       if(rs.next())
                       {
                           idservice =rs.getInt("idservice");
                           
                           
                           
                           
                       }
                   } catch (SQLException ex) {
                       Logger.getLogger(RatingController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   String sql2="insert into rating (idservice,rating,nom) values(?,?,?)";
                     try {
                       cnx =  MyDB.getInstance().getConnexion();
                   ste = cnx.prepareStatement(sql2);
                   
                   ste.setInt(1,idservice);
                   
                   ste.setInt(2, rate);
                   ste.setString(3,nom);
                   
                   ste.executeUpdate();
                    Notifications notificationBuilder =Notifications.create().title("Remerciment").text("Toute l’équipe vous remercie pour votre notation.").graphic(null).hideAfter(javafx.util.Duration.seconds(5)).position(Pos.TOP_LEFT)
                    .onAction(new EventHandler<ActionEvent>(){public void handle(ActionEvent event){
                    System.out.println("Cliked on");}});
            notificationBuilder.darkStyle();
            notificationBuilder.show();
               } catch (SQLException ex) {
            Logger.getLogger(RatingController.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
    }
   @FXML
    private void choisir(MouseEvent event) {
         
        try {
            String sql="select nom from service ";
            
            
            List<String> nm =new ArrayList<String>();
        PreparedStatement ste;
            Statement st;
            Connection cnx;
            cnx =  MyDB.getInstance().getConnexion();
            st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                
                nm.add(rs.getString("nom"));
                cbrate.setItems(FXCollections.observableArrayList(nm));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RatingController.class.getName()).log(Level.SEVERE, null, ex);
                 
    }
    } 
}
