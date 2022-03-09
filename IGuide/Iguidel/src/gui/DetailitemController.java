/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import entities.Pack;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import sevices.PackCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DetailitemController implements Initializable {

    private DialogPack dialogPack;
    private Pack pack;

    @FXML
    private Label nomPack;

    @FXML
    private Label descPack;
    @FXML
    private ImageView itemPackImage;
    @FXML
    private Rating ratinggg;

    @FXML
    void closeDialog(ActionEvent event) {
        dialogPack.onClickListener();

    }
    
      @FXML
    void onClickReserver(ActionEvent event) {
        res.onClickReservation();
        
        

    }

    public void setDataDialog(Pack pack, DialogPack p ,DialogReservation d) {
        this.pack = pack;
        this.dialogPack = p;
        this.res = d;
        ratinggg.setRating(pack.getRating());
        nomPack.setText(pack.getName());
        descPack.setText(pack.getDesc());
         Image imagePack = new Image(getClass().getResourceAsStream("/utils/"+pack.getImage()));
       itemPackImage.setImage(imagePack);

    }

    private DialogReservation res;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void rat(ActionEvent event) {
        
        
        PackCRUD aS = new PackCRUD();
        System.out.println( pack);
        if (aS.updatePackrating((int) ratinggg.getRating(), pack.getId())) {
                 Image img = new Image("/utils/images.png", 50, 50, false, false);
                    Notifications notif;
            notif = Notifications.create()
                    .graphic(new ImageView(img))
                    .title("succès")
                    .text(" succès")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_LEFT);
                    notif.show();
          
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                Image img = new Image("/utils/images.png", 50, 50, false, false);
                    Notifications notif;
            notif = Notifications.create()
                    .graphic(new ImageView(img))
                    .title("succès")
                    .text(" Erreur")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_LEFT);
                    notif.showError();
          
        }
    }

}
