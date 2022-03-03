/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sevices.Reservation_service_service;
import entities.Reservation_service;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Display_list_reservationsController implements Initializable {

    @FXML
    private Button Profil;
    @FXML
    private Button Services;
    @FXML
    private Button Packs;
    @FXML
    private Button supprmer;
    @FXML
    private Button modifier;
    @FXML
    private Button Afficher;
    @FXML
    private TextArea zone_Affichage;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    private void ajouter(ActionEvent event) throws SQLException {
        
        Reservation_service_service reservation = new Reservation_service_service();
        Reservation_service res1 = new Reservation_service();
        reservation.ajouterReservationService(res1);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("Reservation added successfully!");
        alert.show();
    }

    @FXML
    private void GoToProfil(ActionEvent event) {
    }

    @FXML
    private void GoToServices(ActionEvent event) {
    }

    @FXML
    private void GoToPacks(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void Modifier(ActionEvent event) {
        
        
    }

    @FXML
    private void Afficher(ActionEvent event) {
        
        Reservation_service_service  rs = new Reservation_service_service();
        try {
            zone_Affichage.setText(rs.afficherReservationService().toString());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    
}

