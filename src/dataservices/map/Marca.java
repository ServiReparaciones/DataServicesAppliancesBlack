package dataservices.map;
// Generated Sep 12, 2016 9:35:08 PM by Hibernate Tools 3.6.0



/**
 * Marca generated by hbm2java
 */
public class Marca  implements java.io.Serializable {


     private Integer idMarca;
     private String marNombre;

    public Marca() {
    }

    public Marca(String marNombre) {
       this.marNombre = marNombre;
    }
   
    public Integer getIdMarca() {
        return this.idMarca;
    }
    
    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }
    public String getMarNombre() {
        return this.marNombre;
    }
    
    public void setMarNombre(String marNombre) {
        this.marNombre = marNombre;
    }




}

