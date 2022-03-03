/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Service;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sevices.ServiceServices;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class FXML_serviceController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfnombremax;
    @FXML
    private TextField tfdatedebut;
    @FXML
    private TextField tfdatefin;
    @FXML
    private TextField tflieu;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfcategorie;
    @FXML
    private TextField tfcible;
    private TableView<Service> tvservice;
    private TableColumn<Service, Integer> colid;
    private TableColumn<Service, String> colnom;
    private TableColumn<Service, Integer> colnombremax;
    private TableColumn<Service, Date> coldatedebut;
    private TableColumn<Service, Date> coldatefin;
    private TableColumn<Service, String> collieu;
    private TableColumn<Service, Float> colprix;
    private TableColumn<Service, Categorie> colcategorie;
    private TableColumn<Service, String> colcible;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TableView<?> tvservice1;
    @FXML
    private TableColumn<?, ?> colid1;
    @FXML
    private TableColumn<?, ?> colnom1;
    @FXML
    private TableColumn<?, ?> colnombremax1;
    @FXML
    private TableColumn<?, ?> coldatedebut1;
    @FXML
    private TableColumn<?, ?> coldatefin1;
    @FXML
    private TableColumn<?, ?> collieu1;
    @FXML
    private TableColumn<?, ?> colprix1;
    @FXML
    private TableColumn<?, ?> colcategorie1;
    @FXML
    private TableColumn<?, ?> colcible1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            showServices();
        } catch (SQLException ex) {
            Logger.getLogger(FXML_serviceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void HundleButtonAction(ActionEvent event) throws SQLException {
        if(event.getSource() == btnajouter){
            insertRecord();
        }else if (event.getSource() == btnmodifier){
            updateRecord();
        }else if(event.getSource() == btnsupprimer){
            deleteButton();
        }
    }
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iguide", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    
    public void showServices() throws SQLException{
        ServiceServices ss= new ServiceServices();
        Service s = new Service();
        colid.setCellValueFactory(new PropertyValueFactory<>("idservice"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colnombremax.setCellValueFactory(new PropertyValueFactory<>("nombre_max"));
        coldatedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
        coldatefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        colcible.setCellValueFactory(new PropertyValueFactory<>("cible"));
        
        ObservableList<Service> list = ss.AfficherService();

        tvservice.setItems(list);
    }
    
    private void insertRecord() throws SQLException{
        String query = "INSERT INTO service VALUES ( '" + tfid.getText() + "','" + tfnom.getText() +"','"+ tfnombremax.getText()+  "','" 
                +tfdatedebut.getText()+ "','" + tfdatefin.getText()+  "','"+ tflieu.getText()+ "','"+ tfprix.getText()+ "','"+ tfcategorie.getText()+ "," + tfcible.getText()+ "') ";
        executeQuery(query);
        showServices();
    }
    
    private void updateRecord() throws SQLException{
        String query = "UPDATE  service SET nom  = '" + tfnom.getText() + "', nombre_max = '" + tfnombremax.getText() + "', datedebut = " +
                tfdatedebut.getText() + ", datefin = " + tfdatefin.getText() + " , lieu = " + tflieu.getText() + " , prix = " + tfprix.getText() + " , categorie = " + tfcategorie.getText() + " , cible = " + tfcible.getText() + " WHERE idservice = " + tfid.getText() + "";
        executeQuery(query);
        showServices();
    }
    private void deleteButton() throws SQLException{
        String query = "DELETE FROM service WHERE idservice =" + tfid.getText() + "";
        executeQuery(query);
        showServices();
    }
    
     private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

