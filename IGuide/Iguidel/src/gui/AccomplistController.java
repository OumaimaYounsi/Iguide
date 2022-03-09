/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Accompagnant;
import entities.Pack;
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
import sevices.UtilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AccomplistController implements Initializable {

    private DialogPack dialogPack;
    @FXML
    private Label itemPackNom;
    @FXML
    private Label itemPackNom1;
    @FXML
    private Button detailButton;
    @FXML
    private GridPane gridPackAcc;

    private List<Accompagnant> users = new ArrayList<>();
    public List<Accompagnant> AccUsers = new ArrayList<>();
    @FXML
    private Slider slider;

    private List<Accompagnant> getData() {
        List<Accompagnant> u = new ArrayList<>();
        Accompagnant p;
        for (Accompagnant user : AccUsers) {

            p = new Accompagnant();

            p.setNom(user.getNom());
            p.setPrenom(user.getPrenom());
            p.setTarifdujour(user.getTarifdujour());
            p.setExperence(user.getExperence());
            p.setImage(user.getImage());

            u.add(p);

        }
        return u;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        UtilisateurCRUD ucrud = new UtilisateurCRUD();
       
        try {
            AccUsers = ucrud.showAllAccomp();
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

                gridPackAcc.add(anchorPane, column++, row);
                gridPackAcc.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPackAcc.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPackAcc.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridPackAcc.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPackAcc.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPackAcc.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(PackHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeDialog(ActionEvent event) {
        dialogPack.onClickListener();
    }

    public void setDataAccom(DialogPack p) {

        this.dialogPack = p;

    }

    @FXML
    private void close(ActionEvent event) {
        dialogPack.onClickListener();
    }

    private int sliderValue = 0;
    private List<Accompagnant> userFiltred;

    @FXML
    private void slidertarif(MouseEvent event) {
        sliderValue = (int) slider.getValue();

        userFiltred = new ArrayList<>();

        if (sliderValue == 0) {
            userFiltred = users;

        } else {

            for (Accompagnant u : users) {
                System.out.println(u.getTarifdujour());
                if (u.getTarifdujour() >= sliderValue) {
                  
                    userFiltred.add(u);

                }
            }
        }

        int column = 0;
        int row = 1;
        try {
            gridPackAcc.getChildren().clear();
            for (int i = 0; i < userFiltred.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Accompitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                AccompitemController itemUser = fxmlLoader.getController();
                itemUser.setData(userFiltred.get(i));

                gridPackAcc.add(anchorPane, column++, row);
                gridPackAcc.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPackAcc.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPackAcc.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridPackAcc.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPackAcc.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPackAcc.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(PackHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
