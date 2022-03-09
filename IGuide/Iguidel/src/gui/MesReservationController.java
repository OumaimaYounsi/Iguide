/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entites.ReservationPack;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import sevices.ReservationCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MesReservationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private List<ReservationPack> reservations = new ArrayList<>();
    @FXML
    private StackPane stackPane;

    @FXML
    private ScrollPane scrollReservation;
    @FXML
    private GridPane gridreservation;
    @FXML
    private TextField searchBar;
    private List<ReservationPack> getData() {
        List<ReservationPack> reservationitem = new ArrayList<>();
        ReservationPack r;
        for (ReservationPack reservation : reservationData) {

            r = new ReservationPack();
         //   m.setName(messages.getName());
          //  m.setDesc(messages.getDesc());

            reservationitem.add(r);

        }
        return reservationitem;

    }
    public List<ReservationPack> reservationData = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ReservationCRUD rcrud = new ReservationCRUD();
        try {
            reservationData = rcrud.afficherReservationPack();
        } catch (SQLException ex) {
            Logger.getLogger(MesReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        reservations.addAll(getData());
 /*       dialogPack = () -> {
            closeDialog.close();

            try {

                TimeUnit.MILLISECONDS.sleep(50);
                stackPane.toBack();
            } catch (InterruptedException ex) {

            }

        };*/

    
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < reservations.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("reservationitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                ReservationitemController messageitem = fxmlLoader.getController();
            //    itemPack.setData(messages.get(i));

                if (column == 2) {
                    column = 0;
                    row++;
                }
                gridreservation.add(anchorPane, column++, row);
                gridreservation.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridreservation.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridreservation.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridreservation.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridreservation.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridreservation.setMaxHeight(Region.USE_PREF_SIZE);
                gridreservation.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(MesReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onClickSearch(ActionEvent event) {
    }

   
}
    
    
    

