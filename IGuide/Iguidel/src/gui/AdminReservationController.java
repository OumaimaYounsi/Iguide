/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import entites.ReservationPack;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import sevices.ReservationCRUD;
import utils.DBConnection;


/**
 * FXML Controller class
 *
 * @author user
 */
public class AdminReservationController implements Initializable {

    Connection mc;
    PreparedStatement ste;
    
   
    @FXML
    private TableView<ReservationPack> tableView;
    @FXML
    private TableColumn<ReservationPack, Integer> idReservation;
    @FXML
    private TableColumn<ReservationPack, Integer> idPack;
    @FXML
    private TableColumn<ReservationPack, Date > date;
    @FXML
    private TableColumn<ReservationPack, Integer> idClient;
    @FXML
    private TableColumn<ReservationPack, Integer> idAccomp;
    @FXML
    private TextField idR;
    @FXML
    private DatePicker inputDate;
    @FXML
    private JFXButton modifR;
    @FXML
    private JFXButton annulerR;
  
    
    private ObservableList<ReservationPack> userData = FXCollections.observableArrayList();
     ReservationCRUD mcc = new ReservationCRUD() {
    };
    @FXML
    private ImageView ref;
     public AdminReservationController() {
        mc = DBConnection.getInstance().getConnection();
    }

    /**
     * Initializes the controller class.
     */
     /*
     public ObservableList<ReservationPack> afficherReservation(){
          ObservableList<ReservationPack> reservation = FXCollections.observableArrayList();
       
        String sql="select * from reservationpack ;";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                ReservationPack n = new ReservationPack();
                n.setId_res_pack(rs.getInt("id"));
                n.setDate_pack(rs.getDate("date_pack"));
                n.setId_client(rs.getInt("id_client"));
                n.setId_accomp(rs.getInt("id_accomp"));
              
      
                reservation.add(n);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return reservation ;
    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        List<ReservationPack> ReservationPack = new ArrayList<>();
        try {
            ReservationPack = mcc.afficherReservationPack();
        } catch (SQLException ex) {
            Logger.getLogger(AdminReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.clear();
        userData.addAll(ReservationPack);
        tableView.setItems(userData);
        
        
        
        idReservation.setCellValueFactory(
                new PropertyValueFactory<>("id_res_pack")
        );
        idPack.setCellValueFactory(
                new PropertyValueFactory<>("id_pack")
        );
        date.setCellValueFactory(
                new PropertyValueFactory<>("date_pack")
        );
      
      
        idClient.setCellValueFactory(
                new PropertyValueFactory<>("id_client")
        );
        idAccomp.setCellValueFactory(
                new PropertyValueFactory<>("id_accomp")
        );
        
        
    }    

    @FXML
    private void onClickSearch(ActionEvent event) {
    }

    @FXML
    private void ref(MouseEvent event) {
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AdminReservation.fxml"));
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

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        
        
        
        LocalDate mydate = inputDate.getValue();
        System.out.println(mydate.toString());
        int id=Integer.parseInt(idR.getText());
        try {
            String req = "UPDATE reservationpack SET date_pack ='" + mydate
                    
                    + "' WHERE id =" + id;
             PreparedStatement pre = mc.prepareStatement(req);
              pre.executeUpdate();
             System.out.println("Reservation modifié");
             Notifications notificationBuilder =Notifications.create().title("Alert").text("Reservation Modifiée").graphic(null).hideAfter(javafx.util.Duration.seconds(5)).position(Pos.TOP_LEFT)
                    .onAction(new EventHandler<ActionEvent>(){public void handle(ActionEvent event){
                    System.out.println("Cliked on");}});
            notificationBuilder.darkStyle();
            notificationBuilder.show();
         } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    
        
        
        
        

       /* int id=Integer.parseInt(idR.getText());
         LocalDate mydate  = inputDate.getValue();
         ReservationPack m = new ReservationPack (inputDate);
         ReservationCRUD mc = new ReservationCRUD () {};
         mc.updateReservation(id, mydate);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success");
         alert.setContentText("Message is update successfully!");
         alert.show();
         inputDate.setValue("");*/
        
       
    }

    @FXML
    private void annuler(ActionEvent event) throws SQLException {
        
       ReservationCRUD mc = new ReservationCRUD () {};
       ReservationPack m = (ReservationPack) tableView.getSelectionModel().getSelectedItem();
        int id = m.getId_res_pack();
        mc.suprimerReservation(id);
        resetTableData();
    }
 
    public void resetTableData() throws SQLDataException, SQLException {
        List<ReservationPack> l = new ArrayList<>();
        l=mcc.afficherReservationPack();
        ObservableList<ReservationPack> data = FXCollections.observableArrayList(l);
        tableView.setItems(data);
    }

    @FXML
    private Date getDate() {
        return null;
        
        
    }
}
