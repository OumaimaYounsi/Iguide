/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AdministrationController implements Initializable {

    @FXML
    private TableView<?> packsTable;
    @FXML
    private TableColumn<?, ?> nameid;
    @FXML
    private TableColumn<?, ?> descid;
    @FXML
    private TableColumn<?, ?> serviceid;
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
    }
    
}
