/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.controler;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chiri
 */
@RestController
@RequestMapping("/test")
public class TestRestController {
    /*
    esto es una prueba
    */
    
    
    public Map<String,String> response;
    
    @GetMapping("/get")
    public ResponseEntity<?> test(){
        response = new HashMap();
        response.put("OK","OK");
        return ResponseEntity.status(200).body(response);
        
    }
    
    
}
