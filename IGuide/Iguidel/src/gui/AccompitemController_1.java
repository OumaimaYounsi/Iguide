/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class AccompitemController implements Initializable {

    @FXML
    private Label itemAccompNom;
    @FXML
    private Label itemServiceNom1;
    @FXML
    private Label itemAccompExp;
    @FXML
    private Label itemServiceNom2;
    @FXML
    private Label itemAccompTarif;
    @FXML
    private Label itemServiceNom3;
    @FXML
    private Button detailButton;
    @FXML
    private Button reserverButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     private Utilisateur user;

    public void setData(Utilisateur p) {
        this.user = p;

        itemAccompNom.setText(p.getNom());
        itemAccompExp.setText("" + p.getExperience());
        itemAccompTarif.setText("" + p.getTarifdujour());
    }
    
}
