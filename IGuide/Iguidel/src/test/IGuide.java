/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
     
            parent = FXMLLoader.load(getClass().getResource("/gui/PackHome.fxml"));
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
