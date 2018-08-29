/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geo.model;

import com.example.geo.resource.Figure;


/**
 *
 * @author stovar
 */


public abstract class AbstractFigure implements Figure{

    private Integer id;

    private double base;
    private double height;
    private double diametro;
    private double surface;
    private double area;
    private String type;

    public AbstractFigure() {
    }

    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public void setArea(double area){
        this.area = area;
    }
    
    @Override
    public double getArea(){
        return this.area;
    }

    @Override
    public double getSurface() {
        return surface;
    }

    @Override
    public void setSurface(double sourface) {
        this.surface = sourface;
    }
    
    @Override
    public void setBase(double base) {
        this.base= base;
    }
    
    @Override
    public double getBase() {
       return this.base;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getHeight() {
       return this.height;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }
    
    @Override
    public void setDiametro(double diametro){
      this.diametro = diametro;
    }
    
    
    @Override
    public double getDiametro(){
        return this.diametro;
    }
    
    
    
    @Override
    public abstract double calculateArea();
    
}
