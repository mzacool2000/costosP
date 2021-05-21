/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costos.api.rest.converters;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author chiri
 */
public abstract class Converter<M extends Object, E extends Object>{
    
    public abstract E modelToEntity(M m);
    public abstract M entityToModel(E e);
    public abstract List<E> modelsToEntities(List<M> m);
    public abstract List<M> entitiesToModels(List<E> e);
    protected Log log;
    public Converter() {
        this.log = LogFactory.getLog(getClass());
    }
    
    
}
