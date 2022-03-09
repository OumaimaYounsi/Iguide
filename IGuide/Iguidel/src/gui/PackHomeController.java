/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Pack;
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
import sevices.PackCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PackHomeController implements Initializable {

    private PackListener packListener;
    @FXML
    private ScrollPane scrollPack;
    @FXML
    private GridPane gridPack;

    @FXML
    private StackPane stackPane;

    @FXML
    private TextField searchBar;

    JFXDialog closeDialog;

    private DialogPack dialogPack;
    private DialogReservation res;

    /**
     * Initializes the controller class.
     */
    private List<Pack> packs = new ArrayList<>();

    private List<Pack> getData() {
        List<Pack> packItem = new ArrayList<>();
        Pack p;
        for (Pack pack : packData) {

            p = new Pack();
            p.setId(pack.getId());
            p.setName(pack.getName());
            p.setDesc(pack.getDesc());
            p.setImage(pack.getImage());
            p.setRating(pack.getRating());

            packItem.add(p);

        }
        return packItem;

    }
    public List<Pack> packData = new ArrayList<>();
    public List<Pack> filtredSearch = new ArrayList<>();

    void onClickSearch(ActionEvent event) {
        filtredSearch = new ArrayList<>();
        if (searchBar.getText().equals("")) {
            filtredSearch = packs;
        } else {
            for (Pack p : packs) {
                if (p.getName().contains(searchBar.getText())) {
                    filtredSearch.add(p);
                }
            }

        }

        System.out.println(filtredSearch);

        int column = 0;
        int row = 1;
        gridPack.getChildren().clear();

        try {
            for (int i = 0; i < filtredSearch.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Packitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                PackitemController itemPack = fxmlLoader.getController();
                itemPack.setData(filtredSearch.get(i), packListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridPack.add(anchorPane, column++, row);
                gridPack.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPack.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPack.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridPack.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPack.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPack.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(PackHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PackCRUD pcrud = new PackCRUD();

        try {
            packData = pcrud.showAllPacks();
            System.out.println(packData);   
        } catch (SQLException ex) {
            System.out.println("err");
        }

        packs.addAll(getData());
        dialogPack = () -> {
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
                    itemDialog.setDataAccom(dialogPack);
                stackPane.toFront();
                dialog.setOverlayClose(false);
                dialog.show();

                try {

                    TimeUnit.MILLISECONDS.sleep(50);
                    // stackPane.toBack();
                } catch (InterruptedException ex) {

                }

            } catch (IOException ex) {
                Logger.getLogger(PackHomeController.class.getName()).log(Level.SEVERE, null, ex);

            }

        };
        packListener = new PackListener() {
            @Override
            public void onClickListener(Pack pack) {
                try {

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Detailitem.fxml"));

                    AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                    DetailitemController itemDialog = fxmlLoader.getController();

                    JFXDialogLayout dialogLayout = new JFXDialogLayout();
                    dialogLayout.setBody(anchorPane);

                    JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
                    closeDialog = dialog;
                    itemDialog.setDataDialog(pack, dialogPack, res);
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
            for (int i = 0; i < packs.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Packitem.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
                PackitemController itemPack = fxmlLoader.getController();
                itemPack.setData(packs.get(i), packListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridPack.add(anchorPane, column++, row);
                gridPack.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPack.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPack.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridPack.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPack.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPack.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(25));
            }
        } catch (IOException ex) {
            Logger.getLogger(PackHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
