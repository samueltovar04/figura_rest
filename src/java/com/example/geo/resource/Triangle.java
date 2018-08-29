/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geo.resource;

import com.example.geo.model.FigureModel;

/**
 *
 * @author stovar
 */
public class Triangle extends FigureModel {

    public Triangle() {
    }

    public Triangle(double base, double height, String type) {
        this.setBase(base);
        this.setHeight(height);
        this.setType(type);
    }

    @Override
    public double calculateArea() {
        return (this.getBase() * this.getHeight()) * 0.5;
    }    

    

}
