/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Message;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import sevices.MessageCrud;

/**
 * FXML Controller class
 *
 * @author Med Amine
 */
public class TestController implements Initializable {

    @FXML
    private TextField messageid;
    @FXML
    private TextArea messageliste;
    @FXML
    private Button feedback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void envoyer(javafx.event.ActionEvent event) {
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        MessageCrud mcrud = new MessageCrud();
        Message m1 = new Message(messageid.getText(), dd);

        mcrud.ajouterMessage(m1);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("message is added successfully!");
        alert.show();
        messageid.setText("");

    }

    private void listmessage(javafx.event.ActionEvent event) {
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        MessageCrud mcrud = new MessageCrud();
        Message m1 = new Message(messageid.getText(), dd);

    }

    @FXML
    private void afficher(javafx.event.ActionEvent event) {
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        MessageCrud mcrud = new MessageCrud();
        Message m1 = new Message();
        messageliste.setText(mcrud.afficherMessage().toString());
    }

    @FXML
    private void move_to_feedback(javafx.event.ActionEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("feedback.fxml"));
            Stage myWindow = (Stage) feedback.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("page name");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
