/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import entities.Service;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class DetailitemController implements Initializable {
    private DialogService dialogService;
    private Service service;
    @FXML
    private Label nom;
    @FXML
    private Label Lieu;
    @FXML
    private Label cible;
    @FXML
    private Label prix;
    @FXML
    private ImageView itemServiceImage;
    
     private DialogReservation res;
    @FXML
    private JFXButton closeButton;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickReserver(ActionEvent event) {
        res.onClickReservation();
    }

    @FXML
    private void closeDialog(ActionEvent event) {
        dialogService.onClickListener();
    }
    
     public void setDataDialog(Service service, DialogService s,DialogReservation d) {
        this.service = service;
        this.dialogService = s;

        nom.setText(service.getNom());
        cible.setText(service.getCible());
        Lieu.setText(service.getLieu());
       
        Image imageService = new Image(getClass().getResourceAsStream("/utils/"+service.getImage()));
       itemServiceImage.setImage(imageService);

}
     
}
