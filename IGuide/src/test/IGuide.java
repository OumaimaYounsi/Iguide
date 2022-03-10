/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Accompagnant;
import entities.Administrateur;
import entities.Resultattest;
import entities.Statut;
import entities.Client;
import java.io.IOException;
import java.sql.SQLException;
import sevices.ServiceClient;
//import java.util.Date;
import java.sql.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sevices.ServiceAccompagnant;
import sevices.ServiceAdministrateur;
/**
 *
 * @author USER
 */
public class IGuide extends Application{
     Parent parent;
     Stage stage;
     
     
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
     
            parent = FXMLLoader.load(getClass().getResource("/gui/ListeUtilisateur.FXML"));
             Scene scene = new Scene(parent);
      
       
        
        
        stage.setScene(scene);
        stage.setTitle("Cree compte");
        stage.show();
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

}