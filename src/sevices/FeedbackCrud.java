/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entities.Feedback;
import entities.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import utils.MyDB;
import java.util.Date;
/**
 *
 * @author Med Amine
 */
public class FeedbackCrud {
     Connection mc;
    PreparedStatement ste;
    
    public FeedbackCrud (){
      mc = MyDB.getInstance().getConnexion();
    
    
}
    
    
     public void ajouterFeedback(Feedback f)  {
        
     String sql = "insert into feedback(contenu,date_feedback,note,id_c,id_a,id_ac,id_s,id_p) Values(?,?,?,?,?,?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
          // ste.setInt(1, f.id_feedback );
            ste.setString(1, f.contenu);
            ste.setDate(2,(java.sql.Date)f.date_feedback);
            ste.setInt(3,f.note); 
            ste.setInt(4, f.id_c);
            ste.setInt(5, f.id_a);
            ste.setInt(6, f.id_ac);
            ste.setInt(7, f.id_s);
            ste.setInt(8, f.id_p);
            ste.executeUpdate();
            System.out.println("feedback ajouter");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }
     
     public List<Feedback> afficherFeedback(){
        List<Feedback> feedback = new ArrayList<>();
        String sql="select * from feedback";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Feedback AF = new Feedback();
                AF.setId_feedback(rs.getInt("id_feedback"));
                AF.setContenu(rs.getString("contenu"));
                AF.setDate_feedback(rs.getDate("date_feedback"));
                AF.setNote(rs.getInt("note"));
                AF.getId_c();
                AF.getId_a();
                AF.getId_ac();
                AF.getId_s();
                AF.getId_p();
                
      
                feedback.add(AF);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return feedback ;
    }    

     public List<Feedback> updateFeedback(Feedback f ){
        List<Feedback> feedback = new ArrayList<>();
        String sql="UPDATE feedback SET id_feedback = ?, contenu = ? WHERE id_feedback ="+f.getId_feedback();
         try {
            ste=mc.prepareStatement(sql);
            ste.setInt(1, f.getId_feedback());
            ste.setString(2, f.getContenu());
        //    ste.setString(3, f.getDate_feedback());
            ste.executeUpdate();
            System.out.println("feedback Modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return feedback;
      }

     public List<Feedback> suprimerFeedback(int id_feedback){
        List<Feedback> feedback = new ArrayList<>();
        String sql="DELETE FROM feedback WHERE id_feedback= "+id_feedback;
        try {
             ste=mc.prepareStatement(sql);
             ste.executeUpdate();
             System.out.println("feedback supprimée");
          
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return feedback;
    }
     
     
    
     
     public List<Feedback> Tri() throws SQLException {
        Comparator<Feedback> comparator = Comparator.comparing(Feedback::getNote);
        List<Feedback> Feedback = afficherFeedback();
        return Feedback.stream().sorted(comparator).collect(Collectors.toList());
    }
     
     
}
