/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.converters;

import com.costos.api.rest.entity.ArticuloVenta;
import com.costos.api.rest.entity.Venta;
import com.costos.api.rest.models.ArticuloVentaModel;
import com.costos.api.rest.models.VentaModel;
import com.costos.api.rest.repository.VentaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author chiri convertidor  a model y veceversa
 */
@Component("VentaConverter")
public class VentaConverter extends Converter<VentaModel, Venta> {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ArticuloVentaConverter articuloVentaConverter;

    @Override
    public Venta modelToEntity(VentaModel m) {
        Venta entidad = new Venta();
        if (m.getNumeroCotizacion() != null) {
            Optional<Venta> respuesta = ventaRepository.findById(m.getNumeroCotizacion());
            if (respuesta.isPresent()) {
                entidad=respuesta.get();
            }
        } 
        try {
            entidad.setNumeroCotizacion(m.getNumeroCotizacion());
            entidad.setClienteCodi(m.getClienteCodi());
            entidad.setClienteRazon(m.getClienteRazon());
            entidad.setCotizacion(m.getCotizacion());
            entidad.setEstadoCotizacion(m.getEstadoCotizacion());
            if (m.getFechaDeAdjudicacion() != null) {
                entidad.setFechaDeAdjudicacion(m.getFechaDeAdjudicacion());
            }
            if (m.getFechaPresupuesto() != null) {
                entidad.setFechaPresupuesto(m.getFechaPresupuesto());
            }

            if (!m.getPais().isEmpty() || m.getPais() != null) {
                entidad.setPais(m.getPais());
            }

            if (!m.getProvincia().isEmpty() || m.getProvincia() != null) {
                entidad.setProvincia(m.getProvincia());
            }
            entidad.setUsuario(m.getUsuario());
            if (!m.getArticulos().isEmpty()) {
                List<ArticuloVenta> articuloVenta = new ArrayList<>();
                for (ArticuloVentaModel articuloModel : m.getArticulos()) {
                    articuloVenta.add(articuloVentaConverter.modelToEntity(articuloModel));
                }
                entidad.setArticulos(articuloVenta);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return entidad;
    }

    @Override
    public VentaModel entityToModel(Venta v) {
        VentaModel modelo = new VentaModel();
        try {
            modelo.setNumeroCotizacion(v.getNumeroCotizacion());
            modelo.setClienteCodi(v.getClienteCodi());
            modelo.setClienteRazon(v.getClienteRazon());
            modelo.setCotizacion(v.getCotizacion());
            modelo.setEstadoCotizacion(v.getEstadoCotizacion());
            if (v.getFechaDeAdjudicacion() != null) {
                modelo.setFechaDeAdjudicacion(v.getFechaDeAdjudicacion());
            }
            if (v.getFechaPresupuesto() != null) {
                modelo.setFechaPresupuesto(v.getFechaPresupuesto());
            }

            if (v.getPais() != null) {
                modelo.setPais(v.getPais());
            }

            if (v.getProvincia() != null) {
                modelo.setProvincia(v.getProvincia());
            }
            modelo.setUsuario(v.getUsuario());
            if (v.getArticulos() != null) {
                List<ArticuloVentaModel> articuloVentaModel = new ArrayList<>();
                for (ArticuloVenta articuloVenta : v.getArticulos()) {
                    articuloVentaModel.add(articuloVentaConverter.entityToModel(articuloVenta));
                }
                modelo.setArticulos(articuloVentaModel);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return modelo;
    }

    @Override
    public List<Venta> modelsToEntities(List<VentaModel> m) {
        List<Venta> entidad = new ArrayList<>();
        for (VentaModel modelo : m) {
            entidad.add(modelToEntity(modelo));
        }
        return entidad;
    }

    @Override
    public List<VentaModel> entitiesToModels(List<Venta> e) {
        List<VentaModel> modelo = new ArrayList<>();
        for (Venta entidad : e) {
            modelo.add(entityToModel(entidad));
        }
        return modelo;
    }

}
