/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iguide.desktop;

import entites.Pack;
import entites.Service;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.PackCRUD;
import services.ServicesCRUD;

/**
 *
 * @author user
 */
public class IguideDesktop extends Application {

     Parent parent;
    Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            parent = FXMLLoader.load(getClass().getResource("/views/Administration.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Add and Show Persons");
        stage.show();

    }

   public static void main(String[] args) {
        launch(args);
    }
   

//        Service s1 = new Service("aaaa", 12, new Date(2022 - 06 - 01), new Date(2022 - 06 - 01), "aaaaaa");
//        Service s2 = new Service("bbbb", 12, new Date(2022 - 05 - 05), new Date(2022 - 06 - 01), "bbbbbb");
//        Service s3 = new Service("cccc", 12, new Date(2022 - 05 - 12), new Date(2022 - 06 - 01), "cccccc");
//        scrud.addService(s1);
//        scrud.addService(s2);
//        scrud.addService(s3);
        // Pack p1 = new Pack("rondonné", "sidi bou s3id");
        //Pack p2 = new Pack("camping", "bizete", 5);
        //Pack p3 = new Pack("mariage", "hhhhhhhhhhhhhhhhhhhhh", 5);
        //  pcrud.addPack(p1);
        //pcrud.addPack(p2);
        //pcrud.addPack(p3);
        // pcrud.updatePack("trip", "Algerie",16);
        //pcrud.deletePack(6);
        // pcrud.updatePackService(4, 17);
        //System.out.println(pcrud.showAllPacks());
    

}
