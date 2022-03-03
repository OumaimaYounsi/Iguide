/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Feedback;
import java.sql.SQLException;
import entities.Message;
import java.sql.Date;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.chart.PieChart;
import sevices.FeedbackCrud;
import sevices.MessageCrud;
import utils.MyDB;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Med Amine
 */
public class IGuide extends Application {
/*
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
/*    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        LocalDate d = LocalDate.now();
        java.util.Date dd = java.sql.Date.valueOf(d);

        FeedbackCrud fcrud = new FeedbackCrud();
         Feedback f1 = new Feedback("samaaa", dd, 4);
         Feedback f2 = new Feedback("ali", dd, 14);
         Feedback f3 = new Feedback("toukebri", dd, 9);
         Feedback f4 = new Feedback("mas3oud", dd, 0);
         Feedback f5 = new Feedback("3othmen", dd, 3);
       
         /*   fcrud.ajouterFeedback(f1);
            fcrud.ajouterFeedback(f2);
            fcrud.ajouterFeedback(f3);
            fcrud.ajouterFeedback(f4);
            fcrud.ajouterFeedback(f5);
        */

         //fcrud.suprimerFeedback();
  /*      System.out.println(fcrud.Tri());
       MessageCrud mcrud = new MessageCrud();
       Message m1 = new Message ("toukebri",dd);
       m1.setId_message(3);
       m1.setContenu("new");
  //     mcrud.updateMessage(m1);
      
     
     
       // Message m1 = new Message();
        /*m1.setContenu("hahahahahahahhaahah");
  m1.setDate_message(dd);
         */
       // System.out.println("hahahah" + m1);
       // m1.setContenu("aaaaaaaaaaaaa");
       // m1.setDate_message(dd);
        //mcrud.ajouterMessage(m1);

       // nes2l monsieur System.out.println(mcrud.afficherMessage());

    Parent parent;
     Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            parent = FXMLLoader.load(getClass().getResource("/gui/message.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Ajouter Message");
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        launch(args);
    }

}
