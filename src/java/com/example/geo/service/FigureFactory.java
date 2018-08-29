/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geo.service;

import com.example.geo.resource.Circle;
import com.example.geo.resource.Triangle;
import com.example.geo.resource.Square;
import com.example.geo.resource.Figure;

/**
 *
 * @author stovar
 */
public class FigureFactory {

    public FigureFactory() {
    }
    
    
 public static Figure getFigure(int type, double input) {
  try{
    switch (type) {
     case 1:
      return new Circle(input,"Circulo");
     case 2:
      return new Square(input,"Cuadrado");
     default :
      return new Triangle(type,input,"Triangulo");
    }
  }catch (NullPointerException ex){
             
            return null;
  }
 }
    
}
