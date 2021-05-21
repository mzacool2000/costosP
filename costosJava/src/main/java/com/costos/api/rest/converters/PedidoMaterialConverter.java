/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.converters;

import com.costos.api.rest.entity.PedidoMaterial;
import com.costos.api.rest.models.PedidoMaterialModel;
import com.costos.api.rest.repository.PedidoMaterialRepository;
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
@Component("PedidoMaterialConverter")
public class PedidoMaterialConverter  extends Converter<PedidoMaterialModel, PedidoMaterial>  {
    
    @Autowired
    private PedidoMaterialRepository pedidoMaterialRepository;

    @Override
    public PedidoMaterial modelToEntity(PedidoMaterialModel m) {
        PedidoMaterial pedido ;
        if (m.getId() != null  ) {
            pedido = pedidoMaterialRepository.getOne(m.getId());
        }else{
            pedido = new PedidoMaterial();
        }
        try {
         BeanUtils.copyProperties(m, pedido);
        }
        catch(Exception e){
            System.out.println("Error al convertir el modelo "+ m.toString()+" a entidad");
        }
         return pedido;
    }

    
    @Override
    public PedidoMaterialModel entityToModel(PedidoMaterial p) {
        
        PedidoMaterialModel modelo = new PedidoMaterialModel();
        try {
            BeanUtils.copyProperties(p, modelo);
        } catch (BeansException e) {
            System.out.println(e);
        }
        return modelo;
    }

    @Override
    public List<PedidoMaterial> modelsToEntities(List<PedidoMaterialModel> m) {
        List<PedidoMaterial> pedido = new ArrayList<>();
        for (PedidoMaterialModel modelo : m) {
           pedido.add(modelToEntity(modelo));
        }
        return pedido;
    }

    @Override
    public List<PedidoMaterialModel> entitiesToModels(List<PedidoMaterial> p) {
        List<PedidoMaterialModel> modelos = new ArrayList<>();
        
        for (PedidoMaterial pedido : p) {
            modelos.add(entityToModel(pedido));
        }
        return modelos;
    }

  

    
}
