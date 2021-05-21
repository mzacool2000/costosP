/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.dao;

import com.costos.api.rest.entity.Venta;
import com.costos.api.rest.service.ArticuloVentaService;
import com.costos.api.rest.service.VentaService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author chiri
 */
@Component("VentaDao")
public class VentaDao {
    
    @Autowired
    private VentaService ventaService;
    @Autowired
    private ArticuloVentaService articuloVentaService;
    
    
    public void llenarTabla() {
        //conecta con tabla de proyectos para actualizar en el local

        Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String urls = "jdbc:sqlserver://ip\\server:puerto;databaseName="";user="";password="";";
            con = DriverManager.getConnection(urls);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT     ClienteCodi, ClienteRazon, Provincia, Pais, Cotizacion, NumeroCotizacion, EstadoCotizacion, FechaDeAdjudicacion, FechaPresupuesto, Usuario\n" +
                                            " FROM dbo.ViewCuboVenta\n" +
                                            " GROUP BY NumeroCotizacion, ClienteCodi, ClienteRazon, Provincia, Pais, Cotizacion, EstadoCotizacion, FechaDeAdjudicacion, FechaPresupuesto, Usuario");
            System.out.println("tengo la consulta la paso al servicio");
           ventaService.llenarTabla(rs);
           
        } catch (Exception e) {
            e.printStackTrace();
        }

}
    
}
