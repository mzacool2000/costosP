/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.controler;

import com.costos.api.rest.models.ArticuloModel;
import com.costos.api.rest.models.PedidoMaterialModel;
import com.costos.api.rest.models.VentaModel;
import com.costos.api.rest.service.ArticuloService;
import com.costos.api.rest.service.ArticuloVentaService;
import com.costos.api.rest.service.PedidoMaterialServicio;
import com.costos.api.rest.service.VentaService;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chiri
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/")
public class PedidoMaterialControler {

    @Autowired
    private PedidoMaterialServicio pedidoMaterialServicio;
    @Autowired
    private ArticuloService articuloService;
    @Autowired
    private VentaService ventaService;
    @Autowired
    private ArticuloVentaService articuloVentaService;
    

             

    @GetMapping("/getall")
    /*
    *actualiza las tablas del MSSQL a Mysql de pedidos de materiales
    */
    
    public List<PedidoMaterialModel> index (){
        pedidoMaterialServicio.llenarTabla();
        return pedidoMaterialServicio.findAll();
    }
    @GetMapping("/getallV")
    public List<VentaModel> indexV (){
    /*
    *actualiza las tablas del MSSQL a Mysql de ventas
    */
    
        ventaService.llenar();
        articuloVentaService.llenar();
       // System.out.println("la llene te la paso");
        return  ventaService.findall();
       
    }
    @GetMapping("/getallA")
    public List<ArticuloModel> indexA(){
    /*
    *actualiza las tablas del MSSQL a Mysql de pedidos de compras
    */
    
        articuloService.llenarTabla();
        
        return articuloService.findAll();
    }
    @GetMapping("/notaDeVenta")
    /*
    *envia una lista de los proyectos en json
    */
    
    public List<JsonObject> indexN(){
    
    return pedidoMaterialServicio.notasDeVentas();
    }
}
