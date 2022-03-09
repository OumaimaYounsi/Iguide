/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Pack;
import entities.Service;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import sevices.PackCRUD;
import sevices.ServicesCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PackstatController implements Initializable {

    private DialogPack dialogPack;

    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
//      private List<Pack> getData() {
//        List<Pack> packItem = new ArrayList<>();
//        Pack p;
//        for (Pack pack : packData) {
//
//            p = new Pack();
//            p.setId(pack.getId());
//            p.setName(pack.getName());
//            p.setDesc(pack.getDesc());
//            p.setImage(pack.getImage());
//            p.setRating(pack.getRating());
//
//            packItem.add(p);
//
//        }
//        return packItem;
//
//    }
          public List<Pack> packData = new ArrayList<>();
           public List<Service> serviceData = new ArrayList<>();

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            PackCRUD  pcrud = new PackCRUD();
            ServicesCRUD scrud = new ServicesCRUD();
            packData.addAll(pcrud.showAllPacks());
            //serviceData.addAll(scrud.showAllServices());
            // TODO
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("Packs", packData.size()));
                           // new PieChart.Data("Services", serviceData.size()));
                            
            
            
            pieChartData.forEach(data ->
                    data.nameProperty().bind(
                            Bindings.concat(
                                    data.getName(), " amount: ", data.pieValueProperty()
                            )
                    )
            );
            
            pieChart.getData().addAll(pieChartData);
        } catch (SQLException ex) {
            Logger.getLogger(PackstatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeDialog(ActionEvent event) {
                dialogPack.onClickListener();
    }

    void setDataDialog(DialogPack dialogPack) {
        this.dialogPack=dialogPack;
    }
    }    
    

