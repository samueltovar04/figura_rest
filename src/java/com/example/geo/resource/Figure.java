/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geo.resource;

/**
 *
 * @author stovar
 */
public interface Figure {
    
    /**
     *
     * @param area
     */
    public void setArea(double area);
    public double getArea();
    public void setBase(double base);
    public double getBase();
    public void setHeight(double heigth);
    public double getHeight();
    public void setDiametro(double diametro);
    public double getDiametro();
    public void setSurface(double surface);
    public double getSurface();
    public void setType(String type);
    public String getType();
    public abstract double calculateArea();
    
}
