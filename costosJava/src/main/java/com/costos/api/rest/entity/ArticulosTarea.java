/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.entity;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author chiri
 */
@Entity
public class ArticulosTarea {
    @Id
    private long idPeido;
    private long canitadModificada;
    private Calendar ultimaActualizacionDespiece;
    private String articulo;
    private String artiCodiCompuesto;
    private long cantidadAsignadaPorDeposito;
    private long cantidadFinalPlanificada;
    private long cantidadRalUtilizada;
    private Calendar fechaDeUtilizacion;
    private Calendar fechaFindeUtilizacion;
    
          
}
