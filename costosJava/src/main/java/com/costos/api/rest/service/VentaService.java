/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.service;

import com.costos.api.rest.converters.ArticuloVentaConverter;
import com.costos.api.rest.converters.VentaConverter;
import com.costos.api.rest.dao.VentaDao;
import com.costos.api.rest.entity.ArticuloVenta;
import com.costos.api.rest.entity.Venta;
import com.costos.api.rest.models.ArticuloVentaModel;
import com.costos.api.rest.models.VentaModel;
import com.costos.api.rest.repository.VentaRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**

 */
@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private VentaConverter ventaConverter;
    @Autowired
    private ArticuloVentaConverter articuloVentaConverter;
    @Autowired
    private VentaDao ventaDao;
    @Autowired
    private ArticuloVentaService articuloVentaService;
    
    
    
    @Transactional
    public Venta guardar (Venta venta){
        /*
        guarda la entedad en el repositorio
        */
       
        try {
            return ventaRepository.save(venta);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
            return venta;
    }
    @Transactional
    public void actualizar (VentaModel ventaModel){
        /*
        *actualiza el modelo traido desde la vista
        *de datos en globalis
        */
        Venta venta = null;
        Optional<Venta> respuesta = ventaRepository.findById(ventaModel.getNumeroCotizacion());
        if (respuesta.isPresent()) {
            venta= respuesta.get();
            venta = ventaConverter.modelToEntity(ventaModel);
            venta.setArticulos(actualizarLAV(ventaModel.getArticulos(), respuesta.get().getArticulos())); //tiene encuenta los elementos repetidos en el presupeusto
            guardar(venta);
        }else{
            venta = ventaConverter.modelToEntity(ventaModel);
            guardar(venta);
        }
    
    }
       @Transactional
    public Venta actualizar(Venta venta) {
        /*
        *actualiza la entidad desde la bd no hace falta pasar por modelos
        */
        Venta ventaA = new Venta();

        try {

            Optional<Venta> respuesta = ventaRepository.findById(venta.getNumeroCotizacion());
            if (respuesta.isPresent()) {
                System.out.println("existe la actualizao");
                ventaA = respuesta.get();
                ventaA.setClienteCodi(venta.getClienteCodi());
                ventaA.setClienteRazon(venta.getClienteRazon());
                ventaA.setCotizacion(venta.getCotizacion());
                ventaA.setEstadoCotizacion(venta.getEstadoCotizacion());
                if (venta.getFechaDeAdjudicacion() != null) {
                    ventaA.setFechaDeAdjudicacion(venta.getFechaDeAdjudicacion());
                }
                if (venta.getFechaPresupuesto() != null) {
                    ventaA.setFechaPresupuesto(venta.getFechaPresupuesto());
                }
                if (venta.getPais() != null) {
                    ventaA.setPais(venta.getPais());
                }
                if (venta.getProvincia() != null) {
                    ventaA.setProvincia(venta.getProvincia());
                }
                ventaA.setUsuario(venta.getUsuario());
                return guardar(ventaA);
            } else {
                System.out.println("no exite la creo");
                ventaA.setNumeroCotizacion(venta.getNumeroCotizacion());
                ventaA.setClienteCodi(venta.getClienteCodi());
                ventaA.setClienteRazon(venta.getClienteRazon());
                ventaA.setCotizacion(venta.getCotizacion());
                ventaA.setEstadoCotizacion(venta.getEstadoCotizacion());
                if (venta.getFechaDeAdjudicacion() != null) {
                    ventaA.setFechaDeAdjudicacion(venta.getFechaDeAdjudicacion());
                }
                if (venta.getFechaPresupuesto() != null) {
                    ventaA.setFechaPresupuesto(venta.getFechaPresupuesto());
                }
                if (venta.getPais() != null) {
                    ventaA.setPais(venta.getPais());
                }
                if (venta.getProvincia() != null) {
                    ventaA.setProvincia(venta.getProvincia());
                }
                ventaA.setUsuario(venta.getUsuario());
                return guardar(ventaA);
            }

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    return null;
    }
    
    
    @Transactional
    public void llenarTabla(ResultSet rs) {
        /*
        desde el dao llega el resulset y actualiza los datos desde delfos
         */
        try {

            while (rs.next()) {
                Venta venta = new Venta();
                Calendar fecha = Calendar.getInstance();
                venta.setClienteCodi(rs.getInt(1));
                venta.setClienteRazon(rs.getString(2));
                if (rs.getString(3) != null) {
                    venta.setProvincia(rs.getString(3));
                }
                if (rs.getString(4) != null) {
                    venta.setPais(rs.getString(4));
                }
                venta.setCotizacion(rs.getString(5));
                venta.setNumeroCotizacion(rs.getInt(6));
                venta.setEstadoCotizacion(rs.getString(7));
                if (rs.getDate(8) != null) {
                    fecha.setTime(rs.getDate(8));
                    venta.setFechaDeAdjudicacion(fecha);
                }
                if (rs.getDate(9) != null) {
                    fecha.setTime(rs.getDate(9));
                    venta.setFechaPresupuesto(fecha);
                }
                venta.setUsuario(rs.getString(10));
                actualizar(venta);

                /*
                una vez actualizada la venta se actualiza el articulo asociado
                 */
              
            }
        } catch (SQLException ex) {
            System.out.println(ex.fillInStackTrace());
        }
    }
    
    
    
    @Transactional
    private List<ArticuloVenta> actualizarLAV(List<ArticuloVentaModel> modelos,List<ArticuloVenta> articulosVenta){
   
        for (ArticuloVentaModel modelo : modelos) {
            for (ArticuloVenta articuloVenta : articulosVenta) {
                if (articuloVenta.getArtiCodi().equals(modelo.getArtiCodi())) {
                    articulosVenta.remove(articuloVenta);
                    articulosVenta.add(articuloVentaConverter.modelToEntity(modelo));
                }
            }
        }
    return articulosVenta;
    }
    @Transactional
    public void llenar(){
        ventaDao.llenarTabla();
    }
    @Transactional
    public List<VentaModel> findall(){
    List<VentaModel> listaM = new ArrayList<>();
    return  listaM = ventaConverter.entitiesToModels(ventaRepository.findAll());
    }
    
}
