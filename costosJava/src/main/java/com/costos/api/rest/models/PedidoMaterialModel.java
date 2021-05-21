/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.models;

import java.util.Calendar;

/**
 *
 * @author chiri
 */
public class PedidoMaterialModel {
    
    private Integer id;
    private Integer numeroPedido;
    private long notaDeVenta;
    private String descripProyecto;
    private String cliente;
    private long cantidadPedida;
    private long cantidadModificada;
    private Calendar ultimaActualizacionDespiece;
    private String articulo;
    private String ariCod;
    private String area;
    private Integer unidadOrg; 
    private String tarea;
    private long cantidadAPD;
    private Calendar fechaAsignacion;
    private long cantidadFinalP;
    private long cantidadRealU;
    private Integer tareaCod;
    private Calendar fechaUti;
    private Calendar fechaFinUtili;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the numeroPedido
     */
    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    /**
     * @param numeroPedido the numeroPedido to set
     */
    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    /**
     * @return the notaDeVenta
     */
    public long getNotaDeVenta() {
        return notaDeVenta;
    }

    /**
     * @param notaDeVenta the notaDeVenta to set
     */
    public void setNotaDeVenta(long notaDeVenta) {
        this.notaDeVenta = notaDeVenta;
    }

    /**
     * @return the descripProyecto
     */
    public String getDescripProyecto() {
        return descripProyecto;
    }

    /**
     * @param descripProyecto the descripProyecto to set
     */
    public void setDescripProyecto(String descripProyecto) {
        this.descripProyecto = descripProyecto;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the cantidadPedida
     */
    public long getCantidadPedida() {
        return cantidadPedida;
    }

    /**
     * @param cantidadPedida the cantidadPedida to set
     */
    public void setCantidadPedida(long cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    /**
     * @return the cantidadModificada
     */
    public long getCantidadModificada() {
        return cantidadModificada;
    }

    /**
     * @param cantidadModificada the cantidadModificada to set
     */
    public void setCantidadModificada(long cantidadModificada) {
        this.cantidadModificada = cantidadModificada;
    }

    /**
     * @return the ultimaActualizacionDespiece
     */
    public Calendar getUltimaActualizacionDespiece() {
        return ultimaActualizacionDespiece;
    }

    /**
     * @param ultimaActualizacionDespiece the ultimaActualizacionDespiece to set
     */
    public void setUltimaActualizacionDespiece(Calendar ultimaActualizacionDespiece) {
        this.ultimaActualizacionDespiece = ultimaActualizacionDespiece;
    }

    /**
     * @return the articulo
     */
    public String getArticulo() {
        return articulo;
    }

    /**
     * @param articulo the articulo to set
     */
    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    /**
     * @return the ariCod
     */
    public String getAriCod() {
        return ariCod;
    }

    /**
     * @param ariCod the ariCod to set
     */
    public void setAriCod(String ariCod) {
        this.ariCod = ariCod;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the unidadOrg
     */
    public Integer getUnidadOrg() {
        return unidadOrg;
    }

    /**
     * @param unidadOrg the unidadOrg to set
     */
    public void setUnidadOrg(Integer unidadOrg) {
        this.unidadOrg = unidadOrg;
    }

    /**
     * @return the tarea
     */
    public String getTarea() {
        return tarea;
    }

    /**
     * @param tarea the tarea to set
     */
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    /**
     * @return the cantidadAPD
     */
    public long getCantidadAPD() {
        return cantidadAPD;
    }

    /**
     * @param cantidadAPD the cantidadAPD to set
     */
    public void setCantidadAPD(long cantidadAPD) {
        this.cantidadAPD = cantidadAPD;
    }

    /**
     * @return the fechaAsignacion
     */
    public Calendar getFechaAsignacion() {
        return fechaAsignacion;
    }

    /**
     * @param fechaAsignacion the fechaAsignacion to set
     */
    public void setFechaAsignacion(Calendar fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    /**
     * @return the cantidadFinalP
     */
    public long getCantidadFinalP() {
        return cantidadFinalP;
    }

    /**
     * @param cantidadFinalP the cantidadFinalP to set
     */
    public void setCantidadFinalP(long cantidadFinalP) {
        this.cantidadFinalP = cantidadFinalP;
    }

    /**
     * @return the cantidadRealU
     */
    public long getCantidadRealU() {
        return cantidadRealU;
    }

    /**
     * @param cantidadRealU the cantidadRealU to set
     */
    public void setCantidadRealU(long cantidadRealU) {
        this.cantidadRealU = cantidadRealU;
    }

    /**
     * @return the tareaCod
     */
    public Integer getTareaCod() {
        return tareaCod;
    }

    /**
     * @param tareaCod the tareaCod to set
     */
    public void setTareaCod(Integer tareaCod) {
        this.tareaCod = tareaCod;
    }

    /**
     * @return the fechaUti
     */
    public Calendar getFechaUti() {
        return fechaUti;
    }

    /**
     * @param fechaUti the fechaUti to set
     */
    public void setFechaUti(Calendar fechaUti) {
        this.fechaUti = fechaUti;
    }

    /**
     * @return the fechaFinUtili
     */
    public Calendar getFechaFinUtili() {
        return fechaFinUtili;
    }

    /**
     * @param fechaFinUtili the fechaFinUtili to set
     */
    public void setFechaFinUtili(Calendar fechaFinUtili) {
        this.fechaFinUtili = fechaFinUtili;
    }
    
   
    
}
