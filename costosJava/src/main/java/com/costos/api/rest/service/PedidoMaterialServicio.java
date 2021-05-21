/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.service;


import com.costos.api.rest.converters.PedidoMaterialConverter;
import com.costos.api.rest.dao.PedidoMatDao;
import com.costos.api.rest.entity.PedidoMaterial;
import com.costos.api.rest.models.PedidoMaterialModel;
import com.costos.api.rest.repository.PedidoMaterialRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.Calendar;

/**
 *
 * @author chiri
 */
@Service
public class PedidoMaterialServicio {
    

    @Autowired
    private PedidoMaterialRepository pedidoMaterialRepository;
    @Autowired
    private PedidoMatDao pedidoMatDao;
    @Autowired
    private PedidoMaterialConverter pedidoMaterialConverter;
           
         
   @Transactional
   public void guardarPedido(PedidoMaterial pedido){
       //guardo un pedido de material
     
       pedidoMaterialRepository.save(pedido);
   }
    
   @Transactional
   public void llenarTabla(ResultSet rs){
       //recibo el rs del dao y actualizo la tabla en Mysql
       if (rs==null) {
           System.out.println("el rs vino vacio");
       }
        try {
            while (rs.next()) {
                //para cada fila de la consulta creo un pedido
                PedidoMaterial pedido = new PedidoMaterial();
                System.out.println("empezamos");
                pedido.setId(rs.getInt(1));
                pedido.setNumeroPedido(rs.getInt(2));
                pedido.setNotaDeVenta(rs.getInt(3));
                pedido.setDescripProyecto(rs.getString(4));
                pedido.setCliente(rs.getString(5));
                pedido.setCantidadPedida(rs.getLong(6));
                pedido.setCantidadModificada(rs.getLong(7));
                Calendar fecha = Calendar.getInstance();
                fecha.setTime(rs.getDate(8));
                pedido.setUltimaActualizacionDespiece(fecha);
                pedido.setArticulo(rs.getString(9));
                pedido.setAriCod(rs.getString(10));
                pedido.setArea(rs.getString(11));
                pedido.setUnidadOrg(rs.getInt(12));
                pedido.setTarea(rs.getString(13));
                pedido.setCantidadAPD(rs.getLong(14));
                if (rs.getDate(15) != null) {
                    fecha.setTime(rs.getDate(15));
                    pedido.setFechaAsignacion(fecha); 
                }
                pedido.setCantidadFinalP(rs.getLong(16));
                pedido.setCantidadRealU(rs.getLong(17));
                pedido.setTareaCod(rs.getInt(18));
                fecha.setTime(rs.getDate(19));
                pedido.setFechaUti(fecha);
                fecha.setTime(rs.getDate(20));
                pedido.setFechaFinUtili(fecha);
                
                guardarPedido(pedido);
                
                
            }
        } catch (SQLException ex) {
            
            System.out.println(ex.toString());
        }
   }
   
   public List<JsonObject> notasDeVentas(){
       //creo un json para enviarlo  la vista un array de lista de proyectos
       String nv[][]= pedidoMaterialRepository.buscarNotaVenta();
       List<JsonObject> js = new ArrayList<JsonObject>();
       
        for (int i=0;i<nv.length;i++){
            
            JsonObject jo = new JsonObject();
            jo.put("notaDeVenta", nv[i][0]);
            jo.put("descripcion", nv[i][1]);
            jo.put("cliente", nv[i][2]);
            js.add(jo);
        }
   
   return js;
   }
   
   public void llenarTabla(){
       //metodo que actualiza la tabla del mysql con mssql
       pedidoMatDao.llenarTabla();
   }
   
   public List<PedidoMaterialModel> findAll(){
       //devielve un modelo a la vista  de pedidos de materiales
   
       List<PedidoMaterialModel> pedidosM = new ArrayList<>();
       
       return pedidosM = pedidoMaterialConverter.entitiesToModels(pedidoMaterialRepository.findAll());
   }
    
}