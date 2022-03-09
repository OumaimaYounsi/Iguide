/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Message;
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
public class MessageitemController implements Initializable {

    /**
     * Initializes the controller class.
     */
   private Message message;
    @FXML
    private Label messagecontenu;
    @FXML
    private Label messagedate;
   public void setData(Message m){
    this.message = m ;
    messagecontenu.setText(m.getContenu());
        messagedate.setText("" +m.getDate_message());

   }
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
