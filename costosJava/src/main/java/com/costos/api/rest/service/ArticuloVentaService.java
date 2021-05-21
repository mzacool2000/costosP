/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.service;

import com.costos.api.rest.converters.ArticuloVentaConverter;
import com.costos.api.rest.dao.ArticulosVentaDao;
import com.costos.api.rest.entity.ArticuloVenta;
import com.costos.api.rest.entity.Venta;
import com.costos.api.rest.models.ArticuloVentaModel;
import com.costos.api.rest.repository.ArticuloVentaRepository;
import com.costos.api.rest.repository.VentaRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiri
 */
@Service
public class ArticuloVentaService {

    @Autowired
    private ArticuloVentaRepository articuloVentaRepository;
    @Autowired
    private ArticuloVentaConverter articuloVentaConverter;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private VentaService ventaService;
    @Autowired
    private ArticulosVentaDao articulosVentaDao;

    @Transactional
    public ArticuloVenta guardar(ArticuloVenta articuloVenta) {
        //guardo en la mysql el articulo de venta
     return articuloVentaRepository.save(articuloVenta);
    }

    @Transactional
    public ArticuloVentaModel actualizar(ArticuloVentaModel articuloVentaModel) {
        //recibo desde el controlador un modelo y actualizo en mySql

        Optional<ArticuloVenta> respuesta = articuloVentaRepository.findById(articuloVentaModel.getId());
        if (respuesta.isPresent()) {
            //existe el articuo en la bd lo actualizo
            ArticuloVenta articuloventa = respuesta.get();
            if ( articuloVentaModel.getArtiCodi() != null) {
                articuloventa.setArtiCodi(articuloVentaModel.getArtiCodi());
            }
            if (articuloVentaModel.getArtiCodiCompuesto() != null) {
                articuloventa.setArtiCodiCompuesto(articuloVentaModel.getArtiCodiCompuesto());
            }

            if (articuloVentaModel.getArtiDescrip() != null) {
                articuloventa.setArtiDescrip(articuloVentaModel.getArtiDescrip());
            }
            if (articuloVentaModel.getCambio() != null) {
                articuloventa.setCambio(articuloVentaModel.getCambio());
            }
            if (articuloVentaModel.getCambio() != null) {
                articuloventa.setCambio(articuloVentaModel.getCambio());
            }

            if (articuloVentaModel.getCantidad() != null) {
                articuloventa.setCantidad(articuloVentaModel.getCantidad());
            }
            return articuloVentaConverter.entityToModel(guardar(articuloventa));
        } else {
            // no existe el articulo en la base de datos lo creo y lo guardo
            ArticuloVenta articulo = new ArticuloVenta();

            if (articuloVentaModel.getArtiCodi() != null) {
                articulo.setArtiCodi(articuloVentaModel.getArtiCodi());
            }
            if (articuloVentaModel.getArtiCodiCompuesto() != null) {
                articulo.setArtiCodiCompuesto(articuloVentaModel.getArtiCodiCompuesto());
            }

            if (articuloVentaModel.getArtiDescrip() != null) {
                articulo.setArtiDescrip(articuloVentaModel.getArtiDescrip());
            }
            if (articuloVentaModel.getCambio() != null) {
                articulo.setCambio(articuloVentaModel.getCambio());
            }
            if (articuloVentaModel.getCambio() != null) {
                articulo.setCambio(articuloVentaModel.getCambio());
            }

            if (articuloVentaModel.getCantidad() != null) {
                articulo.setCantidad(articuloVentaModel.getCantidad());
            }
            return articuloVentaConverter.entityToModel(guardar(articulo));
        }

    }

    public void llenarTabla(ResultSet rs) {
        // del dao actualizdo la lista de articulos de venta

        try {
            while (rs.next()) {
                
                
                if (rs.getString(2) != null) {
                    /*
                    si hay articulo asociado en la base de datos lo creo
                     */
                    ArticuloVenta articuloVenta = new ArticuloVenta();
                    articuloVenta.setId(rs.getString(1)+rs.getString(2));
                    if (rs.getString(2) != null) {
                        articuloVenta.setArtiCodi(rs.getString(2));
                    }
                    if (rs.getString(3) != null) {
                        articuloVenta.setArtiCodiCompuesto(rs.getString(3));
                    }
                    if (rs.getString(4) != null) {
                        articuloVenta.setArtiDescrip(rs.getString(4));
                    }
                    if (rs.getString(7) != null) {
                        articuloVenta.setCantidad(rs.getInt(7));
                    }
                    if (rs.getString(8) != null) {
                        articuloVenta.setMoneda(rs.getString(8));
                    }
                    if (rs.getString(9) != null) {
                        articuloVenta.setCambio(rs.getLong(9));
                    }

                    if (rs.getString(10) != null) {
                        articuloVenta.setPrecio(rs.getLong(10));
                    }
                    /*
                    busco la nota de venta
                     */
                    Optional<Venta> respuesta = ventaRepository.findById(rs.getInt(1));
                    if (respuesta.isPresent()) {
                          Venta venta = respuesta.get();
                        /*
                        *pregunto si la nv no tiene articulos lo agrego es el primero
                        */
                        List<ArticuloVenta> articulos = new ArrayList<>();

                        if (venta.getArticulos() == null) {
                            articulos.add(guardar(articuloVenta));
                            venta.setArticulos(articulos);
                            ventaService.guardar(venta);
                        } else {
                            // busco coincidencia sino guardo como nuevo
                            boolean actualizo = true;
                              Optional<ArticuloVenta> respuestaAV = articuloVentaRepository.findById(articuloVenta.getId());
                                if (respuestaAV.isPresent()) {
                                    ArticuloVenta articulo = respuestaAV.get();
                                    if (articuloVenta.getArtiDescrip() != null) {
                                        articulo.setArtiDescrip(articuloVenta.getArtiDescrip());
                                    }
                                    if (articuloVenta.getCambio() != null) {
                                        articulo.setCambio(articuloVenta.getCambio());
                                    }
                                    if (articuloVenta.getCambio() != null) {
                                        articulo.setCambio(articuloVenta.getCambio());
                                    }

                                    if (articuloVenta.getCantidad() != null) {
                                        articulo.setCantidad(articuloVenta.getCantidad());
                                    }
                                    System.out.println("actualizo el articulo a la lista");
                                    actualizo = false;
                                }
                            
                            /*
                        como no lo encontre lo agrego a la lista no vacia
                             */
                            if (actualizo) {
                                System.out.println(" agrego el aritulo a la lista de articulos");
                                articulos = venta.getArticulos();
                                articulos.add(guardar(articuloVenta));
                                venta.setArticulos(articulos);
                            }
                            ventaService.guardar(venta);
                        }
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.fillInStackTrace());
        }
    }
    public void llenar(){
    articulosVentaDao.llenarTabla();
    }
}
