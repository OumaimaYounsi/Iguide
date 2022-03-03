/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Feedback;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sevices.FeedbackCrud;

/**
 * FXML Controller class
 *
 * @author Med Amine
 */
public class FeedbackController implements Initializable {

    @FXML
    private Button message;
    @FXML
    private TextField feedbackid;
    @FXML
    private TextArea feedbackliste;
    @FXML
    private TextField noteid;
    @FXML
    private TextField idc;
    @FXML
    private TextField ida;
    @FXML
    private TextField ids;
    @FXML
    private TextField idac;
    @FXML
    private TextField idp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void move_to_message(ActionEvent event) {
        
         Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("message.fxml"));
            Stage myWindow = (Stage) message.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("page name");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void envoyer(ActionEvent event) {
    
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        FeedbackCrud fcrud = new FeedbackCrud();
//        Feedback f1 = new Feedback(feedbackid.getText(),dd ,Integer.parseInt(noteid.getText()),Integer.parseInt(idc.getText()),Integer.parseInt(ida.getText()),Integer.parseInt(idac.getText()),Integer.parseInt(ids.getText()),Integer.parseInt(idp.getText()));
          Feedback f1 = new Feedback(feedbackid.getText(),dd ,Integer.parseInt(noteid.getText()),0,0,0,0,0);
      
        fcrud.ajouterFeedback(f1);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("feedback is added successfully!");
        alert.show();
        feedbackid.setText("");
    }

    @FXML
    private void afficher(javafx.event.ActionEvent event) {
         LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        FeedbackCrud fcrud = new FeedbackCrud();
        Feedback f1 = new Feedback();
        feedbackliste.setText(fcrud.afficherFeedback().toString());
    }

    
    
}
