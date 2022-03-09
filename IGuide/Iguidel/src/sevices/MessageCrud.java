/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Message;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import utils.MyDB;


/**
 *
 * @author Med Amine
 */
public class MessageCrud {
    
    Connection mc;
    PreparedStatement ste;
    public MessageCrud() {
        mc = MyDB.getInstance().getConnexion();
     
    }
     public void ajouterMessage(Message m){

        String sql ="insert into message(contenu,date_message) Values(?,?)";
        try {
            ste=mc.prepareStatement(sql);
       //     ste.setInt(1, m.id_message);
            ste.setString(1, m.contenu);
            ste.setDate(2, (java.sql.Date) m.date_message);
            ste.executeUpdate();
            System.out.println("message ajouter");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }
     public List<Message> afficherMessage(){
        List<Message> message = new ArrayList<>();
        String sql="select * from message";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Message n = new Message();
                n.setId_message(rs.getInt("id_message"));
                n.setContenu(rs.getString("contenu"));
               n.setDate_message(rs.getDate("date_message"));
      
                message.add(n);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return message ;
    }    
      public List<Message> afficherMessage1(){
        List<Message> message = new ArrayList<>();
        String sql="select contenu ,date_message from message";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Message n = new Message();
             n.setId_message(rs.getInt("id_message"));
                n.setContenu(rs.getString("contenu"));
          n.setDate_message(rs.getDate("date_message"));
      
                message.add(n);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return message ;
    }    
     
     public List<Message> updateMessages(int id_message,String contenu){

     List<Message> Message = new ArrayList<>();
        try {
            String req = "UPDATE message SET contenu ='" + contenu
                    
                    + "' WHERE id_message =" + id_message;

            PreparedStatement pre = mc.prepareStatement(req);
            pre.executeUpdate();
            System.out.println("message Modifiée");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Message;
      }
    
    public List<Message> suprimerMessage(int id_message){
        List<Message> message = new ArrayList<>();
        String sql="DELETE FROM message WHERE id_message="+id_message;
        try {
             ste=mc.prepareStatement(sql);
             ste.executeUpdate();
             System.out.println("message supprimée");
          
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return message;
    }
    
}
