/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Med Amine
 */
public class Message {
     
    
    public int id_message;
    public String contenu;
    public java.util.Date date_message;

    
    
    
    
    public Message(){}
    public Message(int id_message,String contenu,java.util.Date date_message){
        this.id_message=id_message;
        this.contenu=contenu;
        this.date_message=date_message;
    }

    public Message(String contenu, Date date_message) {
        this.contenu = contenu;
        this.date_message = date_message;
    }



    public int getId_message() {
        return id_message;
    }

    public String getContenu() {
        return contenu;
    }

    public java.util.Date getDate_message() {
        return date_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate_message(java.util.Date date_message) {
        this.date_message = date_message;
    }
    
  
    @Override
    public String toString() {
        return "Message{" +" contenu=" + contenu + ", date_message=" + date_message + '}';
    }

    public void ajouterMessage(Message m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      
}
