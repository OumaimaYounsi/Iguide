/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;
import java.util.HashSet;
import entities.Pack;
import java.util.Set;

/**
 *
 * @author USER
 */
public class Reservation_pack {
   private int id_res_pack;
   private Date date_pack; 
   private int id_client;
   private int id_accomp;
   private int id_pack;

    public Reservation_pack(int id_res_pack) {
        this.id_res_pack = id_res_pack;
    }
   
   

    public Reservation_pack(int id_res_pack, Date date_pack, int id_client, int id_accomp, int id_pack) {
        this.id_res_pack = id_res_pack;
        this.date_pack = date_pack;
        this.id_client = id_client;
        this.id_accomp = id_accomp;
        this.id_pack = id_pack;
    }

    public Reservation_pack(Date date_pack, int id_client, int id_accomp, int id_pack) {
        this.date_pack = date_pack;
        this.id_client = id_client;
        this.id_accomp = id_accomp;
        this.id_pack = id_pack;
    }

    public int getId_res_pack() {
        return id_res_pack;
    }

    public void setId_res_pack(int id_res_pack) {
        this.id_res_pack = id_res_pack;
    }

    public Date getDate_pack() {
        return date_pack;
    }

    public void setDate_pack(Date date_pack) {
        this.date_pack = date_pack;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_accomp() {
        return id_accomp;
    }

    public void setId_accomp(int id_accomp) {
        this.id_accomp = id_accomp;
    }

    public int getId_pack() {
        return id_pack;
    }

    public void setId_pack(int id_pack) {
        this.id_pack = id_pack;
    }

    @Override
    public String toString() {
        return "Reservation_pack{" + "id_res_pack=" + id_res_pack + ", date_pack=" + date_pack + ", id_client=" + id_client + ", id_accomp=" + id_accomp + ", id_pack=" + id_pack + '}';
    }
   
   
    
    
   
    
}
