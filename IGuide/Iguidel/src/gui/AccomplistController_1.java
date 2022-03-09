/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import sevices.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class AccomplistController implements Initializable {
    
    private DialogService dialogService;
    @FXML
    private Label itemServiceNom;
    @FXML
    private Label itemServiceNom1;
    @FXML
    private Button detailButton;
    @FXML
    private Slider slider;
    @FXML
    private GridPane gridServiceAcc;

    private List<Utilisateur> users = new ArrayList<>();
    public List<Utilisateur> AccUsers = new ArrayList<>();
    
    
    
    private List<Utilisateur> getData() {
        List<Utilisateur> u = new ArrayList<>();
        Utilisateur s;
        for (Utilisateur user : AccUsers) {

            s = new Utilisateur();

            s.setNom(user.getNom());
            s.setTarifdujour(user.getTarifdujour());
            s.setDescriptif(user.getDescriptif());
            s.setRole_pro(user.getRole_pro());
            s.setExperience(user.getExperience());
            s.setImage(user.getImage());

            u.add(s);

        }
        return u;

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UtilisateurServices us = new UtilisateurServices();
        try {
            AccUsers = us.showAllAccomp();
        } catch (SQLException ex) {
            Logger.getLogger(AccomplistController.class.getName()).log(Level.SEVERE, null, ex);
        }
        users.addAll(getData());

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < users.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Accompitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                AccompitemController itemUser = fxmlLoader.getController();
                itemUser.setData(users.get(i));

                gridServiceAcc.add(anchorPane, column++, row);
                gridServiceAcc.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridServiceAcc.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridServiceAcc.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridServiceAcc.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridServiceAcc.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridServiceAcc.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiceHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void close(ActionEvent event) {
        dialogService.onClickListener();
    }
    private int sliderValue = 0;
    private List<Utilisateur> userFiltred;

    @FXML
    private void slidertarif(MouseEvent event) {
        sliderValue = (int) slider.getValue();

        userFiltred = new ArrayList<>();

        if (sliderValue == 0) {
            userFiltred = users;

        } else {

            for (Utilisateur u : users) {
                System.out.println(u.getTarifdujour());
                if (u.getTarifdujour() >= sliderValue) {
                  
                    userFiltred.add(u);

                }
            }
        }

        int column = 0;
        int row = 1;
        try {
            gridServiceAcc.getChildren().clear();
            for (int i = 0; i < userFiltred.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Accompitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                AccompitemController itemUser = fxmlLoader.getController();
                itemUser.setData(userFiltred.get(i));

                gridServiceAcc.add(anchorPane, column++, row);
                gridServiceAcc.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridServiceAcc.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridServiceAcc.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridServiceAcc.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridServiceAcc.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridServiceAcc.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiceHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

    @FXML
    private void closeDialog(ActionEvent event) {
        dialogService.onClickListener();
    }
    public void setDataAccom(DialogService s) {

        this.dialogService = s;

    }
}
