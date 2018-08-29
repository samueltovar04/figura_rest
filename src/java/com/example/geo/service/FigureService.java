/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geo.service;

import com.example.geo.dao.AbstractFacade;
import com.example.geo.model.FigureModel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stovar
 */
@Stateless
public class FigureService extends AbstractFacade<FigureModel>{
    @PersistenceContext(unitName = "figurarestapiPU")
    private EntityManager em;

    public FigureService() {
        super(FigureModel.class);
    }
    @Override
    public Boolean create(FigureModel entity) {
        FigureModel entities = new FigureModel(entity.getArea(), entity.getType(),entity.getBase(), entity.getHeight(), entity.getDiametro(), entity.getSurface());
        return super.create(entities);
    }
    
    public void edit(Integer id, FigureModel entity) {
        super.edit(entity);
    }
    
    public FigureModel find(Integer id) {
        return super.find(id);
    }
    
    @Override
    public List<FigureModel> findAll() {
        return super.findAll();
    }
    
    @Override
    public List<FigureModel> findWithQuery(String sql){
        return super.findWithQuery(sql);
    }
    
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

