/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stovar
 */

@Entity
@Table(name = "figures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FigureModel.findAll", query = "SELECT u FROM FigureModel u"),
    @NamedQuery(name = "FigureModel.findById", query = "SELECT u FROM FigureModel u WHERE u.id = :id"),
    @NamedQuery(name = "FigureModel.findByArea", query = "SELECT u FROM FigureModel u WHERE u.type = :type")})
    public class FigureModel extends AbstractFigure implements Serializable {
     
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "area")
    private double area;
    @Column(name = "type")
    private String type;
    @Column(name = "base")
    private double base;
    @Column(name = "height")
    private double height;
    @Column(name = "diametro")
    private double diametro;
    @Column(name = "surface")
    private double surface;
    

    public FigureModel(Integer id) {
        super.setId(id);
    }

    public FigureModel(double area, String type, double base, double height, double diametro, double surface) {
        this.area = area;
        this.type = type;
        this.base = base;
        this.height = height;
        this.diametro = diametro;
        this.surface = surface;
    }

    public FigureModel() {
    }
    
    
         @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.type.hashCode();
        return hash;
    }

    @Override
    public String toString() {
       // return "com.example.geo.model.FigureModel[ id=" + id  + ", base=" + base + ", type=" + type + ", diametro=" + diametro + ", height=" + height + ", area=" + area+ " ]";
        return "{"+ "\"surface\":\"" + surface + "\"," + "\"base\":\"" + base + "\", \"type\":\"" + type + "\", \"diametro\":\"" + diametro + "\", \"height\":\"" + height + "\", \"area\":\"" + area + "\"}";
    }

       @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FigureModel)) {
            return false;
        }
       /* FigureModel other = (FigureModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }*/
        return true;
    }

   
    @Override
    public double calculateArea() {
        return 0.0;
    }
    
}
