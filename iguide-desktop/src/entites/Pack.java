/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author user
 */
public class Pack {

    private int id;
    private String name;
    private String desc;
    private int id_service;
    private String service_name;
    private int service_nbr_max;
    private Date service_date_debut;
    private Date service_date_fin;
    private String service_cible;
     /* private Set<Service> listService = new HashSet<Service>();*/


    public Pack(int id, String name, String desc, int id_service, String service_name, int service_nbr_max, Date service_date_debut, Date service_date_fin, String service_cible) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.id_service = id_service;
        this.service_name = service_name;
        this.service_nbr_max = service_nbr_max;
        this.service_date_debut = service_date_debut;
        this.service_date_fin = service_date_fin;
        this.service_cible = service_cible;
    }

    public Pack(String name, String desc, int id_service, String service_name, int service_nbr_max, Date service_date_debut, Date service_date_fin, String service_cible) {
        this.name = name;
        this.desc = desc;
        this.id_service = id_service;
        this.service_name = service_name;
        this.service_nbr_max = service_nbr_max;
        this.service_date_debut = service_date_debut;
        this.service_date_fin = service_date_fin;
        this.service_cible = service_cible;
    }

    public Pack(int id, String name, String desc, int id_service) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.id_service = id_service;
    }

    public Pack(String name, String desc, int id_service) {
        this.name = name;
        this.desc = desc;
        this.id_service = id_service;
    }

    public Pack(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public Pack(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
  /*public Set<Service> getListService() {
    return listService;
  }

  public void setListService(Set<Service> listService) {
    this.listService = listService;
  }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setIdService(int id_service) {
        this.id_service = id_service;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getIdService() {
        return id_service;
    }

    @Override
    public String toString() {
        return "Pack{" + "id=" + id + ", name=" + name + ", desc=" + desc + ", id_service=" + id_service + ", service_name=" + service_name + ", service_nbr_max=" + service_nbr_max + ", service_date_debut=" + service_date_debut + ", service_date_fin=" + service_date_fin + ", service_cible=" + service_cible + '}';
    }
}
