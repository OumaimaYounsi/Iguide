/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Administrateur;
import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MainController implements Initializable {

    @FXML
    private BorderPane main;
    @FXML
    private Button Dashboard;
    @FXML
    private Button Service;
    @FXML
    private Button Pack;
    @FXML
    private Button reservation;
    @FXML
    private Button Utilisateur;
    @FXML
    private Button Message;
    @FXML
    private Button Profil;
    @FXML
    private Label id;

    /**
     * Initializes the controller class.
     */
    public void idDet(Utilisateur u){
        
        id.setText(u.getNom()+" "+u.getPrenom());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                
    }    

    @FXML
    private void Dashboard(ActionEvent event) {
    }

    @FXML
    private void Service(ActionEvent event) {
    }

    @FXML
    private void Pack(ActionEvent event) {
    }

    @FXML
    private void reservation(ActionEvent event) {
    }

    @FXML
    private void Utilisateur(ActionEvent event) {
        System.out.println("clique");
        Loader object = new Loader();
        Pane view = object.getPage("ListeUtilisateur");
        main.setCenter(view);
    }

    @FXML
    private void Message(ActionEvent event) {
    }

    @FXML
    private void Profil(ActionEvent event) {
    }
    
}
