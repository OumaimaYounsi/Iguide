/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import entities.Service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
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
import sevices.ServiceServices;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ServiceHomeController implements Initializable {
    private ServiceListener serviceListener;
    @FXML
    private TextField searchBar;
    @FXML
    private ScrollPane scrollService;
    @FXML
    private StackPane stackPane;
    @FXML
    private GridPane gridService;
    
    JFXDialog closeDialog;

    private DialogService dialogService;
    private DialogReservation res;

       private List<Service> services = new ArrayList<>();
       public List<Service> serviceData = new ArrayList<>();
    public List<Service> filtredSearch = new ArrayList<>();

    private List<Service> getData() {
        List<Service> serviceItem = new ArrayList<>();
        Service s;
        for (Service service : serviceData) {

            s = new Service();
            s.setNom(service.getNom());
            s.setCible(service.getCible());
            s.setImage(service.getImage());

            serviceItem.add(s);

        }
        return serviceItem;

    }
       

    @FXML
    private void onClickSearch(ActionEvent event) {
        filtredSearch = new ArrayList<>();
        if (searchBar.getText().equals("")) {
            filtredSearch = services;
        } else {
            for (Service s : services) {
                if (s.getNom().contains(searchBar.getText())) {
                    filtredSearch.add(s);
                }
            }

        }
        System.out.println(filtredSearch);

        int column = 0;
        int row = 1;
        gridService.getChildren().clear();

        try {
            for (int i = 0; i < filtredSearch.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Serviceitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                ServiceitemController itemService = fxmlLoader.getController();
                itemService.setData(filtredSearch.get(i), serviceListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridService.add(anchorPane, column++, row);
                gridService.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridService.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridService.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridService.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridService.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridService.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiceHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceServices ss = new ServiceServices();
        try {
            serviceData = ss.AfficherService();
        } catch (SQLException ex) {
            System.out.println("err");
        }

        services.addAll(getData());
        dialogService = () -> {
            closeDialog.close();

            try {

                TimeUnit.MILLISECONDS.sleep(50);
                stackPane.toBack();
            } catch (InterruptedException ex) {

            }

        };
        

        res = () -> {
            try {
                closeDialog.close();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Accomplist.fxml"));

                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                AccomplistController itemDialog = fxmlLoader.getController();

                JFXDialogLayout dialogLayout = new JFXDialogLayout();
                dialogLayout.setBody(anchorPane);

                JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
                 closeDialog = dialog;
                    itemDialog.setDataAccom(dialogService);
                stackPane.toFront();
                dialog.setOverlayClose(false);
                dialog.show();

                try {

                    TimeUnit.MILLISECONDS.sleep(50);
                    // stackPane.toBack();
                } catch (InterruptedException ex) {

                }

            } catch (IOException ex) {
                Logger.getLogger(ServiceHomeController.class.getName()).log(Level.SEVERE, null, ex);

            }

        };
    
    
           serviceListener = new ServiceListener() {
            @Override
            public void onClickListener(Service service) {
                try {

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Detailitem.fxml"));

                    AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                    DetailitemController itemDialog = fxmlLoader.getController();

                    JFXDialogLayout dialogLayout = new JFXDialogLayout();
                    dialogLayout.setBody(anchorPane);

                    JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
                    closeDialog = dialog;
                    itemDialog.setDataDialog(service, dialogService, res);
                    dialog.show();
                    stackPane.toFront();
                    dialog.setOverlayClose(false);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

        };
           int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < services.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Serviceitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                ServiceitemController itemService = fxmlLoader.getController();
                itemService.setData(services.get(i), serviceListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridService.add(anchorPane, column++, row);
                gridService.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridService.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridService.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridService.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridService.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridService.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiceHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    }
      

