/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entities.Service;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import sevices.ServiceServices;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class Admin_serviceController implements Initializable {
    
    Connection connexion;
    Statement stm;
    
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField nombremax;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker datefin;
    @FXML
    private JFXTextField lieu;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXComboBox<String> comboBox;
    @FXML
    private JFXTextField cible;
    @FXML
    private JFXButton ajouter;
    @FXML
    private Button modifier;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton uploadimage;
     @FXML
    private JFXTextField idservice;
     @FXML
    private TableColumn<Service, String> colid;
    @FXML
    private TableColumn<Service, String> colnom;
    @FXML
    private TableColumn<Service, Integer> colnombremax;
    @FXML
    private TableColumn<Service, Date> coldatedebut;
    @FXML
    private TableColumn<Service, Date> coldatefin;
    @FXML
    private TableColumn<Service, String> collieu;
    @FXML
    private TableColumn<Service, Float> colprix;
    @FXML
    private TableColumn<Service, String> colcategorie;
    @FXML
    private TableColumn<Service, String> colcible;
    @FXML
    private TableView<Service> tvservice;
    @FXML
    private TextField filterField;
    
    ObservableList<Service> list = getlistservices();
    ValidationSupport validationSupport= new ValidationSupport();
    ValidationSupport validationSupport1= new ValidationSupport();
    ValidationSupport validationSupport2= new ValidationSupport();
    ValidationSupport validationSupport3= new ValidationSupport();
    ValidationSupport validationSupport4= new ValidationSupport();
    ValidationSupport validationSupport5= new ValidationSupport();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validationSupport1.registerValidator(idservice, Validator.createEmptyValidator("Sasir l'id du service"));
        validationSupport2.registerValidator(nom, Validator.createEmptyValidator("Sasir le nom du service "));
      validationSupport3.registerValidator(nombremax, Validator.createEmptyValidator("Sasir le nombre max du service"));
      validationSupport4.registerValidator(lieu, Validator.createEmptyValidator("Sasir le lieu de service"));
      validationSupport5.registerValidator(prix , Validator.createEmptyValidator("Sasir le prix du service"));
   
        ObservableList<String> categorielist=FXCollections.observableArrayList("Restauration","Cinéma","Musée","Randonnée");  
         comboBox.setItems(categorielist);
         showService();
        
      
      validationSupport.registerValidator(datedebut, Validator.createEmptyValidator("Sasir la date debut du service"));
          validationSupport.registerValidator(datefin, Validator.createEmptyValidator("Sasir la date fin du service"));
              validationSupport.registerValidator(comboBox, Validator.createEmptyValidator("Sasir la catégorie du service"));
      validationSupport.registerValidator(cible, Validator.createEmptyValidator("Sasir la cible du service"));
      
         
      // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Service> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(service -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (service.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
                                else if (service.getLieu().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
                                else if (service.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (service.getCible().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
				else if (String.valueOf(service.getPrix()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; 
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Service> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tvservice.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tvservice.setItems(sortedData);
                
      
    }    
    
     
      private void showService() {
         ObservableList<Service> list = getlistservices();
        colid.setCellValueFactory(new PropertyValueFactory<>("idservice"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colnombremax.setCellValueFactory(new PropertyValueFactory<>("nombre_max"));
        coldatedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
        coldatefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        colcible.setCellValueFactory(new PropertyValueFactory<>("cible"));
        tvservice.setItems(list);
    }
      
      public ObservableList<Service> getlistservices()  {
       connexion  = MyDB.getInstance().getConnexion();
       ObservableList<Service> servicelist = FXCollections.observableArrayList();
        String req = "select * from service";
        Statement st;
        ResultSet rst;
        try {
            st = connexion.createStatement();
           rst = st.executeQuery(req);
        while (rst.next()) {
            Service s = new Service (rst.getInt("idservice"),
                    rst.getString("nom"),
                    rst.getInt("nombre_max"),
                    rst.getDate("datedebut"),
                    rst.getDate("datefin"),
                    rst.getString("cible"), 
                    rst.getString("lieu"),
                    rst.getString("categorie"),
                    rst.getFloat("prix"));
            servicelist.add(s);
        }}catch(Exception ex){
            ex.printStackTrace();}
        return servicelist;
    }
 
     String image="";
      @FXML  
    private void AjouterService(ActionEvent event) throws SQLException, IOException{
        ServiceServices ss= new  ServiceServices();
        
        LocalDate myDate = datedebut.getValue();
          System.out.println(myDate.toString());
           LocalDate myDate1 = datefin.getValue();
          System.out.println(myDate1.toString());
     
        try {
String req = "INSERT INTO `service`(`nom`, `nombre_max`, `datedebut`, `datefin`, `lieu`, `prix`, `categorie`, `cible`,`image`) VALUES "
               + "( '" + nom.getText()+"', '" +nombremax.getText()+"', '" +myDate+ "', '"+myDate1+ "', '" 
+lieu.getText()+ "', '" +prix.getText()+ "', '" +comboBox.getSelectionModel().getSelectedItem().toString() +"', '" +cible.getText()+ "', '" +image+ "') ";

       stm = connexion.createStatement();
        stm.executeUpdate(req); 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succés");
            alert.setContentText("le service est ajouté avec succés!");
            alert.show();
            showService();
             Notifications notificationBuilder =Notifications.create().title("Alert").text("Service ajouté").graphic(null).hideAfter(javafx.util.Duration.seconds(5)).position(Pos.TOP_LEFT)
                    .onAction(new EventHandler<ActionEvent>(){public void handle(ActionEvent event){
                    System.out.println("Cliked on");}});
            notificationBuilder.darkStyle();
            notificationBuilder.show();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       
       
    }

    }
     
    @FXML
    private void ModifierService(ActionEvent event) {
        LocalDate myDate = datedebut.getValue();
          System.out.println(myDate.toString());
           LocalDate myDate1 = datefin.getValue();
          System.out.println(myDate1.toString());
           try {
   String req = "UPDATE service set nom='" + nom.getText()+ "',nombre_max='" +nombremax.getText()+ "',datedebut='" + myDate+ "',datefin='" + myDate1+ "' ,lieu='" +lieu.getText()+"',prix='" +prix.getText()+"' ,categorie='" +comboBox.getSelectionModel().getSelectedItem().toString()+ "',cible='" +cible.getText()+"' where idservice='"+idservice.getText()+ "'";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
         Alert alert =new Alert(Alert.AlertType.CONFIRMATION, "Le service a été modifié avec succcès",javafx.scene.control.ButtonType.OK);
                       alert.showAndWait();
                       showService();
    }catch(Exception ex){
            ex.printStackTrace();}
    }
    
    
    @FXML
    private void SupprimerService(ActionEvent event) {
     try {
  String req = "DELETE FROM service WHERE idservice =" + idservice.getText() + "";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
     Alert alert =new Alert(Alert.AlertType.CONFIRMATION, "Le service a été supprimé avec succcès",javafx.scene.control.ButtonType.OK);
                       alert.showAndWait();
                       showService();
    }catch(Exception ex){
            ex.printStackTrace();}}

    @FXML
    private void uploadImage(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            File sourceFile = null;
            File destinationFile = null;
            String ImageName = path.substring(path.lastIndexOf('\\') + 1);
            File sourceImage = new File(path);
            
            System.out.println(ImageName);
             String newPath ="src/utils/";
             image=ImageName;
          
             File desImage= new File(newPath+ImageName);
             System.out.println(newPath+ImageName);
             

          
            
            try {
                Files.copy(sourceImage.toPath(), desImage.toPath());
            } catch (IOException ex) {
                System.out.println("err");
            }

        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }
    }
}
