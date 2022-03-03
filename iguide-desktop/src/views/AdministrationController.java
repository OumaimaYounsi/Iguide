/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entites.Pack;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import services.PackCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AdministrationController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField desc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterPack(ActionEvent event) {
                PackCRUD pcrud = new PackCRUD();
                Pack p1 = new Pack(name.getText(),desc.getText());
                  try {
            pcrud.addPack(p1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Pack is added successfully!");
            alert.show();
            name.setText("");
            desc.setText("");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
