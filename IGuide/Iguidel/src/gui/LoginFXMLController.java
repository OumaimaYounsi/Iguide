/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import entities.Client;
import entities.Resultattest;
import entities.Utilisateur;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import sevices.ServiceClient;
import sevices.ServiceUtilisateur;
import sun.security.util.Password;

/**
 *
 * @author USER
 */
public class LoginFXMLController implements Initializable{
    
    @FXML
    private javafx.scene.control.TextField loginEnter;

    @FXML
    private PasswordField motdepasseEntrer;

    @FXML
    private Button login;
    @FXML
    private Label validation;
    
    Parent parent;
     Stage stage;
    @FXML
    private Button cree;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    

    @FXML
    private void login(javafx.event.ActionEvent event) throws IOException {
        Utilisateur Utilisateur = new Utilisateur();
        ServiceUtilisateur sc= new ServiceUtilisateur();
        Utilisateur c = new Utilisateur(loginEnter.getText(),motdepasseEntrer.getText());
        try {
                      Utilisateur= sc.loginUtilisateur(loginEnter.getText(), motdepasseEntrer.getText());
                      
                       
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
        
        System.err.println(Utilisateur);
        
       int Id =Utilisateur.getId();
       
     //  String ids = String.valueOf(Id);
       
       
       
       
       if (!"".equals(Utilisateur.getNom()) && Utilisateur.getRole().equals("Admin"))
        {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainAdmin.fxml"));
        parent = loader.load();
        MainController main= loader.getController();
        main.idDet(Utilisateur);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
        System.out.println("oui");
        }
      else if (!"".equals(Utilisateur.getNom()) && Utilisateur.getRole().equals("Client"))
        {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainCLient.fxml"));
        parent = loader.load();
        MainCLientController main= loader.getController();
        main.idDet(Utilisateur);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
        System.out.println("oui");
        }
      else if (!"".equals(Utilisateur.getNom()) && Utilisateur.getRole().equals("Accompagnant"))
        {
               System.out.println("oui");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainAccompagnant.fxml"));
        parent = loader.load();
        MainAccampagnantController main= loader.getController();
        main.idDet(Utilisateur);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        }
        
        else if (!"".equals(Utilisateur.getNom()) && Utilisateur.getRole().equals("Proprietaire"))
        {
   
           FXMLLoader loader = new FXMLLoader(getClass().getResource("MainProprietaire.fxml"));
        parent = loader.load();
        MainProrietaireController main= loader.getController();
        main.idDet(Utilisateur);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
        System.out.println("oui");
        }
        else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Veuillez verifier votre login");
           alert.setContentText("Veuillez verifier votre login");
           alert.show();
            System.out.println("non");
            System.out.println(motdepasseEntrer.getText());
        }
    }

    @FXML
    private void cree_un_compte(javafx.event.ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("Acceil.fxml"));
        Scene scene = new Scene(parent);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stage.setScene(scene);
        stage.setTitle("Cree compte");
        stage.show();
    }
    
    
}
