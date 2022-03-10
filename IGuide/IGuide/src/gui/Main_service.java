/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Administrateur
 */
public class Main_service extends Application {
Parent parent;
Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage= primaryStage;
        System.out.println(getClass().getResource("Rating.fxml"));
        parent = FXMLLoader.load(getClass().getResource("Rating.fxml"));

        Scene scene = new Scene(parent);

        stage.setScene(scene);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
