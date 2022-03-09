/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Feedback;
import entities.Message;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sevices.FeedbackCrud;
import sevices.MessageCrud;

/**
 * FXML Controller class
 *
 * @author Med Amine
 */
public class FeedbackController implements Initializable {

    private Button message;
    @FXML
    private TextField feedbackid;
    private TextArea feedbackliste;
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
    @FXML
    private ScrollPane scrollfeedback;
    @FXML
    private ImageView ref;
     @FXML
    private GridPane gridfeedback;

    /**
     * Initializes the controller class.
     */
    private List<Feedback> feedbacks = new ArrayList<>();
   
    private List<Feedback> getData() {
        List<Feedback> feedbackitem = new ArrayList<>();
        Feedback f;
        for (Feedback feedback : feedbackData) {

            f = new Feedback();
             f.setContenu(feedback.getContenu());
             f.setDate_feedback(feedback.getDate_feedback());
           
          

            feedbackitem.add(f);

        }
        return feedbackitem;

    }
    
    
    public List<Feedback> feedbackData = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        FeedbackCrud fcrud = new FeedbackCrud();
        feedbackData = fcrud.afficherFeedback();
        feedbacks.addAll(getData());

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < feedbacks.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("feedbackitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                FeedbackitemController feedbackitem = fxmlLoader.getController();
              feedbackitem.setData(feedbacks.get(i));

                if (column == 1) {
                    column = 0;
                    row++;
                }
                gridfeedback.add(anchorPane, column++, row);
                gridfeedback.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridfeedback.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridfeedback.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridfeedback.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridfeedback.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridfeedback.setMaxHeight(Region.USE_PREF_SIZE);
                gridfeedback.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
    
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        FeedbackCrud fcrud = new FeedbackCrud();
//        Feedback f1 = new Feedback(feedbackid.getText(),dd ,Integer.parseInt(noteid.getText()),Integer.parseInt(idc.getText()),Integer.parseInt(ida.getText()),Integer.parseInt(idac.getText()),Integer.parseInt(ids.getText()),Integer.parseInt(idp.getText()));
          Feedback f1 = new Feedback(feedbackid.getText(),dd ,0,0,0,0,0);
          if(feedbackid.getText().equals("")){
              
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setContentText("champ vide!");
        alert.show();
              
          }else{
      
        fcrud.ajouterFeedback(f1);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("feedback is added successfully!");
        alert.show();
        feedbackid.setText("");
        }
    }

    private void afficher(javafx.event.ActionEvent event) {
         LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);
        FeedbackCrud fcrud = new FeedbackCrud();
        Feedback f1 = new Feedback();
        feedbackliste.setText(fcrud.afficherFeedback().toString());
    }

    @FXML
    private void ref(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("feedback.fxml"));
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
