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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
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
    private TextArea messageliste;
    private Button feedback;
    @FXML
    private ScrollPane scrollmessage;
    @FXML
    private GridPane gridmessage;
    @FXML
    private ImageView ref;
    
    

    /**
     * Initializes the controller class.
     */
   

    @FXML
    private void envoyer(javafx.event.ActionEvent event) {
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        MessageCrud mcrud = new MessageCrud();
        Message m1 = new Message(messageid.getText(), dd);
      if(messageid.getText().equals("")){
          Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setContentText("champ vide!");
        alert.show();
              
          }else{
      
        mcrud.ajouterMessage(m1);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("message is added successfully!");
        alert.show();
        mcrud.afficherMessage();
        messageid.setText("");
    
    }
    }
    private void listmessage(javafx.event.ActionEvent event) {
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        MessageCrud mcrud = new MessageCrud();
        Message m1 = new Message(messageid.getText(), dd);

    }

    private void afficher(javafx.event.ActionEvent event) {
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        MessageCrud mcrud = new MessageCrud();
        Message m1 = new Message();
        messageliste.setText(mcrud.afficherMessage().toString());
    }

    private void move_to_feedback(javafx.event.ActionEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("message.fxml"));
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
    private List<Message> messages = new ArrayList<>();
    private List<Message> getData() {
        List<Message> messageitem = new ArrayList<>();
        Message m;
        for (Message message : messageData) {

            m = new Message();
             m.setContenu(message.getContenu());
             m.setDate_message(message.getDate_message());
          //  m.setDesc(messages.getDesc());

            messageitem.add(m);

        }
        return messageitem;

    }
    public List<Message> messageData = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MessageCrud mcrud = new MessageCrud();
        messageData = mcrud.afficherMessage();

        messages.addAll(getData());

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < messages.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("messageitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                MessageitemController messageitem = fxmlLoader.getController();
              messageitem.setData(messages.get(i));

                if (column == 1) {
                    column = 0;
                    row++;
                }
                gridmessage.add(anchorPane, column++, row);
                gridmessage.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridmessage.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridmessage.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridmessage.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridmessage.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridmessage.setMaxHeight(Region.USE_PREF_SIZE);
                gridmessage.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void ref(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("message.fxml"));
            Stage myWindow = (Stage) ref.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle(" ");
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }

    
        
    

