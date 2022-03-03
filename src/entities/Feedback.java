/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

//import java.sql.Date;
import javafx.scene.chart.PieChart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Med Amine
 */
public class Feedback {

    public static Object stream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    public int id_feedback;
    public String contenu;
    public java.util.Date date_feedback;
    public int note;	
    public int id_c;
    public int id_a ;       
    public int id_ac ;
    public int id_s;
    public int id_p;       

            
            
            
    public Feedback(){}
    
    
     public Feedback(int id_feedback, String contenu, java.util.Date date_feedback, int note, int id_c, int id_a, int id_ac, int id_s, int id_p) {
        this.id_feedback = id_feedback;
        this.contenu = contenu;
        this.date_feedback = date_feedback;
        this.note = note;
        this.id_c = id_c;
        this.id_a = id_a;
        this.id_ac = id_ac;
        this.id_s = id_s;
        this.id_p = id_p;
    }

   
    public Feedback(String contenu, java.util.Date date_feedback, int note, int id_c, int id_a, int id_ac, int id_s, int id_p) {
        this.contenu = contenu;
        this.date_feedback = date_feedback;
        this.note = note;
         this.id_c = id_c;
        this.id_a = id_a;
        this.id_ac = id_ac;
        this.id_s = id_s;
        this.id_p = id_p;
    }

   
      

    public int getId_feedback() {
        return id_feedback;
    }

    public String getContenu() {
        return contenu;
    }

    public java.util.Date getDate_feedback() {
        return date_feedback;
    }

    public int getNote() {
        return note;
    }

     public int getId_c() {
        return id_c;
    }

    public int getId_a() {
        return id_a;
    }

    public int getId_ac() {
        return id_ac;
    }

    public int getId_s() {
        return id_s;
    }

    public int getId_p() {
        return id_p;
    }
    
    public void setId_feedback(int id_feedback) {
        this.id_feedback = id_feedback;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate_feedback(java.util.Date date_feedback) {
        this.date_feedback = date_feedback;
    }

    public void setNote(int note) {
        this.note = note;
    }

     public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public void setId_ac(int id_ac) {
        this.id_ac = id_ac;
    }

    public void setId_s(int id_s) {
        this.id_s = id_s;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    @Override
    public String toString() {
        return "Feedback{" + ", contenu=" + contenu + ", date_feedback=" + date_feedback + ", note=" + note + ", id_c=" + id_c + ", id_a=" + id_a + ", id_ac=" + id_ac + ", id_s=" + id_s + ", id_p=" + id_p + '}';
    }

    
    
    
  
      
    }
    
    
    
    
    
    
    

