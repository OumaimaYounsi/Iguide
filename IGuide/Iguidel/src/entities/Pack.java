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
        private String image;
        private int rating ;
     /* private Set<Service> listService = new HashSet<Service>();*/

 public Pack() {
      
    }

    public Pack(int id, String name, String desc, int id_service, String image, int rating) {
    }

    public Pack(int aInt, String string, String string0, String string1, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Pack(int id, String name, String desc, int id_service, String service_name, int service_nbr_max, Date service_date_debut, Date service_date_fin, String service_cible, String image, int rating) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.id_service = id_service;
        this.service_name = service_name;
        this.service_nbr_max = service_nbr_max;
        this.service_date_debut = service_date_debut;
        this.service_date_fin = service_date_fin;
        this.service_cible = service_cible;
        this.image = image;
        this.rating = rating;
    }
 
 
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
  public Pack(int id, String name, String desc, int id_service, String service_name, int service_nbr_max, Date service_date_debut, Date service_date_fin, String service_cible,String image) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.id_service = id_service;
        this.service_name = service_name;
        this.service_nbr_max = service_nbr_max;
        this.service_date_debut = service_date_debut;
        this.service_date_fin = service_date_fin;
        this.service_cible = service_cible;
        this.image=image; 
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
     public Pack(String name, String desc , String image) {
        this.name = name;
        this.desc = desc;
        this.image=image;
    }
     
       public Pack(String name, String desc, int id_service,String image) {
        this.name = name;
        this.desc = desc;
        this.id_service = id_service;
         this.image=image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Pack{" + "id=" + id + ", name=" + name + ", desc=" + desc + ", id_service=" + id_service + ", service_name=" + service_name + ", service_nbr_max=" + service_nbr_max + ", service_date_debut=" + service_date_debut + ", service_date_fin=" + service_date_fin + ", service_cible=" + service_cible + ", image=" + image + ", rating=" + rating + '}';
    }

    

   	
    
}
