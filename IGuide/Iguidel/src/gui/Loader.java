/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author USER
 */
public class Loader {
    
    private Pane view;
    
    public Pane getPage( String fileName){
        
        try {
            URL fileUrl = LoginFXMLController.class.getResource("/gui/"+fileName+".fxml");
            if(fileUrl == null ){
                throw new java.io.FileNotFoundException("file not found");
            }
            view= new FXMLLoader().load(fileUrl);
            
        
        
        }catch(Exception e)
        {
            System.out.println("no page");
        }
        
        return view;
        
    }
    
    
}
