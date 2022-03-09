/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Service;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ServiceitemController implements Initializable {

    @FXML
    private ImageView itemServiceImage;
    @FXML
    private Label itemServiceNom;
    @FXML
    private Button detailButton;
    @FXML
    private Button reserverButton;

     private Service service;
    private ServiceListener  serviceListener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ClickItemService(ActionEvent event) {
        serviceListener.onClickListener(service);
    }
    
     public void setData(Service s , ServiceListener sa) {
        this.service = s;
        this.serviceListener=sa;
        itemServiceNom.setText(s.getNom());
        
//   
     Image imageService = new Image(getClass().getResourceAsStream("/utils/"+service.getImage()));
       itemServiceImage.setImage(imageService);
//        
        

    }
}
