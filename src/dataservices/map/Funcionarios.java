package dataservices.map;
// Generated Sep 12, 2016 9:35:08 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Funcionarios generated by hbm2java
 */
public class Funcionarios  implements java.io.Serializable {


     private Integer idFun;
     private Servicio servicio;
     private Rol rol;
     private String funNombres;
     private String funCedula;
     private String funTelefono;
     private String funMovil;
     private String funDireccion;
     private Set registros = new HashSet(0);
     private Set usuarios = new HashSet(0);
     private Set sesions = new HashSet(0);

    public Funcionarios() {
        this.servicio = new Servicio();
        this.rol = new Rol();
    }

	
    public Funcionarios(Servicio servicio, Rol rol) {
        this.servicio = servicio;
        this.rol = rol;
    }
    public Funcionarios(Servicio servicio, Rol rol, String funNombres, String funCedula, String funTelefono, String funMovil, String funDireccion, Set registros, Set usuarios, Set sesions) {
       this.servicio = servicio;
       this.rol = rol;
       this.funNombres = funNombres;
       this.funCedula = funCedula;
       this.funTelefono = funTelefono;
       this.funMovil = funMovil;
       this.funDireccion = funDireccion;
       this.registros = registros;
       this.usuarios = usuarios;
       this.sesions = sesions;
    }
   
    public Integer getIdFun() {
        return this.idFun;
    }
    
    public void setIdFun(Integer idFun) {
        this.idFun = idFun;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getFunNombres() {
        return this.funNombres;
    }
    
    public void setFunNombres(String funNombres) {
        this.funNombres = funNombres;
    }
    public String getFunCedula() {
        return this.funCedula;
    }
    
    public void setFunCedula(String funCedula) {
        this.funCedula = funCedula;
    }
    public String getFunTelefono() {
        return this.funTelefono;
    }
    
    public void setFunTelefono(String funTelefono) {
        this.funTelefono = funTelefono;
    }
    public String getFunMovil() {
        return this.funMovil;
    }
    
    public void setFunMovil(String funMovil) {
        this.funMovil = funMovil;
    }
    public String getFunDireccion() {
        return this.funDireccion;
    }
    
    public void setFunDireccion(String funDireccion) {
        this.funDireccion = funDireccion;
    }
    public Set getRegistros() {
        return this.registros;
    }
    
    public void setRegistros(Set registros) {
        this.registros = registros;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getSesions() {
        return this.sesions;
    }
    
    public void setSesions(Set sesions) {
        this.sesions = sesions;
    }




}


