/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.models;

import com.costos.api.rest.converters.Converter;
import com.costos.api.rest.entity.ArticuloVenta;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Id;

/**
 *
 * @author chiri
 */
public class VentaModel {
    
    private Integer numeroCotizacion;
    private String cotizacion;
    private Integer clienteCodi;
    private String clienteRazon;
    private String provincia;
    private String pais;
    private String estadoCotizacion;
    private Calendar fechaDeAdjudicacion;
    private Calendar fechaPresupuesto;
    private String usuario;
    private List<ArticuloVentaModel> articulos;

    /**
     * @return the numeroCotizacion
     */
    public Integer getNumeroCotizacion() {
        return numeroCotizacion;
    }

    /**
     * @param numeroCotizacion the numeroCotizacion to set
     */
    public void setNumeroCotizacion(Integer numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    /**
     * @return the cotizacion
     */
    public String getCotizacion() {
        return cotizacion;
    }

    /**
     * @param cotizacion the cotizacion to set
     */
    public void setCotizacion(String cotizacion) {
        this.cotizacion = cotizacion;
    }

    /**
     * @return the clienteCodi
     */
    public Integer getClienteCodi() {
        return clienteCodi;
    }

    /**
     * @param clienteCodi the clienteCodi to set
     */
    public void setClienteCodi(Integer clienteCodi) {
        this.clienteCodi = clienteCodi;
    }

    /**
     * @return the clienteRazon
     */
    public String getClienteRazon() {
        return clienteRazon;
    }

    /**
     * @param clienteRazon the clienteRazon to set
     */
    public void setClienteRazon(String clienteRazon) {
        this.clienteRazon = clienteRazon;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the estadoCotizacion
     */
    public String getEstadoCotizacion() {
        return estadoCotizacion;
    }

    /**
     * @param estadoCotizacion the estadoCotizacion to set
     */
    public void setEstadoCotizacion(String estadoCotizacion) {
        this.estadoCotizacion = estadoCotizacion;
    }

    /**
     * @return the fechaDeAdjudicacion
     */
    public Calendar getFechaDeAdjudicacion() {
        return fechaDeAdjudicacion;
    }

    /**
     * @param fechaDeAdjudicacion the fechaDeAdjudicacion to set
     */
    public void setFechaDeAdjudicacion(Calendar fechaDeAdjudicacion) {
        this.fechaDeAdjudicacion = fechaDeAdjudicacion;
    }

    /**
     * @return the fechaPresupuesto
     */
    public Calendar getFechaPresupuesto() {
        return fechaPresupuesto;
    }

    /**
     * @param fechaPresupuesto the fechaPresupuesto to set
     */
    public void setFechaPresupuesto(Calendar fechaPresupuesto) {
        this.fechaPresupuesto = fechaPresupuesto;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the articulos
     */
    public List<ArticuloVentaModel> getArticulos() {
        return articulos;
    }

    /**
     * @param articulos the articulos to set
     */
    public void setArticulos(List<ArticuloVentaModel> articulos) {
        this.articulos = articulos;
    }
    
}
