/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Feedback;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Med Amine
 */
public class FeedbackitemController implements Initializable {

     private Feedback feedback;
    @FXML
    private Label feedbackcontenu;
    @FXML
    private Label feedbackdate;
    
    public void setData(Feedback f){
     
    this.feedback = f ;
    feedbackcontenu.setText(f.getContenu());
        feedbackdate.setText("" +f.getDate_feedback());
       

   }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
