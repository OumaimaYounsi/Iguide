/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Accompagnant;
import entities.Resultattest;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sevices.ServiceAccompagnant;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CreeUnCompteAccomagnatController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField mdpc;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField descreptif;
    @FXML
    private TextField pays;
    @FXML
    private TextField tarif;
    @FXML
    private TextField exp;
    @FXML
    private Button creeCompte;
    @FXML
    private Button seConnecter;
    @FXML
    private ComboBox genre;
    @FXML
    private DatePicker datedenaissance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList<String> List =FXCollections.observableArrayList("Homme","Femme","Autre");
        genre.setItems(List);
    }    

    @FXML
    private void creeCompte(ActionEvent event) throws SQLException {
        ServiceAccompagnant sc= new ServiceAccompagnant();
        if (mail.getText().equals("") || nom.getText().equals("") || prenom.getText().equals("") ||  mdp.getText().equals("") || mdpc.getText().equals("") || pays.getText().equals("") || descreptif.getText().equals("") || exp.getText().equals("") || tarif.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Veuillez verifier votre inscription");
           alert.setContentText("verifier votre inscription");
           alert.show();
        }
        
        int t=0 , a=0;
        t= Integer.parseInt(tarif.getText());
        a = Integer.parseInt(exp.getText());
        String g =genre.getSelectionModel().getSelectedItem().toString();
        String date = String.valueOf(datedenaissance.getDayCellFactory());
        String role = "Accompagnant";
        Accompagnant c = new Accompagnant(mail.getText(),mdp.getText(),nom.getText(),prenom.getText(),date,pays.getText(),g,true,role,Resultattest.a,descreptif.getText(),t,a);
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
    private void seConnecter(ActionEvent event) {
    }
    
}
