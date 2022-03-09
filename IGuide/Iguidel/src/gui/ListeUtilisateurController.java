/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import entities.Administrateur;
import entities.Client;
import entities.Utilisateur;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sevices.ServiceAdministrateur;
import sevices.ServiceClient;
import sevices.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ListeUtilisateurController implements Initializable {
    
    
      
    
    @FXML
    private TableColumn<Utilisateur, String > nom;
    @FXML
    private TableColumn<Utilisateur, String> prenom;
    @FXML
    private TableColumn<Utilisateur, String> genre;
    @FXML
    private TableColumn<Utilisateur, String> role;
    @FXML
    private TableColumn<Utilisateur, Boolean> statut = new TableColumn<Utilisateur, Boolean>("statut");    
   
    @FXML
    private TextField recherche;
    @FXML
    private TableView<Utilisateur> table;
    @FXML
    private TableColumn<Utilisateur, String> mail;
    @FXML
    private Button Suspendre;
    ServiceUtilisateur sp = new ServiceUtilisateur();
    @FXML
    private TextField mdp;
    private TextField pays;
    @FXML
    private TextField roleA;
    @FXML
    private Button Ajouter;
    @FXML
    private DatePicker datedenaissance;
    @FXML
    private ComboBox gender;
    @FXML
    private TextField nomm;
    @FXML
    private TextField email;
    @FXML
    private TextField prenomm;
    @FXML
    private TextField payss;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> List =FXCollections.observableArrayList("Homme","Femme","Autre");
        gender.setItems(List);
    
    
        mail.setCellValueFactory(new PropertyValueFactory<>("login"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        genre.setCellValueFactory(new PropertyValueFactory<>("gender"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        
        
        List<Utilisateur> list = new ArrayList<>();
       
        try {
            list = sp.AfficherUtlisateur();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        ObservableList<Utilisateur> liste = FXCollections.observableArrayList(list);

        
        FilteredList<Utilisateur> filteredData = new FilteredList<>(liste, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
                
                
		recherche.textProperty().addListener(( observable,  oldValue,  newValue) -> {
                    filteredData.setPredicate( Utilisateur-> {
                        // If filter text is empty, display all persons.
                        
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        
                        // Compare first name and last name of every person with filter text.
                        String lowerCaseFilter = newValue.toLowerCase();
                        
                        if (Utilisateur.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                            return true; // Filter matches first name.
                        } else if (Utilisateur.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true; // Filter matches last name.
                        }else if (Utilisateur.getStatut()) {
                            return true; // Filter matches last name.
                        }
                        else if (Utilisateur.getRole().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true; // Filter matches last name.
                        }
                        else return false; // Does not match.
                    });
        });
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
                sortedData.comparatorProperty().bind(table.comparatorProperty());
                
		
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);
               
               
            System.out.println(sortedData);
       
        }

    @FXML
    private void Suspendre(ActionEvent event) {
        Utilisateur c= new Utilisateur();
        Utilisateur u= (Utilisateur) table.getSelectionModel().getSelectedItem();
         try {
            c = sp.modifierEtat(u, u.getStatut());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
         List<Utilisateur> list = new ArrayList<>();
       
        try {
            list = sp.AfficherUtlisateur();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        ObservableList<Utilisateur> liste = FXCollections.observableArrayList(list);
         
         
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
        
         ServiceAdministrateur aa= new ServiceAdministrateur();
         if (email.getText().equals("") || nomm.getText().equals("") || prenomm.getText().equals("") ||  mdp.getText().equals("") ||  payss.getText().equals("") ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Veuillez verifier votre inscription");
           alert.setContentText("verifier votre inscription");
           alert.show();
        }
        String g =gender.getSelectionModel().getSelectedItem().toString();
        String date = String.valueOf(datedenaissance.getDayCellFactory());
        String rolee = "Admin";
        Administrateur c = new Administrateur(email.getText(),mdp.getText(),nomm.getText(),prenomm.getText(),date,payss.getText(),g,true,rolee, roleA.getText());
          String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
          
          Pattern pa =Pattern.compile(masque);
         if( pa.matcher(email.getText()).matches() )
         
             
             {        System.err.println(c);
            
                       aa.ajouterAdministrateur(c);
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Success");
                       alert.setContentText("Person is added successfully!");
                       alert.show();
                 
             
        } 
                       
                        
                 
       else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Veuillez verifier votre inscription");
           alert.setContentText("verifier votre inscription");
           alert.show();
            
         }
    }

    }    
        
        
        
     
    

