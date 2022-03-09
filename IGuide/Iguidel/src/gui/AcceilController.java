/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AcceilController implements Initializable {

    @FXML
    private Button client;
    @FXML
    private Button accompagnant;
    @FXML
    private Button proprietere;

    /**
     * Initializes the controller class.
     */
    
    Parent parent;
     Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cclient(ActionEvent event) throws IOException {
       
        parent = FXMLLoader.load(getClass().getResource("CreeUnCompteClient.fxml"));
        Scene scene = new Scene(parent);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cree compte");
        stage.show();
            
        
    }

    @FXML
    private void caccompagnant(ActionEvent event) throws IOException {
        
                                    
        parent = FXMLLoader.load(getClass().getResource("CreeUnCompteAccomagnat.fxml"));
        Scene scene = new Scene(parent);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cree compte");
        stage.show();
     }

    @FXML
    private void cproprietere(ActionEvent event) throws IOException {
        
        parent = FXMLLoader.load(getClass().getResource("CreeComptePropietaire.fxml"));
        Scene scene = new Scene(parent);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cree compte");
        stage.show();
    }
    
}
