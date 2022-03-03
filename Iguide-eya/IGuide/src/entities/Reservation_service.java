/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Reservation_service {
       private int id_res_service;
       private Date date_service; 
       private int id_client;
       private int id_accomp;
       private int id_service;

    public Reservation_service() {
    }
       
       

    public Reservation_service(int id_res_service, Date date_service, int id_client, int id_accomp, int id_service) {
        this.id_res_service = id_res_service;
        this.date_service = date_service;
        this.id_client = id_client;
        this.id_accomp = id_accomp;
        this.id_service = id_service;
    }

    public Reservation_service(Date date_service, int id_client, int id_accomp, int id_service) {
        this.date_service = date_service;
        this.id_client = id_client;
        this.id_accomp = id_accomp;
        this.id_service = id_service;
    }

    public int getId_res_service() {
        return id_res_service;
    }

    public void setId_res_service(int id_res_service) {
        this.id_res_service = id_res_service;
    }

    public Date getDate_service() {
        return date_service;
    }

    public void setDate_service(Date date_service) {
        this.date_service = date_service;
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

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    @Override
    public String toString() {
        return "Reservation_service{" + "id_res_service=" + id_res_service + ", date_service=" + date_service + ", id_client=" + id_client + ", id_accomp=" + id_accomp + ", id_service=" + id_service + '}';
    }


 

    
    
}
