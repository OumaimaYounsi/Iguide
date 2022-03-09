/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MainCLientController implements Initializable {

    @FXML
    private Button Pack;
    @FXML
    private Button Reservation;
    @FXML
    private Button message;
    @FXML
    private Button profil;
    @FXML
    private Label id;
    @FXML
    private Button Service;
    @FXML
    private BorderPane main;

    
    Parent parent;
     Stage stage;
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
    private void Setvices(ActionEvent event) {
    }

    @FXML
    private void Pack(ActionEvent event) throws IOException {
        
        System.out.println("clique");
        Loader object = new Loader();
        Pane view = object.getPage("PackHome");
        main.setCenter(view);

        
//        this.stage = primaryStage;
//     
//            parent = FXMLLoader.load(getClass().getResource("PackHome.fxml"));
//             Scene scene = new Scene(parent);
//      
//       
//        
//        
//        stage.setScene(scene);
//        stage.setTitle("Cree compte");
//        stage.show();
        
    }

    @FXML
    private void Reservation(ActionEvent event) {
    }

    @FXML
    private void message(ActionEvent event) {
    }

    @FXML
    private void profil(ActionEvent event) {
    }
    
}
