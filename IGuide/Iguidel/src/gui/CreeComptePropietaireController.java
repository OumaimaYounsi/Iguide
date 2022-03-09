/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Proprietaire;
import entities.Resultattest;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sevices.ServicePropietaire;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CreeComptePropietaireController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private TextField mdp;
    @FXML
    private TextField mdpc;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField statut;
    @FXML
    private Button creeCompte;
    @FXML
    private Button seConnecter;
    @FXML
    private ComboBox genre;

    /**
     * Initializes the controller class.
     */
    
    
    
    Parent parent;
     Stage stage;
    @FXML
    private DatePicker datedenaissance;
    @FXML
    private TextField pays;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> List =FXCollections.observableArrayList("Homme","Femme","Autre");
        genre.setItems(List);
    }    

    @FXML
    private void creeCompte(ActionEvent event) throws SQLException {
            ServicePropietaire sc= new ServicePropietaire();
          if (mail.getText().equals("") || Nom.getText().equals("") || Prenom.getText().equals("") ||  mdp.getText().equals("") || mdpc.getText().equals("") || pays.getText().equals("") ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Veuillez verifier votre inscription");
           alert.setContentText("verifier votre inscription");
           alert.show();
        }
        String g =genre.getSelectionModel().getSelectedItem().toString();
        String date = String.valueOf(datedenaissance.getDayCellFactory());
        String role = "Proprietaire";
        Proprietaire c = new Proprietaire(mail.getText(),mdp.getText(),Nom.getText(),Prenom.getText(),date,pays.getText(),g,true,role,statut.getText());
          String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
          
          Pattern pa =Pattern.compile(masque);
         if(mdp.getText().equals(mdpc.getText()) && pa.matcher(mail.getText()).matches() )
         
             
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
    private void seConnecter(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(parent);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cree compte");
        stage.show();
    }
    
}
