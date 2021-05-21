/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.converters;

import com.costos.api.rest.entity.ArticuloVenta;
import com.costos.api.rest.models.ArticuloVentaModel;
import com.costos.api.rest.repository.ArticuloVentaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author chiri convertidor  a model y veceversa
 */
@Component("ArticuloVentaConverter")
public class ArticuloVentaConverter extends Converter<ArticuloVentaModel, ArticuloVenta>{
    @Autowired
    private ArticuloVentaRepository articuloVentaRepository;

    @Override
    public ArticuloVenta modelToEntity(ArticuloVentaModel m) {
         ArticuloVenta entidad = new ArticuloVenta();
        if (m.getId() != null) {
            Optional<ArticuloVenta> respuesta = articuloVentaRepository.findById(m.getId());
            if (respuesta.isPresent()) {
                entidad = respuesta.get();
            }
        try {
            
         BeanUtils.copyProperties(m, entidad);
        }
        catch(Exception e){
            System.out.println("Error al convertir el modelo "+ e.fillInStackTrace()+" a entidad");
        }
        }
         return entidad;
    }
    

    @Override
    public ArticuloVentaModel entityToModel(ArticuloVenta a) {
        
        ArticuloVentaModel modelo = new ArticuloVentaModel();
        try {
            BeanUtils.copyProperties(a, modelo);
        } catch (BeansException e) {
            System.out.println(e);
        }
        return modelo;
    }

    @Override
    public List<ArticuloVenta> modelsToEntities(List<ArticuloVentaModel> m) {
          List<ArticuloVenta> entidades = new ArrayList<>();
        for ( ArticuloVentaModel modelo : m) {
           entidades.add(modelToEntity(modelo));
        }
        return entidades;
    }

    @Override
    public List<ArticuloVentaModel> entitiesToModels(List<ArticuloVenta> e) {
        List<ArticuloVentaModel> modelos = new ArrayList<>();
        for (ArticuloVenta entidad : e) {
            modelos.add(entityToModel(entidad));
        }
        return modelos;
    }
    
}
