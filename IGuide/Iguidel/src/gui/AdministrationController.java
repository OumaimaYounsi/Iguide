/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import entities.Pack;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import sevices.PackCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AdministrationController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private JFXTextArea desc;

    @FXML
    private TableView<Pack> packsTable;
    @FXML
    private TableColumn<Pack, String> nameid;
    @FXML
    private TableColumn<Pack, String> descid;
    ObservableList<Pack> Packlist = FXCollections.observableArrayList();

    ValidationSupport validationSupport1 = new ValidationSupport();
    ValidationSupport validationSupport2 = new ValidationSupport();
    @FXML
    private StackPane stackPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        // TODO
        loadData();
    }

    private void refreshTable() {
        try {
            Packlist.clear();
            PackCRUD pcrud = new PackCRUD();

            List<Pack> packs = pcrud.showAllPacks();
            Packlist.setAll(packs);
            System.out.println(packs);
            packsTable.setItems(Packlist);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void loadData() {
        refreshTable();

        nameid.setCellValueFactory(new PropertyValueFactory<>("name"));
        descid.setCellValueFactory(new PropertyValueFactory<>("desc"));

    }

    String image = "";

    @FXML
    private void AjouterPack(ActionEvent event) {
        PackCRUD pcrud = new PackCRUD();
        Pack p1 = new Pack(name.getText(), desc.getText(), 1, image);
        if (name.getText().equals("")) {
            name.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            new animatefx.animation.Shake(name).play();
       
            /***************************/
            Image img = new Image("/utils/images.png", 50, 50, false, false);
                    Notifications notif; 
            notif = Notifications.create()
                    .graphic(new ImageView(img))
                    .title("succès")
                    .text("champ vide !")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_LEFT);
                    notif.showError();

        }else if(desc.getText().equals("")){
            name.setStyle(null);
             desc.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            new animatefx.animation.Shake(desc).play();
       
            /***************************/
            Image img = new Image("/utils/images.png", 50, 50, false, false);
                    Notifications notif;
            notif = Notifications.create()
                    .graphic(new ImageView(img))
                    .title("succès")
                    .text("champ vide !")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_LEFT);
                    notif.showError();
        
        
        
        }else {
                        desc.setStyle(null);

            try {
                pcrud.addPack(p1);
               Image img = new Image("/utils/images.png", 50, 50, false, false);
                    Notifications notif;
            notif = Notifications.create()
                    .graphic(new ImageView(img))
                    .title("succès")
                    .text("un pack est ajouté aves succès")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_LEFT);
                    notif.show();
                name.setText("");
                desc.setText("");
                refreshTable();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    @FXML
    void SupprimerPack(ActionEvent event) {
        try {
            PackCRUD pcrud = new PackCRUD();
            // System.out.println(packsTable.getSelectionModel().getSelectedItem().getId());
            Pack A = packsTable.getSelectionModel().getSelectedItem();

            if (pcrud.deletePack(packsTable.getSelectionModel().getSelectedItem().getId())) {
                            Image img = new Image("/utils/images.png", 50, 50, false, false);
                    Notifications notif;
            notif = Notifications.create()
                    .graphic(new ImageView(img))
                    .title("succès")
                    .text("un pack est supprimer aves succès")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_LEFT);
                    notif.show();
                packsTable.getItems().removeAll(packsTable.getSelectionModel().getSelectedItem());
                

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("La supression d'event n'a pas Ã©tÃ© effectuÃ©!");
                alert.showAndWait();

            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void ModifierPack(ActionEvent event) {
        Pack A = packsTable.getSelectionModel().getSelectedItem();
        PackCRUD aS = new PackCRUD();
        if (aS.updatePack(name.getText(), desc.getText(), A.getId())) {
                       Image img = new Image("/utils/images.png", 50, 50, false, false);
                    Notifications notif;
            notif = Notifications.create()
                    .graphic(new ImageView(img))
                    .title("succès")
                    .text(" pack modifié aves succès")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_LEFT);
                    notif.show();
            refreshTable();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("La modification d'event n'a pas ete effectue!");
            alert.showAndWait();
            refreshTable();
        }
    }

    @FXML
    void click(MouseEvent event) {

        name.setText(packsTable.getSelectionModel().getSelectedItem().getName());
        desc.setText(packsTable.getSelectionModel().getSelectedItem().getDesc());

    }

    @FXML
    private void uploadImage(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            File sourceFile = null;
            File destinationFile = null;
            String ImageName = path.substring(path.lastIndexOf('\\') + 1);
            File sourceImage = new File(path);

            System.out.println(ImageName);
            String newPath = "src/utils/";
            image = ImageName;

            File desImage = new File(newPath + ImageName);
            System.out.println(newPath + ImageName);

            try {
                Files.copy(sourceImage.toPath(), desImage.toPath());
            } catch (IOException ex) {
                System.out.println("err");
            }

        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }
    }
       private DialogPack dialogPack;
  


    JFXDialog closeDialog;
    @FXML
    private void onClickStatistique(ActionEvent event) {
           dialogPack = () -> {
            closeDialog.close();

            try {

                TimeUnit.MILLISECONDS.sleep(50);
                stackPane.toBack();
            } catch (InterruptedException ex) {

            }

        };
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("packstat.fxml"));

            AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();
            PackstatController itemDialog = fxmlLoader.getController();

            JFXDialogLayout dialogLayout = new JFXDialogLayout();
            dialogLayout.setBody(anchorPane);

            JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
             closeDialog = dialog;
            itemDialog.setDataDialog(dialogPack);
            dialog.show();
            stackPane.toFront();
            dialog.setOverlayClose(false);
        } catch (IOException ex) {
            Logger.getLogger(AdministrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
