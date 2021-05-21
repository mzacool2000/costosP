/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.dao;

import com.costos.api.rest.service.PedidoMaterialServicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author chiri
 */
@Component("PedidoMatDao")
public class PedidoMatDao {
    @Autowired
    private PedidoMaterialServicio pedidoMaterialServicio;
   
    
     @Scheduled(cron = "0 5 13 * * *")
    public void llenarTabla(){
     //conecta con pedidos de materiales y actualiza con un shuler a las 5am
        
        Connection con = null;
    
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String urls = "jdbc:sqlserver://ip\\server:puerto;databaseName="";user="";password="";";
             con = DriverManager.getConnection(urls);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * FROM [Delfos_PROD].[dbo].[ViewCuboPedidoMateriales]");
            System.out.println("tengo la consulta la paso al servicio");
            pedidoMaterialServicio.llenarTabla(rs);
            } catch (Exception e) {
                System.out.println(e);
            }
    
}
    
    
}
