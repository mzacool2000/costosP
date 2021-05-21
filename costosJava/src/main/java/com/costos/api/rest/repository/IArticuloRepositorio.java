/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.repository;

import com.costos.api.rest.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiri
 */
@Repository
public interface IArticuloRepositorio extends JpaRepository<Articulo, Long>{
    
}
