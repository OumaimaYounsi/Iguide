/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/*import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;*/
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import entites.ReservationPack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import sevices.ReservationCRUD;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReservationitemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private ReservationPack reserv;
    @FXML
    private Button detailButton;
    @FXML
    private AnchorPane aaa;
    @FXML
    private Button AnnulerReservation;

    public void setData(ReservationPack p) {
        this.reserv = p;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void imprimerRecu(ActionEvent event)  {

       System.out.println("To Printer!");
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            Window primaryStage = null;
            job.showPrintDialog(primaryStage);
            aaa.setVisible(true);
            Node root = aaa;
            job.printPage(root);
            job.endJob();
        }
    }

    @FXML
    private void annuler(ActionEvent event) {
        
       /* ReservationCRUD mc = new ReservationCRUD () {};
        ReservationPack m = (ReservationPack) aaa.getSelectionModel().getSelectedItem();
        int id = m.getId_res_pack();
        mc.suprimerReservation(id);
        resetTableData();*/
    }
    
    

}
