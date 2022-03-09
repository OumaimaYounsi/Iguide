/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Message;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sevices.MessageCrud;
import utils.MyDB;
import java.sql.SQLDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Med Amine
 */
public class AdminmessageController implements Initializable {


    /**
     * Initializes the controller class.
     */
    

Connection mc;
    PreparedStatement ste;
    @FXML
    private TextField filterField;
    @FXML
    private TableView<Message> tmessage;
    @FXML
    private TextField id_m;
    @FXML
    private TextField contenum;
    @FXML
    private TableColumn<Message,Integer> id_mg;
    @FXML
    private TableColumn<Message,String> con;
    @FXML
    private TableColumn<Message, java.sql.Date> date;
    @FXML
    private TableColumn<Message,Integer> idue;
    @FXML
    private TableColumn<Message,Integer> idur;
    @FXML
    private Button modifierm;
    @FXML
    private Button suprimerm;
    
    
    
    
    
    private ObservableList<Message> userData = FXCollections.observableArrayList();
    MessageCrud mcc = new MessageCrud() {
    };
    @FXML
    private ImageView ref;
    public AdminmessageController() {
        mc = MyDB.getInstance().getConnexion();
     
    }
    
 
    
    
      public ObservableList<Message> afficherMessage(){
          ObservableList<Message> message = FXCollections.observableArrayList();
       
        String sql="select * from message";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Message n = new Message();
                n.setId_message(rs.getInt("id_message"));
                n.setContenu(rs.getString("contenu"));
               n.setDate_message(rs.getDate("date_message"));
      
                message.add(n);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return message ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        // TODO
        List<Message> message = new ArrayList<>();
        message = mcc.afficherMessage();
        userData.clear();
        userData.addAll(message);
        tmessage.setItems(userData);
        id_mg.setCellValueFactory(
                new PropertyValueFactory<>("id_message")
        );
        con.setCellValueFactory(
                new PropertyValueFactory<>("Contenu")
        );
        date.setCellValueFactory(
                new PropertyValueFactory<>("date_message")
        );
        idue.setCellValueFactory(
                new PropertyValueFactory<>("id_u_envoyer")
        );
        idur.setCellValueFactory(
                new PropertyValueFactory<>("id_u_resevoir")
        );
        
        
    }

    @FXML
    private void mod_mes(ActionEvent event) {
        int id=Integer.parseInt(id_m.getText());
         String Contenu=contenum.getText();
         Message m = new Message(Contenu);
         MessageCrud mc = new MessageCrud () {};
         mc.updateMessages(id, Contenu);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success");
         alert.setContentText("Message is update successfully!");
         alert.show();
         contenum.setText("");
         
    }

    @FXML
    private void sup_mes(ActionEvent event) throws SQLException {
       
         MessageCrud mc = new MessageCrud () {};
       Message m = (Message) tmessage.getSelectionModel().getSelectedItem();
        int id_message = m.getId_message();
        mc.suprimerMessage(id_message);
        resetTableData(); 
        
    }

  public void resetTableData() throws SQLDataException, SQLException {
        List<Message> l = new ArrayList<>();
        l=mcc.afficherMessage();
        ObservableList<Message> data = FXCollections.observableArrayList(l);
        tmessage.setItems(data);
    }

    @FXML
    private void ref(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("adminmessage.fxml"));
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
