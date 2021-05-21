/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.converters;

import com.costos.api.rest.entity.Articulo;
import com.costos.api.rest.models.ArticuloModel;
import com.costos.api.rest.repository.IArticuloRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author chiri convertidor  a model y veceversa
 */
@Component("ArticuloConverter")
public class ArticuloConverter extends Converter<ArticuloModel, Articulo>{
    @Autowired
    IArticuloRepositorio iArticuloRepositorio;

    @Override
    public Articulo modelToEntity(ArticuloModel m) {
        Articulo articulo ;
        if (m.getId() != null) {
            articulo = iArticuloRepositorio.getOne(m.getId());
        }else{
            articulo = new Articulo();
        }
        try {
         BeanUtils.copyProperties(m, articulo);
        }
        catch(Exception e){
            System.out.println("Error al convertir el modelo "+ m.toString()+" a entidad");
        }
         return articulo;
    }

    @Override
    public ArticuloModel entityToModel(Articulo a) {
          ArticuloModel modelo = new ArticuloModel();
        try {
            BeanUtils.copyProperties(a, modelo);
        } catch (BeansException e) {
            System.out.println(e);
        }
        return modelo;
    }

    @Override
    public List<Articulo> modelsToEntities(List<ArticuloModel> m) {
           List<Articulo> pedido = new ArrayList<>();
        for ( ArticuloModel modelo : m) {
           pedido.add(modelToEntity(modelo));
        }
        return pedido;
    }

    @Override
    public List<ArticuloModel> entitiesToModels(List<Articulo> a) {
            List<ArticuloModel> modelos = new ArrayList<>();
        
        for (Articulo pedido : a) {
            modelos.add(entityToModel(pedido));
        }
        return modelos;
    }
      
     
}
