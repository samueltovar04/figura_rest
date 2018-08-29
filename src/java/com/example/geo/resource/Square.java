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
public class Square extends FigureModel {

    public Square() {
        
    }
    
    public Square(double surface,String type) {
        this.setSurface(surface);
        this.setType(type);
    }


    @Override
    public double calculateArea() {
        return (this.getSurface() * this.getSurface());
    }

   
}
