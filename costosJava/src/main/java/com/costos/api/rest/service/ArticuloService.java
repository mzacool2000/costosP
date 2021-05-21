/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.service;

import com.costos.api.rest.converters.ArticuloConverter;
import com.costos.api.rest.dao.ArticuloDao;
import com.costos.api.rest.entity.Articulo;
import com.costos.api.rest.models.ArticuloModel;
import com.costos.api.rest.repository.IArticuloRepositorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chiri
 */
@Service
public class ArticuloService {
    @Autowired
    private IArticuloRepositorio articuloRepository;
    @Autowired
    private ArticuloDao articuloDao;
    @Autowired
    private ArticuloConverter articuloConverter;
    
    
  @Transactional
   public void guardarTarea(Articulo articulo){
     
       articuloRepository.save(articulo);
      
   }

    
  @Transactional
   public void llenarTabla(ResultSet rs){
       //con el resulset de la consulta actualiza la tabla local
       if (rs==null) {
           System.out.println("el rs vino vacio");
       }
        try {
            //recorro el rs
            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setCodigo(rs.getString(1));
                System.out.println("1" + rs.getString(1));
                articulo.setPlanta(rs.getLong(4));
                System.out.println("2"+rs.getLong(4) );
                articulo.setStockTotal(rs.getLong(5));
                System.out.println("3 " + rs.getLong(5));
                articulo.setCostoPeso(rs.getLong(6));
                System.out.println("4"+ rs.getString(6));
                articulo.setCostoUsd(rs.getLong(7));
                System.out.println("5 " +rs.getLong(7));
                articulo.setCostoEuro(rs.getLong(8));
                System.out.println("6"+ rs.getLong(8));
               
                guardarTarea(articulo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
}
   public void llenarTabla(){
       articuloDao.llenarTabla();
   }
    public List<ArticuloModel> findAll() {
        // para la vista devuelve todos los ariculos de compras al modelo
     return articuloConverter.entitiesToModels(articuloRepository.findAll()); 
    }
}