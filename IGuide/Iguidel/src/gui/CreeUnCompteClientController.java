/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Client;

import entities.Resultattest;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.util.Callback;
import sevices.ServiceClient;
import sun.security.util.Password;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CreeUnCompteClientController implements Initializable {

    /**
     * Initializes the controller class.
     
    */
      @FXML
    private javafx.scene.control.TextField mail;

   

    @FXML
    private javafx.scene.control.TextField nom;

    @FXML
    private javafx.scene.control.TextField pays;

    @FXML
    private javafx.scene.control.TextField prenom;

    

    @FXML
    private Button creecompte;

     @FXML
    private Button seconnecter;

     @FXML
    private DatePicker datedenaissance;
    @FXML
    private javafx.scene.control.TextField mdp;
    @FXML
    private javafx.scene.control.TextField mdpc;
    @FXML
    private ComboBox  gender;
    
    Parent parent;
     Stage stage;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> List =FXCollections.observableArrayList("Homme","Femme","Autre");
        gender.setItems(List);
        
    } 
    
    
    
      @FXML
   private void AddPerson(ActionEvent event) throws SQLException {
        ServiceClient sc= new ServiceClient();
         if (mail.getText().equals("") || nom.getText().equals("") || prenom.getText().equals("") ||  mdp.getText().equals("") || mdpc.getText().equals("") || pays.getText().equals("") ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Veuillez verifier votre inscription");
           alert.setContentText("verifier votre inscription");
           alert.show();
        }
        String g =gender.getSelectionModel().getSelectedItem().toString();
        String date = String.valueOf(datedenaissance.getDayCellFactory());
        String role = "Client";
        Client c = new Client(mail.getText(),mdp.getText(),nom.getText(),prenom.getText(),date,pays.getText(),g,true,role,Resultattest.a);
          String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
          
          Pattern pa =Pattern.compile(masque);
         if(mdp.getText().equals(mdpc.getText()) && pa.matcher(mail.getText()).matches() && mail.getText().isEmpty()==false && mdp.getText().isEmpty()==false && mdpc.getText().isEmpty()==false && nom.getText().isEmpty()==false && prenom.getText().isEmpty()==false && pays.getText().isEmpty()==false && g.isEmpty()==false && date.isEmpty()==false)
         
             
             {        
                       sc.ajouterUtilisateur(c);
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Success");
                       alert.setContentText("Person is added successfully!");
                       alert.show();
                        
                 }
       else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Veuillez verifier votre inscription");
           alert.setContentText("verifier votre inscription");
           alert.show();
            
         }
         
        
        
        
          
    } 

    @FXML
    private void seconnecter(ActionEvent event) throws IOException {
        
            parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(parent);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stage.setScene(scene);
        stage.setTitle("Cree compte");
        stage.show();
    }

    
}
  
  
    
   

    

