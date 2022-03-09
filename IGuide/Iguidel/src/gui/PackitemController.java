/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Pack;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sevices.PackCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PackitemController implements Initializable {

    @FXML
    private Label itemPackNom;

    @FXML
    private ImageView itemPackImage;

    @FXML
    private Button reserverButton;

    @FXML
    private Button detailButton;
    
    
     @FXML
    void ClickItemPack(ActionEvent event) {
        packListener.onClickListener(pack);

    }

    /**
     * Initializes the controller class.
     */
    private Pack pack;
    private PackListener  packListener;

    public void setData(Pack p , PackListener pa) {
        this.pack = p;
        this.packListener=pa;
        itemPackNom.setText(p.getName());
        
//   
     Image imagePack = new Image(getClass().getResourceAsStream("/utils/"+pack.getImage()));
       itemPackImage.setImage(imagePack);
//        
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
