/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Feedback;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sevices.FeedbackCrud;
import sevices.MessageCrud;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Med Amine
 */
public class AdminfeedbackController implements Initializable {
Connection mc;
    PreparedStatement ste;
    
    @FXML
    private TextField idf;
    @FXML
    private TextField contenuf;
    @FXML
    private Button modifierf;
    @FXML
    private Button suprimerf;
    @FXML
    private TableColumn<Feedback, Integer> id_fb;
    @FXML
    private TableColumn<Feedback, String> conf;
    @FXML
    private TableColumn<Feedback, java.sql.Date> datefeed;
  
    @FXML
    private TableColumn<Feedback, Integer> idc;
    @FXML
    private TableColumn<Feedback, Integer> ida;
    @FXML
    private TableColumn<Feedback, Integer> idac;
    @FXML
    private TableColumn<Feedback, Integer> ids;
    @FXML
    private TableColumn<Feedback, Integer> idp;
    @FXML
    private ImageView ref;
    @FXML
    private TableView<Feedback> tfeedback;

    
    
     private ObservableList<Feedback> userData = FXCollections.observableArrayList();
    FeedbackCrud mcc = new FeedbackCrud() {
    };
     public AdminfeedbackController() {
        mc = MyDB.getInstance().getConnexion();
    }
    
     
      public ObservableList<Feedback> afficherFeedback(){
          ObservableList<Feedback> message = FXCollections.observableArrayList();
       
        String sql="select * from feedback";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Feedback n = new Feedback();
                n.setId_feedback(rs.getInt("id_feedback"));
                n.setContenu(rs.getString("contenu"));
               n.setDate_feedback(rs.getDate("date_feedback"));
              
      
                message.add(n);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return message ;
    } 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         List<Feedback> feedback = new ArrayList<>();
        feedback = mcc.afficherFeedback();
        userData.clear();
        userData.addAll(feedback);
        tfeedback.setItems(userData);
        id_fb.setCellValueFactory(
                new PropertyValueFactory<>("id_feedback")
        );
        conf.setCellValueFactory(
                new PropertyValueFactory<>("Contenu")
        );
        datefeed.setCellValueFactory(
                new PropertyValueFactory<>("date_feedback")
        );
      
      
        idc.setCellValueFactory(
                new PropertyValueFactory<>("id_c")
        );
        ida.setCellValueFactory(
                new PropertyValueFactory<>("id_a")
        );
        idac.setCellValueFactory(
                new PropertyValueFactory<>("id_ac")
        );
        ids.setCellValueFactory(
                new PropertyValueFactory<>("id_s")
        );
        idp.setCellValueFactory(
                new PropertyValueFactory<>("id_p")
        );
        
        
    }
    

    @FXML
    private void mod_feed(ActionEvent event) {
         int id=Integer.parseInt(idf.getText());
         System.out.println(id);
         String Contenu=contenuf.getText();  
         System.out.println(Contenu);
         Feedback f = new Feedback(id,Contenu );
         FeedbackCrud fd = new FeedbackCrud () {};
         fd.updateFeedback(id, Contenu);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success");
         alert.setContentText("Feedback is update successfully!");
         alert.show();
         contenuf.setText("");
    }

    @FXML
    private void sup_feed(ActionEvent event) throws SQLException {
            FeedbackCrud mc = new FeedbackCrud () {};
       Feedback m = (Feedback) tfeedback.getSelectionModel().getSelectedItem();
        int id_feedback = m.getId_feedback();
        mc.suprimerFeedback(id_feedback);
        resetTableData(); 
    }
    public void resetTableData() throws SQLDataException, SQLException {
        List<Feedback> l = new ArrayList<>();
        l=mcc.afficherFeedback();
        ObservableList<Feedback> data = FXCollections.observableArrayList(l);
        tfeedback.setItems(data);
    }
 
    @FXML
    private void ref(MouseEvent event) {
      Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("adminfeedback.fxml"));
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
