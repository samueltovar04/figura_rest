package com.example.geo.resource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.example.geo.model.FigureModel;

/**
 *
 * @author stovar
 */
public class Circle extends FigureModel {

    public Circle() {
        
    }
    
    public Circle(double diametro, String type) {
        this.setDiametro(diametro);
        this.setType(type);
    }

    @Override
    public double calculateArea() {
        return (this.getDiametro()) * Math.PI;
    }
}
