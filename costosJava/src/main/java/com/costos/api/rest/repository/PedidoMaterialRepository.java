/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.repository;

import com.costos.api.rest.entity.PedidoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiri
 */
@Repository
public interface PedidoMaterialRepository extends JpaRepository<PedidoMaterial,Integer>{
    
    //devuelve notas de ventas con sus despcriciones con pedidos de materiales activos
    @Query("SELECT p.notaDeVenta,p.descripProyecto, p.cliente FROM PedidoMaterial p group by p.notaDeVenta")
    public String[][] buscarNotaVenta();    
    

    
}
