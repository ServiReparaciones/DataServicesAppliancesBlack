package dataservices.map;
// Generated Sep 12, 2016 9:35:08 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orden generated by hbm2java
 */
public class Orden  implements java.io.Serializable {


     private Integer idOrden;
     private Cliente cliente;
     private Producto producto;
     private Integer ordNumSis;
     private String ordNumOt1;
     private String ordNumOt2;
     private String ordNumOt3;
     private Date ordFechaVisita;
     private String ordFalla;
     private String ordReparacion;
     private Double ordValorMobra;
     private String ordTipo;
     private String ordEstado;
     private Integer ordFlag;
     private Set registros = new HashSet(0);
     private Set detallleRs = new HashSet(0);

    public Orden() {
        this.cliente = new Cliente();
        this.producto = new Producto();
        this.ordFlag = 1;
    }

	
    public Orden(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
    }
    public Orden(Cliente cliente, Producto producto, Integer ordNumSis, String ordNumOt1, String ordNumOt2, String ordNumOt3, Date ordFechaVisita, String ordFalla, String ordReparacion, Double ordValorMobra, String ordTipo, String ordEstado, Integer ordFlag, Set registros, Set detallleRs) {
       this.cliente = cliente;
       this.producto = producto;
       this.ordNumSis = ordNumSis;
       this.ordNumOt1 = ordNumOt1;
       this.ordNumOt2 = ordNumOt2;
       this.ordNumOt3 = ordNumOt3;
       this.ordFechaVisita = ordFechaVisita;
       this.ordFalla = ordFalla;
       this.ordReparacion = ordReparacion;
       this.ordValorMobra = ordValorMobra;
       this.ordTipo = ordTipo;
       this.ordEstado = ordEstado;
       this.ordFlag = ordFlag;
       this.registros = registros;
       this.detallleRs = detallleRs;
    }
   
    public Integer getIdOrden() {
        return this.idOrden;
    }
    
    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getOrdNumSis() {
        return this.ordNumSis;
    }
    
    public void setOrdNumSis(Integer ordNumSis) {
        this.ordNumSis = ordNumSis;
    }
    public String getOrdNumOt1() {
        return this.ordNumOt1;
    }
    
    public void setOrdNumOt1(String ordNumOt1) {
        this.ordNumOt1 = ordNumOt1;
    }
    public String getOrdNumOt2() {
        return this.ordNumOt2;
    }
    
    public void setOrdNumOt2(String ordNumOt2) {
        this.ordNumOt2 = ordNumOt2;
    }
    public String getOrdNumOt3() {
        return this.ordNumOt3;
    }
    
    public void setOrdNumOt3(String ordNumOt3) {
        this.ordNumOt3 = ordNumOt3;
    }
    public Date getOrdFechaVisita() {
        return this.ordFechaVisita;
    }
    
    public void setOrdFechaVisita(Date ordFechaVisita) {
        this.ordFechaVisita = ordFechaVisita;
    }
    public String getOrdFalla() {
        return this.ordFalla;
    }
    
    public void setOrdFalla(String ordFalla) {
        this.ordFalla = ordFalla;
    }
    public String getOrdReparacion() {
        return this.ordReparacion;
    }
    
    public void setOrdReparacion(String ordReparacion) {
        this.ordReparacion = ordReparacion;
    }
    public Double getOrdValorMobra() {
        return this.ordValorMobra;
    }
    
    public void setOrdValorMobra(Double ordValorMobra) {
        this.ordValorMobra = ordValorMobra;
    }
    public String getOrdTipo() {
        return this.ordTipo;
    }
    
    public void setOrdTipo(String ordTipo) {
        this.ordTipo = ordTipo;
    }
    public String getOrdEstado() {
        return this.ordEstado;
    }
    
    public void setOrdEstado(String ordEstado) {
        this.ordEstado = ordEstado;
    }
    public Integer getOrdFlag() {
        return this.ordFlag;
    }
    
    public void setOrdFlag(Integer ordFlag) {
        this.ordFlag = ordFlag;
    }
    public Set getRegistros() {
        return this.registros;
    }
    
    public void setRegistros(Set registros) {
        this.registros = registros;
    }
    public Set getDetallleRs() {
        return this.detallleRs;
    }
    
    public void setDetallleRs(Set detallleRs) {
        this.detallleRs = detallleRs;
    }




}


