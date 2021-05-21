/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.dao;

import com.costos.api.rest.service.ArticuloVentaService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author chiri
 */
@Component("ArticulosVentaDao")
public class ArticulosVentaDao {
    @Autowired
    private ArticuloVentaService articuloVentaService;
    
    public void llenarTabla(){
        //conecta con tabla de articulos vendidos
        
         Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String urls = "jdbc:sqlserver://ip\\server:puerto;databaseName="";user="";password=";
            con = DriverManager.getConnection(urls);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT NumeroCotizacion, ArtiCodi, ArtiCodiCompuesto, ArtiDescrip, [Potencia Cotización], [Tensión Primaria Cotización], Cantidad, moneda, cambio, Precio\n" +
                                            "FROM     dbo.ViewCuboVenta\n" +
                                            "WHERE  (NOT (ArtiCodi IS NULL))");
            System.out.println("tengo la segunda la paso al servicio");
        
           articuloVentaService.llenarTabla(rs);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    
    
    
    
    }
}
