/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MainAccampagnantController implements Initializable {

    @FXML
    private Button Dashboard;
    @FXML
    private Button Service;
    @FXML
    private Button Pack;
    @FXML
    private Button Reservation;
    @FXML
    private Button Massage;
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
        // TODO
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
    private void Reservation(ActionEvent event) {
    }

    @FXML
    private void Massage(ActionEvent event) {
    }

    @FXML
    private void Profil(ActionEvent event) {
    }
    
}
