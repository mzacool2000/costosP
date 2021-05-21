/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.models;

/**
 *
 * @author chiri
 */
public class ArticuloModel {
     private Long id;
     private String codigo;
     private long planta;
     private long stockTotal;
     private long costoPeso;
     private long costoUsd;
     private long costoEuro;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the planta
     */
    public long getPlanta() {
        return planta;
    }

    /**
     * @param planta the planta to set
     */
    public void setPlanta(long planta) {
        this.planta = planta;
    }

    /**
     * @return the stockTotal
     */
    public long getStockTotal() {
        return stockTotal;
    }

    /**
     * @param stockTotal the stockTotal to set
     */
    public void setStockTotal(long stockTotal) {
        this.stockTotal = stockTotal;
    }

    /**
     * @return the costoPeso
     */
    public long getCostoPeso() {
        return costoPeso;
    }

    /**
     * @param costoPeso the costoPeso to set
     */
    public void setCostoPeso(long costoPeso) {
        this.costoPeso = costoPeso;
    }

    /**
     * @return the costoUsd
     */
    public long getCostoUsd() {
        return costoUsd;
    }

    /**
     * @param costoUsd the costoUsd to set
     */
    public void setCostoUsd(long costoUsd) {
        this.costoUsd = costoUsd;
    }

    /**
     * @return the costoEuro
     */
    public long getCostoEuro() {
        return costoEuro;
    }

    /**
     * @param costoEuro the costoEuro to set
     */
    public void setCostoEuro(long costoEuro) {
        this.costoEuro = costoEuro;
    }
     
}
