/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author chiri
 */
@Entity
public class ArticuloVenta {

    @Id
    private String id;
    private String artiCodi;
    private String artiCodiCompuesto;
    private String artiDescrip;
    private String potenciaCotizacion;
    private String tensionPrimariaCotización;
    private Integer cantidad;
    private String moneda;
    private Long cambio;
    private Long precio;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the artiCodi
     */
    public String getArtiCodi() {
        return artiCodi;
    }

    /**
     * @param artiCodi the artiCodi to set
     */
    public void setArtiCodi(String artiCodi) {
        this.artiCodi = artiCodi;
    }

    /**
     * @return the artiCodiCompuesto
     */
    public String getArtiCodiCompuesto() {
        return artiCodiCompuesto;
    }

    /**
     * @param artiCodiCompuesto the artiCodiCompuesto to set
     */
    public void setArtiCodiCompuesto(String artiCodiCompuesto) {
        this.artiCodiCompuesto = artiCodiCompuesto;
    }

    /**
     * @return the artiDescrip
     */
    public String getArtiDescrip() {
        return artiDescrip;
    }

    /**
     * @param artiDescrip the artiDescrip to set
     */
    public void setArtiDescrip(String artiDescrip) {
        this.artiDescrip = artiDescrip;
    }

    /**
     * @return the potenciaCotizacion
     */
    public String getPotenciaCotizacion() {
        return potenciaCotizacion;
    }

    /**
     * @param potenciaCotizacion the potenciaCotizacion to set
     */
    public void setPotenciaCotizacion(String potenciaCotizacion) {
        this.potenciaCotizacion = potenciaCotizacion;
    }

    /**
     * @return the tensionPrimariaCotización
     */
    public String getTensionPrimariaCotización() {
        return tensionPrimariaCotización;
    }

    /**
     * @param tensionPrimariaCotización the tensionPrimariaCotización to set
     */
    public void setTensionPrimariaCotización(String tensionPrimariaCotización) {
        this.tensionPrimariaCotización = tensionPrimariaCotización;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the cambio
     */
    public Long getCambio() {
        return cambio;
    }

    /**
     * @param cambio the cambio to set
     */
    public void setCambio(Long cambio) {
        this.cambio = cambio;
    }

    /**
     * @return the precio
     */
    public Long getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Long precio) {
        this.precio = precio;
    }

   
    
}
