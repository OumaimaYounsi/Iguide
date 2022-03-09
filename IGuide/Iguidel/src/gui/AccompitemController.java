/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Accompagnant;
import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AccompitemController implements Initializable {

    @FXML
    private Button reserverButton;
    @FXML
    private Button detailButton;
    @FXML
    private Label itemPackNom1;
    @FXML
    private Label itemPackNom2;
    @FXML
    private Label itemPackNom4;
    @FXML
    private Label itemAccompNom;
    @FXML
    private Label itemAccompExp;
    @FXML
    private Label itemAccompTarif;
    @FXML
    private ImageView Accompitemimages;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Utilisateur user;

    public void setData(Accompagnant p) {
        this.user = p;

        itemAccompNom.setText(p.getNom());
        itemAccompExp.setText("" + p.getExperence());
        itemAccompTarif.setText("" + p.getTarifdujour());
           Image imageAccomp = new Image(getClass().getResourceAsStream("/utils/"+user.getImage()));
       Accompitemimages.setImage(imageAccomp);
    }

}
